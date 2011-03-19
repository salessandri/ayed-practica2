package ejercicio1;

public abstract class ListaDeEnteros {
	
	protected int tamanio;
	
	abstract public void comenzar();
	abstract public void proximo();
	abstract public Integer elemento();
	abstract public Integer elemento(int pos);
	abstract public boolean agregar(Integer elem, int pos);
	abstract public boolean eliminar();
	abstract public boolean eliminar(int pos);
	abstract public boolean incluye(Integer elem);
	abstract public int tamanio();
	abstract public boolean fin();

}
