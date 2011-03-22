package ejercicio6;

public class ListaEnlazadaGenerica<T> extends ListaGenerica<T> {

	private NodoGenerico inicio;
	private NodoGenerico actual;
	
	private class NodoGenerico {
		private T dato;
		private NodoGenerico siguiente;
		
		public T getDato() {
			return dato;
		}
		public void setDato(T dato) {
			this.dato = dato;
		}
		public NodoGenerico getSiguiente() {
			return siguiente;
		}
		public void setSiguiente(NodoGenerico siguiente) {
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
	public T elemento() {
		return actual.getDato();
	}

	@Override
	public T elemento(int pos) {
		this.comenzar();
		while (pos-- > 0)
			this.proximo();
		return actual.getDato();
	}

	@Override
	public boolean agregar(T elem, int pos) {
		if (pos < 0 || pos > this.tamanio())
			return false;
		this.tamanio++;
		NodoGenerico aux = new NodoGenerico();
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
			NodoGenerico p = inicio;
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
	public boolean incluye(T elem) {
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

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
}
