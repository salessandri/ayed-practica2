package ejercicio2;

import ejercicio1.ListaDeEnteros;
import ejercicio1.ListaDeEnterosEnlazada;

public class PilaDeEnteros {
	
	private ListaDeEnteros datos;
	
	public PilaDeEnteros() {
		datos = new ListaDeEnterosEnlazada();
	}
	
	public void poner(int dato) {
		datos.agregar(dato, 0);
	}
	
	public int sacar() {
		int x = datos.elemento(0);
		datos.eliminar(0);
		return x;
	}
	
	public int tope() {
		return datos.elemento(0);
	}
	
	public boolean esVacia() {
		return datos.tamanio() == 0;
	}
	
}
