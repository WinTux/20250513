package com.pepe.pruebaKafka.Configuraciones;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	@Bean
	public NewTopic DefinicionTopic(){
		return TopicBuilder
				.name("nombrecitoTpc")
				.build();
	}
	@Bean
	public NewTopic DefinicionJsonTopic(){
		return TopicBuilder
				.name("jsonTpc")
				.build();
	}
}
