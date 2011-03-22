package ejercicio6;

public abstract class ListaGenerica<T> {
	
	protected int tamanio;
	
	abstract public void comenzar();
	abstract public void proximo();
	abstract public boolean fin();
	abstract public T elemento();
	abstract public T elemento(int pos);
	abstract public boolean agregar(T elem, int pos);
	abstract public boolean eliminar();
	abstract public boolean eliminar(int pos);
	abstract public boolean esVacia();
	abstract public boolean incluye(T elem);
	abstract public int tamanio();
}
