package ejercicio1;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	private NodoEntero inicio;
	private NodoEntero actual;
	private class NodoEntero {
		private Integer dato;
		private NodoEntero siguiente;
		
		public Integer getDato() {
			return dato;
		}
		public void setDato(Integer dato) {
			this.dato = dato;
		}
		public NodoEntero getSiguiente() {
			return siguiente;
		}
		public void setSiguiente(NodoEntero siguiente) {
			this.siguiente = siguiente;
		}
	
	}
	@Override
	void comenzar() {
		actual = inicio;
	}

	@Override
	void proximo() {
		actual = actual.getSiguiente();

	}

	@Override
	Integer elemento() {
		return null;
	}

	@Override
	Integer elemento(int pos) {
		return actual.getDato();
	}

	@Override
	boolean agregar(Integer elem, int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean eliminar() {
		if (actual != null) {
			if (actual == inicio)
				inicio = inicio.getSiguiente();
			else {
				this.previous(actual).setSiguiente(actual.getSiguiente());
			}
		}
	}

	@Override
	boolean eliminar(int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean incluye(Integer elem) {
		this.find(elem);
		return (actual != null);
	}

	private void find(Object elem) {// no me interesa q apunten al mismo objeto, sino q el contenido sea el mismo!!!
		this.comenzar();  
		while (!this.fin() && !this.elemento().getDato().equals(elem))
			       this.proximo();
	
	}
	
	@Override
	int tamanio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean fin() {
		return (actual==null);
	}
}
