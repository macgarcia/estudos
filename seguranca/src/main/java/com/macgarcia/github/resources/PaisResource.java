package com.macgarcia.github.resources;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macgarcia.github.model.Pais;
import com.macgarcia.github.repositorys.PaisRepository;

@RestController
@RequestMapping(path = "/api/paises")
public class PaisResource {

	@Autowired
	private PaisRepository dao;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> recuperarTodosPaises() {

		List<Pais> paises = dao.findAll();
		return ResponseEntity.ok(paises);

	}

	@GetMapping(path = "/ordenado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> recuperarTodosPaisesEmOrdemAlfabetica() {

		List<Pais> paises = dao.findAll();
		List<Pais> paisesOrdenados = paises.stream()
				.sorted(Comparator.comparing(Pais::getNome))
				.collect(Collectors.toList());
		return ResponseEntity.ok(paisesOrdenados);

	}

}
