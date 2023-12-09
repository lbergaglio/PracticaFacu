package api;

import implementacion.NodoByB;


public interface ColaPrioridadTDAByB {
    void InicializarCola();
    void AcolarPrioridad(NodoByB x, int prioridad);
    void Desacolar();
    NodoByB Primero();
    boolean ColaVacia();
    int Prioridad();
}

