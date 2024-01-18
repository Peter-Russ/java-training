import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BitmapWriter {

	public static void main(String[] args) {
//		int height = 10;
//		int width = 21;
//		int[][] body = new int[height][width];
//		for (int[] row : body) {
//			for (int i = 0; i < row.length; i++) {
//				row[i] = 0x00ff00;
//			}
//		}
		int[][] body = buildChess(10);
		
		byte[] data = prepareBmp(body);
		
		try {
			writeData(data, "C:\\temp\\my.bmp");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int[][] buildChess(int fieldSize) {
		int[] color = {0x000000, 0xffffff};
		int[][] data = new int[8*fieldSize][8*fieldSize];
		for (int rowField = 0; rowField < 8; rowField++) {
			for (int r = 0; r < fieldSize; r++) {
				for (int colField = 0; colField < 8; colField++) {
					int fieldColor = color[(rowField + colField)%2]; 
					for (int c = 0; c < fieldSize; c++) {
						data[fieldSize*rowField + r][fieldSize*colField + c] = fieldColor;
					}
				}
			}
		}
		return data;
	}
	
	public static void writeData(byte[] data, String filePath) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(filePath, false)) {
			fos.write(data);
			fos.flush();
		}
	}
	
	public static void readData(String filePath) throws FileNotFoundException, IOException {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			byte[] inBuff = new byte[256];
			int readSize = 0;
			while((readSize = fis.read(inBuff)) != -1) {
				for (int i = 0; i < readSize; i++) {
					System.out.println(Integer.toHexString(inBuff[i] & 0xff));
				}
			}
		}
	}
	
	public static byte[] prepareBmp(int[][] body) {
		byte[] head = {
			0x42, 0x4d, // ASCII für BM 
			0x00, 0x00, 0x00, 0x00, // Dateigröße – Dummywert pos 2
			0x00, 0x00, 0x00, 0x00, // immer 00
			0x36, 0x00, 0x00, 0x00, // Offset Bilddaten
			0x28, 0x00, 0x00, 0x00, // Größe Infoheader
			0x00, 0x00, 0x00, 0x00, // Breite – Dummywert pos 18
			0x00, 0x00, 0x00, 0x00, // Höhe – Dummywert pos 22
			0x01, 0x00, // immer 01 00 
			0x18, 0x00, // Farbtiefe
			0x00, 0x00, 0x00, 0x00, // keine Komprimierung
			0x00, 0x00, 0x00, 0x00, // Größe Bilddaten – Dummywert pos 34
			0x00, 0x00, 0x00, 0x00, // Aufl. Hor. Standard 00
			0x00, 0x00, 0x00, 0x00, // Aufl. Vert. Standard 00
			0x00, 0x00, 0x00, 0x00, // Farbtabelleninfo 00
			0x00, 0x00, 0x00, 0x00 // Farbtabelleninfo 00
		};
		int height = body.length;
		int width = body[0].length; // kein Errorhandling!
		int noOfZeros = (4 - (body[0].length * 3 % 4)) % 4;
		int noOfImgBytes = body.length * (body[0].length * 3 + noOfZeros);
		int fileSize = 0x36 + noOfImgBytes;
		if (!setLittleEnd(2, fileSize, head)) { return null;}
		if (!setLittleEnd(18, width, head)) { return null;}
		if (!setLittleEnd(22, height, head)) { return null;}
		if (!setLittleEnd(34, noOfImgBytes, head)) { return null;}
		byte[] data = new byte[fileSize];
	  	int pos = 0;
		for (int i = 0; i < head.length; i++) {
			data[pos++] = head[i];
		}
		for (int r = 0; r < body.length; r++) {
			for (int c = 0; c < body[r].length; c++) {
				setLittleEnd(pos, body[r][c], data);
				pos += 3;
			}
			for (int z = 0; z < noOfZeros; z++) {
				data[pos++] = 0x00;
			}
		}			
		return data;
	}
	
	public static boolean setLittleEnd(int pos, int value, byte[] bytes) {
		byte writeValue;
		while(value > 0) {
			writeValue = (byte)(value);
			bytes[pos++] = writeValue;
			value >>= 8;
			if (pos >= bytes.length) {
				return false;
			}
		}
		return true;
	}
}
