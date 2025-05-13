package com.pepe.pruebaKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductorKafka {
	private static final Logger LOGGER 
	= LoggerFactory
	.getLogger(ProductorKafka.class);
	KafkaTemplate<String,String> kafkaTemplate;
	public ProductorKafka(KafkaTemplate<String,String> kafkaTemplate) {
		super();
		this.kafkaTemplate=kafkaTemplate;
	}
	public void enviarMensaje(String mensaje) {
		LOGGER.info(String.format("Mensaje enviado: %s", mensaje));
		kafkaTemplate.send("nombrecitoTpc",mensaje);
	}
}
