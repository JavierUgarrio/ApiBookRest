package com.company.books.backend.ejemplos.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertArraysEqualsTeoria {

	@Test
	public void pruebaArray() {
		String[]arre1 = {"a","b"};
		String[]arre2 = {"a","b"};
		String[]arre3 = {"c","b"};
	
		assertArrayEquals(arre1,arre2);
		assertArrayEquals(arre2,arre3);
	}
}
