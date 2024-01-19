
public class Mandelbrot {
	private int height;
	private int width;
	private int iteration;
	private double thresholdSq;
	private double pixelSize;
	private double topLeftRe;
	private double topLeftIm;
	private int[][] data;

	public Mandelbrot(int[][] data, double startRe, double startIm, double zoom, double threshold) {
		this.data = data;
		this.height = data.length;
		this.width = data[0].length;
		this.iteration = (int)(50 * zoom);//iteration;
		this.thresholdSq = threshold * threshold;
		this.pixelSize = Math.pow(2, -zoom) *  (3.0 / width);
		this.topLeftRe = -(width / 2 ) * pixelSize + startRe;
		this.topLeftIm = -(height / 2 ) * pixelSize + startIm;
	}

	private volatile int activeThreads = 0;
	public void calcData() {
		int threads = 6; // Anzahl der zu verwendenden Threads
		int rowsPerThread = height / threads; // Anzahl der Zeilen, die ein Thread berechnen soll
		activeThreads = threads;

		for (int i = 0; i < threads; i++) {
			int from = i * rowsPerThread;
			int to = (i == threads - 1) ? height : (i + 1) * rowsPerThread;
			new Thread(new Worker(this, from, to)).start();
		}
	}

	public synchronized void setData(int[][] dataFraction, int from) {
		for (int i = 0; i < dataFraction.length; i++) {
			data[i + from] = dataFraction[i];
		}
		activeThreads--;
	}

	private double getNoOfIterations(double re, double im) {
		ComplexNumber c = new ComplexNumber(re, im);
		ComplexNumber z = new ComplexNumber(re, im);
		for (int i = 0; i < iteration; i++) {
			if (z.getMagnitudeSquared() > thresholdSq) {
				return i / 2500.0;
			}
			z.square();
			z.add(c);
		}
		return 0;
	}

	public synchronized boolean isBusy() {
		return activeThreads > 0;
	}

	private class Worker implements Runnable {
		Mandelbrot mandelbrot;
		int from;
		int to;

		Worker(Mandelbrot mandelbrot, int from, int to) {
			this.mandelbrot = mandelbrot;
			this.from = from;
			this.to = to;
		}

		@Override
		public void run() {
			int[][] tempData = new int[to - from][width];

			for (int y = from; y < to; y++) {
				for (int x = 0; x < width; x++) {
					tempData[y - from][x] = (int)(0xffffff * getNoOfIterations(x * pixelSize + topLeftRe, y * pixelSize + topLeftIm));
				}
			}

			mandelbrot.setData(tempData, from);
		}
	}

}
