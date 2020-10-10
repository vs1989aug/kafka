package kafka.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileWriterStrategy {
	
	private static final Logger logger = LoggerFactory.getLogger(FileWriterStrategy.class);
	
	public static FileWriter getFileWriter(FileTypeEnum fileType) throws FileWriterNotFoundException {
		
		switch(fileType) {
		case CSV:
			logger.warn("File writer not implemented for file types: "+ fileType);
		case TEXT:
			return new TextFileWriterImpl();
		default:
			throw new FileWriterNotFoundException("File writer not found for file type: "+ fileType);
		}
	}

}
