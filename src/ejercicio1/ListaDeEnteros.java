package ejercicio1;

public abstract class ListaDeEnteros {
	
	protected int tamanio;
	
	abstract void comenzar();
	abstract void proximo();
	abstract Integer elemento();
	abstract Integer elemento(int pos);
	abstract boolean agregar(Integer elem, int pos);
	abstract boolean eliminar();
	abstract boolean eliminar(int pos);
	abstract boolean incluye(Integer elem);
	abstract int tamanio();
	abstract boolean fin();

}
