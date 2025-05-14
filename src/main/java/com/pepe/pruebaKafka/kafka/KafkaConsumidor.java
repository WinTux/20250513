package com.pepe.pruebaKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumidor {
	private static final Logger LOGGER 
	= LoggerFactory
	.getLogger(KafkaConsumidor.class);
	@KafkaListener(topics="nombrecitoTpc", groupId="miGrupito")
	public void consumir(String mensaje) {
		LOGGER.info("Mensaje recibido: "+mensaje);
	}
}
