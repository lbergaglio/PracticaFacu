package implementacion;

import api.ConjuntoTDA;

public class Nodo {
	private int id;
	ConjuntoTDA vecinos = new Conjunto();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ConjuntoTDA getVecinos() {
		return vecinos;
	}
	public void setVecinos(int id) {
		this.vecinos.Agregar(id);
	}
}
