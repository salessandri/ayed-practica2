package ejercicio6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class ListaEnlazadaGenericaTest {

	ListaEnlazadaGenerica<Integer> l;
	
	@Before
	public void setUp() throws Exception {
		l = new ListaEnlazadaGenerica<Integer>();
	}

	@Test
	public void testComenzar() {
		//Probando con un elemento
		l.agregar(0, 0);
		l.comenzar();
		assertEquals(new Integer(0), l.elemento());
		
		//Probando con dos elementos
		l.agregar(1, 1);
		l.comenzar();
		assertEquals(new Integer(0), l.elemento());
		
		//Probando de agregar un elemento al principio
		l.agregar(2, 0);
		l.comenzar();
		assertEquals(new Integer(2), l.elemento());
		
		
	}

	@Test
	public void testProximo() {
		for (int i = 0; i < 100; i++)
			l.agregar(i, i);
		l.comenzar();
		for (int i = 0; i < 100; i++) {
			assertEquals(new Integer(i), l.elemento());
			l.proximo();
		}
		assertTrue(l.fin());
			
	}

	@Test
	public void testElementoInt() {
		for (int i = 0; i < 100; i++)
			l.agregar(i, i);
		for (int i = 99; i >= 0; i--)
			assertEquals(new Integer(i), l.elemento(i));
	}

	@Test
	public void testAgregar() {
		//No se puede agregar en indices negativos
		assertFalse(l.agregar(1, -1));
		assertEquals(0, l.tamanio());
		
		//Test de agregar al principio cuando no hay nada
		assertTrue(l.agregar(2, 0));
		assertEquals(new Integer(2), l.elemento(0));
		assertEquals(1, l.tamanio());
		
		//Test de agregar al principio cuando hay algo
		assertTrue(l.agregar(0, 0));
		assertEquals(new Integer(0), l.elemento(0));
		assertEquals(new Integer(2), l.elemento(1));
		assertEquals(2, l.tamanio());
		
		//Test de agregar entremedio
		assertTrue(l.agregar(1, 1));
		assertEquals(new Integer(0), l.elemento(0));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(2), l.elemento(2));
		assertEquals(3, l.tamanio());
		
		//Test de agregar al final
		assertTrue(l.agregar(3, 3));
		assertEquals(new Integer(0), l.elemento(0));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(2), l.elemento(2));
		assertEquals(new Integer(3), l.elemento(3));
		assertEquals(4, l.tamanio());
		
		//Test de agregar despues del final
		assertFalse(l.agregar(4, 5));
		assertEquals(new Integer(0), l.elemento(0));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(2), l.elemento(2));
		assertEquals(new Integer(3), l.elemento(3));
		assertEquals(4, l.tamanio());
		
	}

	@Test
	public void testEliminar() {
		//No se puede eliminar si no hay nada
		assertFalse(l.eliminar());
		assertEquals(0, l.tamanio());
		
		//Test eliminar el unico elemento que hay
		l.agregar(0, 0);
		l.comenzar();
		assertTrue(l.eliminar());
		assertEquals(0, l.tamanio());
		
		for (int i = 0; i < 10; i++)
			l.agregar(i, i);

		//Test eliminar el primer elemento cuando hay mas
		l.comenzar();
		assertTrue(l.eliminar());
		assertEquals(9, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//Test eliminar un elemento del medio
		l.agregar(1, 1);
		l.comenzar();
		l.proximo();
		assertTrue(l.eliminar());
		assertEquals(9, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//Test eliminar el ultimo elemento
		l.comenzar();
		for (int i = 0; i < 8; i++)
			l.proximo();
		assertTrue(l.eliminar());
		assertEquals(8, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//Test de eliminar luego de haber recorrido todo.
		l.comenzar();
		while (!l.fin())
			l.proximo();
		assertFalse(l.eliminar());
		assertEquals(8, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		
	}

	@Test
	public void testEliminarInt() {
		//No se puede borrar indices negativos
		assertFalse(l.eliminar(-1));
		assertEquals(0, l.tamanio());
		
		//Test eliminar el unico elemento que hay
		l.agregar(0, 0);
		assertTrue(l.eliminar(0));
		assertEquals(0, l.tamanio());
		
		for (int i = 0; i < 10; i++)
			l.agregar(i, i);

		//Test eliminar el primer elemento cuando hay mas
		assertTrue(l.eliminar(0));
		assertEquals(9, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//Test eliminar un elemento del medio
		l.agregar(1, 1);
		assertTrue(l.eliminar(1));
		assertEquals(9, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//Test eliminar el ultimo elemento
		assertTrue(l.eliminar(8));
		assertEquals(8, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
		//No se puede eliminar un indice >= tamaño.
		assertFalse(l.eliminar(8));
		assertEquals(8, l.tamanio());
		for (int i = 0; i < l.tamanio(); i++)
			assertEquals(new Integer(i + 1), l.elemento(i));
		
	}

	@Test
	public void testIncluye() {
		//No se tiene que poder encontrar algo cuando la lista esta vacia
		assertFalse(l.incluye(0));
		
		//Test de busqueda sobre el primer elemento
		l.agregar(0, 0);
		assertTrue(l.incluye(0));
		assertFalse(l.incluye(1));
		
		//Test con mas elementos
		l.agregar(1, 1);
		l.agregar(2, 2);
		assertTrue(l.incluye(1));
		assertFalse(l.incluye(4));
		
	}

	@Test
	public void testFin() {
		l.comenzar();
		assertTrue(l.fin());
		
		l.agregar(0, 0);
		l.comenzar();
		assertFalse(l.fin());
		l.proximo();
		assertTrue(l.fin());
		
		l.agregar(1, 1);
		l.comenzar();
		assertFalse(l.fin());
		l.proximo();
		assertFalse(l.fin());
		l.proximo();
		assertTrue(l.fin());

	}
	
	@Test
	public void testEsVacia() {
		assertTrue(l.esVacia());
		l.agregar(0,0);
		assertFalse(l.esVacia());
		l.agregar(0, 0);
		assertFalse(l.esVacia());
		l.eliminar(0);
		assertFalse(l.esVacia());
		l.eliminar(0);
		assertTrue(l.esVacia());
	}
	
}
