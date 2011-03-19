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
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public void proximo() {
		actual = actual.getSiguiente();

	}

	@Override
	public Integer elemento() {
		return actual.getDato();
	}

	@Override
	public Integer elemento(int pos) {
		this.comenzar();
		while (pos-- > 0)
			this.proximo();
		return actual.getDato();
	}

	@Override
	public boolean agregar(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio())
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) {
			aux.setSiguiente(inicio);
			inicio = aux;
		}
		else {
			this.comenzar();
			while (--pos > 0)
				this.proximo();
			aux.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(aux);
		}
		return true;
	}

	@Override
	public boolean eliminar() {
		if (actual == null)
			return false;
		
		this.tamanio--;
		if (actual == inicio) {
			inicio = inicio.getSiguiente();
			return true;
		}
		else {
			NodoEntero p = inicio;
			while (p.getSiguiente() != actual)
				p = p.getSiguiente();
			p.setSiguiente(actual.getSiguiente());
			actual = p.getSiguiente();
			return true;
		}
	}

	@Override
	public boolean eliminar(int pos) {
		if (pos < 0 || pos >= this.tamanio())
			return false;
		this.tamanio--;
		if (pos == 0) {
			inicio = inicio.getSiguiente();
			return true;
		}
		this.comenzar();
		while (--pos > 0)
			this.proximo();
		actual.setSiguiente(actual.getSiguiente().getSiguiente());
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		this.comenzar();
		while (!this.fin() && !this.elemento().equals(elem))
			this.proximo();
		return !this.fin();
	
	}
	
	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean fin() {
		return (actual==null);
	}
}
