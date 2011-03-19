package ejercicio1;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {

	private int[] datos = new int[200];
	private int actual = 0;
	private int tamLogico = 0;
	
	@Override
	public 
	void comenzar() {
		actual = 0;
	}

	@Override
	public
	void proximo() {
		actual++;		
	}

	@Override
	public
	Integer elemento() {
		return datos[actual];
	}

	@Override
	public
	Integer elemento(int pos) {
		return datos[pos];
	}

	@Override
	public
	boolean agregar(Integer elem, int pos) {
		if (pos < 0 || pos > tamLogico || pos >= datos.length)
			return false;
		tamLogico++;
		for (int i = tamLogico; i > pos; i--)
			datos[i] = datos[i-1];
		datos[pos] = elem;
		return true;
	}

	@Override
	public
	boolean eliminar() {
		if (actual >= tamLogico)
			return false;
		tamLogico--;
		for (int i = actual; i < tamLogico; i++)
			datos[i] = datos[i + 1];
		return true;
	}

	@Override
	public
	boolean eliminar(int pos) {
		if (pos < 0 || pos >= tamLogico)
			return false;
		tamLogico--;
		for (int i = pos; i < tamLogico; i++)
			datos[i] = datos[i + 1];
		return true;
	}

	@Override
	public
	boolean incluye(Integer elem) {
		this.comenzar();
		while (!this.fin() && this.elemento() != elem)
			this.proximo();
		return !this.fin();
	}

	@Override
	public
	int tamanio() {
		return tamLogico;
	}

	@Override
	public
	boolean fin() {
		return actual >= tamLogico;
	}

}
