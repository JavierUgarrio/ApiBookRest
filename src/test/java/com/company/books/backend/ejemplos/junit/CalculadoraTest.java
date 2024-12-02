package com.company.books.backend.ejemplos.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

	@BeforeAll
	public static void primeroTest() {
		System.out.println("Se ejecuta el primer test y solo una vez ");
	}
	
	@AfterAll
	public static void ultimoTest() {
		System.out.println("Se ejecuta el ultimo test y solo una vez ");
	}
	
	@Test
	public void calculadoraAssertEqualTest() {
		Calculadora cal = new Calculadora();
		
		assertEquals(4, cal.sumar(2,2));
		assertEquals(3, cal.restar(5, 2));
		assertEquals(5, cal.dividir(10, 2));
		assertEquals(25, cal.multiplicar(5, 5));
	}
	
	@Test
	public void calculadoraTest2() {
	
		Calculadora cal = new Calculadora();
		
		assertTrue(cal.sumar(2, 2) ==4);
		assertTrue(cal.restar(6, 2) ==4);
		assertTrue(cal.dividir(8, 2) ==4);
		assertTrue(cal.multiplicar(2, 2) ==4);
		
	}
	
	
}
