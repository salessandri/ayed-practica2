package ejercicio2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PilaDeEnterosTest {

	PilaDeEnteros c;
	
	@Before
	public void setUp() throws Exception {
		c = new PilaDeEnteros();
	}
	
	@Test
	public void testPoner() {
		c.poner(0);
		assertEquals(0, c.tope());
		c.poner(1);
		assertEquals(1, c.tope());
	}

	@Test
	public void testSacar() {
		try {
			c.sacar();
			fail("Deberia fallar con una null pointer exception");
		}
		catch (NullPointerException e) {
			
		}
		c.poner(0);
		assertEquals(0, c.sacar());
		try {
			c.sacar();
			fail("Deberia fallar con una null pointer exception");
		}
		catch (NullPointerException e) {
			
		}
		c.poner(0);
		c.poner(1);
		assertEquals(1, c.sacar());
		assertEquals(0, c.sacar());
		try {
			c.sacar();
			fail("Deberia fallar con una null pointer exception");
		}
		catch (NullPointerException e) {
			
		}
	}

	@Test
	public void testTope() {
		try {
			c.tope();
			fail("Deberia fallar con una null pointer exception");
		}
		catch (NullPointerException e) {
			
		}
		c.poner(0);
		assertEquals(0, c.tope());
		c.poner(1);
		assertEquals(1, c.tope());
		c.sacar();
		assertEquals(0, c.tope());
		c.sacar();
		try {
			c.tope();
			fail("Deberia fallar con una null pointer exception");
		}
		catch (NullPointerException e) {
			
		}
	}

	@Test
	public void testEsVacia() {
		assertTrue(c.esVacia());
		c.poner(0);
		assertFalse(c.esVacia());
		c.poner(1);
		assertFalse(c.esVacia());
		c.sacar();
		assertFalse(c.esVacia());
		c.sacar();
		assertTrue(c.esVacia());
	}

}
