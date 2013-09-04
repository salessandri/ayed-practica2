public class ListaDeEnterosEnlazada extends ListaDeEnteros
{
	private NodoEntero inicio;
	private NodoEntero actual;

	public ListaDeEnterosEnlazada() {
		actual = null;
		inicio = null;
	}

	public void comenzar() {
		actual = inicio;
	}

	public Object takeLast() {
		Object answer = new Object();
		NodoEntero aBorrar = new NodoEntero();
		this.comenzar();
		while (!this.end()) {
			answer = this.getactual().getDato();
			aBorrar = actual;
			this.next();
		}
		actual = aBorrar;
		this.remove();
		return (answer);
	}

	public void addinicio(Integer element) {
		this.comenzar();
		this.add(element);
	}

	
	/*
	public void add(Integer elem) {
		NodoEntero temp;
        temp = new NodoEntero(elem);
        if (inicio == null)
            inicio = temp;
        else {
            if (inicio != null && actual == null) {
                temp.setNext(inicio);
                inicio = temp;
            } else {
                if (inicio != null && actual != null && inicio == actual) {
                    temp.setNext(inicio);
                    inicio = temp;
                } else {
                    if (inicio != null && actual != null && inicio != actual) {
                        this.previous(actual).setNext(temp);
                        temp.setNext(actual);
                    }
                }
            }
        }
    }
*/
	public void addLast(Integer element) {
		NodoEntero temp;
      temp = new NodoEntero(element);
      
      if (inicio == null){
         inicio = temp;
      }
      else {
    	  NodoEntero ultimo = new NodoEntero();
         this.comenzar();
		 while (!this.end()) {
			ultimo = this.getactual();
			this.next();
		 }
		 ultimo.setSiguiente(temp);
      }
	}
	
	
	public int length() {
		int answer = 0;
		this.comenzar();
		while (!this.end()) {
			answer++;
			this.next();
		}
		return (answer);
	}

	public void next() {
		actual = actual.getSiguiente();
	}

	public boolean end() {
		return actual == null;
	}

	public Object get() {
		return actual.getDato();
	}

	public void add(Integer elem) {
		NodoEntero temp;
		temp = new NodoEntero(elem);
		if (inicio == null)
			inicio = temp;
		else {
			if (inicio != null && actual == null) {
				temp.setSiguiente(inicio);
				inicio = temp;
			} else {
				if (inicio != null && actual != null && inicio == actual) {
					temp.setSiguiente(inicio);
					inicio = temp;
				} else {
					if (inicio != null && actual != null && inicio != actual) {
						this.previous(actual).setSiguiente(temp);
						temp.setSiguiente(actual);
					}
				}
			}
		}
	}

	private NodoEntero previous(NodoEntero node) {
		if (inicio == node)
			return null;
		else {
			NodoEntero previous = inicio;
			while (previous.getSiguiente() != node)
				previous = previous.getSiguiente();
			return previous;
		}
	}

	public void remove() {
		if (actual != null) {
			if (actual == inicio)
				inicio = inicio.getSiguiente();
			else {
				this.previous(actual).setSiguiente(actual.getSiguiente());
			}
		}
	}

	public void remove(Object elem) {
		NodoEntero previousNode;
		this.find(elem);
		previousNode = this.previous(actual);
		if (previousNode != null)
			previousNode.setSiguiente(actual.getSiguiente());
		else
			inicio = actual.getSiguiente();
		    actual = null; // agregue esto, sino queda referenciando al nodo
		// borrado
	}

	//private void find(Object elem) {
	//	this.begin();
	//	while (!this.end() && this.getactual().getData() != elem)
	//		this.next();
	//}
	
	private void find(Object elem) {// no me interesa q apunten al mismo objeto, sino q el contenido sea el mismo!!!
		this.comenzar();  
		while (!this.end() && !this.getactual().getDato().equals(elem))
			       this.next();
	
	}
	
	public boolean isEmpty() {
		return inicio == null;
	}

	public boolean includes(Object elem) {
		this.find(elem);
		return (actual != null);
	}

	public NodoEntero getactual() {
		return actual;
	}
	
	public NodoEntero getinicio() {
        return inicio;
    }
}
