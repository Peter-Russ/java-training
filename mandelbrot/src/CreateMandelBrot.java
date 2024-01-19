import java.io.IOException;

public class CreateMandelBrot {

	public static void main(String[] args) throws IOException, InterruptedException {
		int[][] body = new int[1024][2048];
		Mandelbrot mdb = new Mandelbrot(body, 0.36001014891, 0.350001, 2, 10);
		mdb.calcData();
		while (mdb.isBusy()) {
			Thread.sleep(10);
		}
		byte[] data = BitmapWriter.prepareBmp(body);
		BitmapWriter.writeData(data, "C:\\Users\\peter\\Downloads\\mandelbrot.bmp");

	}
}


