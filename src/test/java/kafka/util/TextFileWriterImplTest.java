package kafka.util;

import org.junit.BeforeClass;
import org.junit.*;

public class TextFileWriterImplTest {
	
	static FileWriter writer;
	private final String fileName = "target\\test\\TestOutput.txt";
	
	@BeforeClass
	public static void setup() {
		writer = new TextFileWriterImpl();
	}
	
	@Test
	public void testWriteData() {
		String data = "My String";
		writer.writeData(data.getBytes(), fileName);
		
	}

}
