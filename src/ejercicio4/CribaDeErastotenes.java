package ejercicio4;

import ejercicio1.ListaDeEnteros;
import ejercicio1.ListaDeEnterosEnlazada;

public class CribaDeErastotenes {

	public ListaDeEnteros obtenerPrimos(ListaDeEnteros l) {
		ListaDeEnteros res = new ListaDeEnterosEnlazada();
		ListaDeEnteros noPrimos = new ListaDeEnterosEnlazada();
		
		l.comenzar();
		l.proximo();
		while (!l.fin()) {
			if (!noPrimos.incluye(l.elemento())) {
				res.agregar(l.elemento(), res.tamanio());
				for (int i = l.elemento() * 2; i < l.tamanio() + 1; i += l.elemento())
					noPrimos.agregar(i, 0);
			}
			l.proximo();
		}

		return res;
	}
	
}
