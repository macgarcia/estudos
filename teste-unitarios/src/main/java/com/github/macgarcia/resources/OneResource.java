package com.github.macgarcia.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class OneResource {
	
	@GetMapping
	public ResponseEntity<?> oneTest() {
		return ResponseEntity.ok("Iniciando");
	}
	
	@PostMapping
	public ResponseEntity<?> twoTest(@RequestBody final String s) {
		if ("S".equalsIgnoreCase(s)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.unprocessableEntity().build();
	}

}
