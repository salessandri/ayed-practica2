package ejercicio1;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ListaDeEnterosEnlazadaTest extends TestCase {
	ListaDeEnterosEnlazada l;
	protected void setUp() throws Exception {
		super.setUp();
		l = new ListaDeEnterosEnlazada();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testComenzar() {
		fail("Not yet implemented");
	}

	public void testProximo() {
		fail("Not yet implemented");
	}

	public void testElemento() {
		fail("Not yet implemented");
	}

	public void testElementoInt() {
		fail("Not yet implemented");
	}

	public void testAgregar() {
		//Se agrega 321
    	l.agregar(1,0);
    	l.agregar(2,0);
		l.agregar(3,0);
		
        l.comenzar();
    	Assert.assertEquals(l.elemento(),(Integer)3);
    	l.proximo();
    	Assert.assertEquals(l.elemento(),(Integer)2);
    	l.proximo();
    	Assert.assertEquals(l.elemento(),(Integer)1);
    	l.proximo();
	}

	public void testEliminar() {
		fail("Not yet implemented");
	}

	public void testEliminarInt() {
//   	 genera 231 luego de generar 21
		    l.agregar(1,0);
	        l.agregar(2,0);
	        l.agregar(3,1);
 
//	 elimina 3, el del medio, imprime 21
			l.eliminar(1);
			l.comenzar();
		    Assert.assertEquals(l.elemento(),(Integer)2);
		    l.proximo();
		    Assert.assertEquals(l.elemento(),(Integer)1);
	}

	public void testIncluye() {
		fail("Not yet implemented");
	}

	public void testFin() {
		fail("Not yet implemented");
	}

}
