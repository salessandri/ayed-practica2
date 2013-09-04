public class NodoEntero {
	private Integer dato;

	private NodoEntero siguiente;

	NodoEntero() {
	}

	NodoEntero(Integer elem) {
		dato = elem;
		siguiente = null;
	}

	NodoEntero getSiguiente() {
		return siguiente;
	}

	void setSiguiente(NodoEntero siguiente) {
		this.siguiente = siguiente;
	}

	Integer getDato() {
		return dato;
	}

	void setDato(Integer dato) {
		this.dato = dato;
	}
}
