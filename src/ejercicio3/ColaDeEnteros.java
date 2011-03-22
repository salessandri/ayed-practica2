package ejercicio3;

import ejercicio1.ListaDeEnteros;
import ejercicio1.ListaDeEnterosEnlazada;

public class ColaDeEnteros {

	private ListaDeEnteros datos;
	
	public ColaDeEnteros() {
		datos = new ListaDeEnterosEnlazada();
	}
	
	public void poner(int dato) {
		datos.agregar(dato, datos.tamanio());
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
