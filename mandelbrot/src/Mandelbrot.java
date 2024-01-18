
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
	
	public void calcData() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				data[y][x] = (int)(0xffffff * getNoOfIterations(x * pixelSize + topLeftRe, y * pixelSize + topLeftIm));
			}
		}
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
}
