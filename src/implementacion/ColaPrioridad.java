package implementacion;

import api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	NodoColaPrioridad[] elementos;
	int indice;
	
	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		elementos = new NodoColaPrioridad[140];
		indice=0;		
	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		// TODO Auto-generated method stub
		NodoColaPrioridad nodo = new NodoColaPrioridad();
		nodo.setValor(x);
		nodo.setPrioridad(prioridad);
		int i = indice;
        for (; i > 0 && elementos[i - 1].getPrioridad() <= nodo.getPrioridad(); i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[i] = nodo;
        indice++;
		
	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		indice --;
	}

	@Override
	public NodoColaPrioridad Primero() {
		// TODO Auto-generated method stub
		return elementos[indice - 1];
	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return indice==0;
	}

	@Override
	public int Prioridad() {
		// TODO Auto-generated method stub
		return elementos[indice-1].getPrioridad();
	}

}
