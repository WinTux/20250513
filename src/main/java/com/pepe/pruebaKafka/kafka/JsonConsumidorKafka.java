package com.pepe.pruebaKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pepe.pruebaKafka.Models.Usuario;

@Service
public class JsonConsumidorKafka {
	private static final Logger LOGGER 
	= LoggerFactory
	.getLogger(JsonConsumidorKafka.class);
	@KafkaListener(topics="jsonTpc", groupId="miGrupito")
	public void consumir(Usuario mensaje) {
		LOGGER.info("Mensaje JSON recibido: "+mensaje.toString());
	}
}
