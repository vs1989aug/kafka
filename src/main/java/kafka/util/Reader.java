package kafka.util;

public interface Reader {
	
	byte[] readData(String fileName, FileTypeEnum fileType);

}
