package kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import kafka.config.consumer.BooksTopicConsumerConfig;
import kafka.enums.Topics;

public class Consumer {

	public static void main(String[] args) {

		//String fileName = "target\\kafka\\Messages.txt";
		// Create Producer config
		Properties config = BooksTopicConsumerConfig.getConfig();

		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(config);

		kafkaConsumer.subscribe(Arrays.asList(Topics.Books.getTopicName()));
		boolean flag = true;
		while (flag) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
			records.forEach(record->System.out.println("key: "+ record.key()+ ", value: "+record.value()));
		}
		kafkaConsumer.close();

	}

}
