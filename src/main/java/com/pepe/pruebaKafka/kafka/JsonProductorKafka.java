package com.pepe.pruebaKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.pepe.pruebaKafka.Models.Usuario;

@Service
public class JsonProductorKafka {
	private static final Logger LOGGER 
	= LoggerFactory
	.getLogger(JsonProductorKafka.class);
	KafkaTemplate<String,Usuario> kafkaTemplate;
	public JsonProductorKafka(KafkaTemplate<String,Usuario> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	public void enviarMensaje(Usuario usu) {
		LOGGER.info(String.format("Mensaje enviado: %s", usu.toString()));
		Message<Usuario> mensaje =
				MessageBuilder
				.withPayload(usu)
				.setHeader(KafkaHeaders.TOPIC,"nombrecitoTpc")
				.build();
		kafkaTemplate.send(mensaje);
	}
}
