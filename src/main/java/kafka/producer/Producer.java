package kafka.producer;

import java.util.Objects;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.config.producer.BooksTopicProducerConfig;
import kafka.enums.Topics;

public class Producer {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) throws InterruptedException {

		Producer producer = new Producer();

		// Create Producer config
		Properties config = BooksTopicProducerConfig.getConfig();

		// Create Kafka producer with config
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(config);
		
		int i=0;
		while(true) {
			Thread.sleep(2000);
			// create a Producer record
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(Topics.Books.getTopicName(),
					"Book"+i);

			producer.sendRecord(kafkaProducer, record);
			i++;
		}
		
//		kafkaProducer.close();
//		kafkaProducer.flush();
		
	}

	private void sendRecord(KafkaProducer<String, String> kafkaProducer, ProducerRecord<String, String> record) {
		kafkaProducer.send(record, (metadata, exception) -> {
			if (Objects.isNull(exception)) {
				logger.info(
						String.format("Record processed: "+record.value()+"\n On topic : [%s]" + ", on partition: [%s] and offset [%s] ",
								metadata.topic(), metadata.partition(), metadata.offset()));
			} else {
				logger.error("Could not process record.");
			}
		});
	}

}
