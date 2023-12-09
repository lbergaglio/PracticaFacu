package implementacion;

public class NodoByB{
	private int[] estado= new int[8];
	private int nivel = 0;
	private int cota_inferior = 0;
	private int cota_superior = 0;
	private NodoByB hijoIzquierdo;
    private NodoByB hijoDerecho;
	
	public void setEstado(int[] estado) {
		this.estado=estado;
	}
	public int[] getEstado() {
		return estado;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getCotaInferior() {
		return cota_inferior;
	}
	public int getCotaSuperior() {
		return cota_superior;
	}
	public void setCotaInferior(int cota_inferior) {
		this.cota_inferior = cota_inferior;
	}
	public void setCotaSuperior(int cota_superior) {
		this.cota_superior = cota_superior;
	}    

    public NodoByB getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoByB hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoByB getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoByB hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

 }
