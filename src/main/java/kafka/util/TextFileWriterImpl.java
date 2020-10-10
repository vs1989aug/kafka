package kafka.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileWriterImpl implements FileWriter{

	@Override
	public void writeData(byte[] data, String fileName) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
