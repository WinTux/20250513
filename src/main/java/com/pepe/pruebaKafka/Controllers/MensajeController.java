package com.pepe.pruebaKafka.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepe.pruebaKafka.Models.Usuario;
import com.pepe.pruebaKafka.kafka.JsonProductorKafka;
import com.pepe.pruebaKafka.kafka.ProductorKafka;

@RestController
@RequestMapping("/api") // http://localhost:8080/api
public class MensajeController {

	private ProductorKafka productorKafka;
	private JsonProductorKafka jsonProductorKafka;
	public MensajeController(ProductorKafka productorKafka, JsonProductorKafka jsonProductorKafka) {
		super();
		this.productorKafka = productorKafka;
		this.jsonProductorKafka = jsonProductorKafka;
	}
	@GetMapping("/publicar") // http://locahost:8080/api/publicar?msg=Hola [GET]
	public ResponseEntity<String> getMensaje(@RequestParam("msg") String mensaje){
		productorKafka.enviarMensaje(mensaje);
		return ResponseEntity.ok("Registrado a kafka");
	}
	@PostMapping("/publicar") // http://locahost:8080/api/publicar [POST]
	public ResponseEntity<String> publicarJson(@RequestBody Usuario u){
		jsonProductorKafka.enviarMensaje(u);
		return ResponseEntity.ok("Se envió el mensaje json al topic kafka");
	}
}
