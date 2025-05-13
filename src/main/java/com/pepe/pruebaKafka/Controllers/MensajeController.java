package com.pepe.pruebaKafka.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepe.pruebaKafka.kafka.ProductorKafka;

@RestController
@RequestMapping("/api") // http://localhost:8080/api
public class MensajeController {

	private ProductorKafka productorKafka;
	public MensajeController(ProductorKafka productorKafka) {
		super();
		this.productorKafka = productorKafka;
	}
	@GetMapping("/publicar") // http://locahost:8080/api/publicar?msg=Hola [GET]
	public ResponseEntity<String> getMensaje(@RequestParam("msg") String mensaje){
		productorKafka.enviarMensaje(mensaje);
		return ResponseEntity.ok("Registrado a kafka");
	}
}
