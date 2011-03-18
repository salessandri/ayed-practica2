package ejercicio1;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {
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
		// TODO Auto-generated method stub

	}

	@Override
	void proximo() {
		// TODO Auto-generated method stub

	}

	@Override
	Integer elemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Integer elemento(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean agregar(Integer elem, int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean eliminar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean eliminar(int pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean incluye(Integer elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int tamanio() {
		// TODO Auto-generated method stub
		return 0;
	}

}
