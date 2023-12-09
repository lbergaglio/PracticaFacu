package api;

import implementacion.NodoColaPrioridad;

public interface ColaPrioridadTDA {
	void InicializarCola();
    void AcolarPrioridad(int x, int prioridad);
    void Desacolar();
    NodoColaPrioridad Primero();
    boolean ColaVacia();
    int Prioridad();
}
