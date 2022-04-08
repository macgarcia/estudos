package com.github.macgarcia.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Teste no controller one")
public class TestOneresource {

	@Autowired
	private OneResource resource;

	@Test
	@DisplayName("Teste inicial")
	@Order(1)
	void testResourceOne() {
		var oneTest = resource.oneTest();
		Assertions.assertTrue(oneTest.getBody() == "Iniciando");
		Assertions.assertFalse(oneTest.getBody() == "Ola");
	}

	@Test
	@DisplayName("Segundo Teste")
	@Order(2)
	void segundoTest() {
		var segundoTeste = resource.twoTest("s");
		Assertions.assertTrue(segundoTeste.getStatusCode().value() == 200);
		
		var otherTest = resource.twoTest("A");
		Assertions.assertFalse(otherTest.getStatusCode().value() == 200);
	}

}
