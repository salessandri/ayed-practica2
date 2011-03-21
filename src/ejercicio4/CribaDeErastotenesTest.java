package ejercicio4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ejercicio1.ListaDeEnteros;
import ejercicio1.ListaDeEnterosEnlazada;

public class CribaDeErastotenesTest {

	ListaDeEnterosEnlazada l;
	
	@Before
	public void setUp() throws Exception {
		l = new ListaDeEnterosEnlazada();
		for (int i = 1; i < 1001; i++)
			l.agregar(i, l.tamanio());
		
	}

	@Test
	public void testObtenerPrimos() {
		ListaDeEnteros res = new CribaDeErastotenes().obtenerPrimos(l);
		assertEquals(168, res.tamanio());
		
		int sum = 0;
		res.comenzar();
		while (!res.fin()) {
			sum += res.elemento();
			res.proximo();
		}
		assertEquals(76127, sum);
	}

}
