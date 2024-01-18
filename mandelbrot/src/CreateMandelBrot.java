import java.io.IOException;

public class CreateMandelBrot {

	public static void main(String[] args) throws IOException {
		int[][] body = new int[1024][2048];
		Mandelbrot mdb = new Mandelbrot(body, 0.36001014891, 0.350001, 2, 10);
		mdb.calcData();
		byte[] data = BitmapWriter.prepareBmp(body);
		BitmapWriter.writeData(data, "C:\\temp\\mandelbrot.bmp");
	}
}
