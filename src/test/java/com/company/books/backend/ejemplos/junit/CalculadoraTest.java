package com.company.books.backend.ejemplos.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

	@Test
	public void calculadoraAssertEqualTest() {
		Calculadora cal = new Calculadora();
		
		assertEquals(4, cal.sumar(2,2));
		assertEquals(3, cal.restar(5, 2));
		assertEquals(5, cal.dividir(10, 2));
		assertEquals(25, cal.multiplicar(5, 5));
	}
	
}
