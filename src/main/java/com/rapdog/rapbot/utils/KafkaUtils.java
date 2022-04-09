package com.rapdog.rapbot.utils;

import com.rapdog.rapbot.bean.bo.McUser;
import com.rapdog.rapbot.service.McUserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;


public class KafkaUtils {

    private static final Logger logger = LoggerFactory.getLogger(KafkaUtils.class);

    private static KafkaProducer<String, String> producer;

    private static void initProducer(){
        if (producer == null){
            // 发送kafka消息
            String servers = "81.70.59.107:9092";
            String topic = "TestTopic";
            logger.info("createing producer");
            producer = KafkaUtils.createProducer(servers);
        }
    }

    public static KafkaProducer<String, String> getProducer(){
        if (producer == null){
            initProducer();
        }
        return producer;
    }

    public static KafkaConsumer<String, String> createConsumer(String servers, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", servers);
        properties.put("group.id", "group-0");
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
        return kafkaConsumer;
    }

    public static void readMessage(KafkaConsumer<String, String> kafkaConsumer, int timeout) {
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(timeout);
            for (ConsumerRecord<String, String> record : records) {
                String value = record.value();
                kafkaConsumer.commitAsync();
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//                logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++read message:{}",value);
            }
        }
    }

    public static KafkaProducer<String, String> createProducer(String servers) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", servers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>(properties);
    }

    public static void send(KafkaProducer<String, String> producer, String topic, String message) {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }

    @Test
    public void readTest(){
        String servers = "81.70.59.107:9092";
        String topic = "TestTopic";
        logger.info("createing consumer");
        KafkaConsumer<String, String> consumer = createConsumer(servers, topic);
        logger.info("reading from consumer");
        readMessage(consumer, 100);
    }


}
