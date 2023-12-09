package implementacion;

import java.util.ArrayList;
import java.util.List;
import implementacion.NodoByB;
import api.ColaPrioridadTDAByB;

public class ColaPrioridadByB implements ColaPrioridadTDAByB {
	NodoByB[] elementos;
    int indice;

    @Override
    public void InicializarCola() {
        elementos = new NodoByB[140];
        indice = 0;
    }

    public void AcolarPrioridad(NodoByB nodo, int prioridad) {
        int i = indice;
        for (; i > 0 && elementos[i - 1].getCotaInferior() <= nodo.getCotaInferior(); i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[i] = nodo;
        indice++;
    }

    public void Desacolar() {
        indice--;
    }

    public NodoByB Primero() {
        return elementos[indice - 1];
    }

    public boolean ColaVacia() {
        return (indice == 0);
    }

    public int Prioridad() {
        return elementos[indice - 1].getCotaInferior();
    }
}