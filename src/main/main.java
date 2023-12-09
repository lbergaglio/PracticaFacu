package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(Potencia(3,16));
	}
	
	//EJERCICIO 5 DIVIDE Y CONQUISTA
	private static int ElementoEnPosicion(int[] vector, int inicio, int fin) {
		int medio=(fin+inicio)/2;
		if(vector[medio]==medio) return medio;
		else if(medio<vector[medio]) return ElementoEnPosicion(vector,inicio,medio-1);
		else if(medio>vector[medio]) return ElementoEnPosicion(vector,medio+1,fin);
		else return 0;
	}
	
	//EJERCICIO 3 DIVIDE Y CONQUISTA
	private static int Potencia(int valor,int potencia) {
		if(potencia==2) return valor*valor;
		else return Potencia(valor,potencia/2)*Potencia(valor,potencia/2);
	}
	
	//EJERCICIO 2 DIVIDE Y CONQUISTA
	private static Boolean Pertenece(int[] vector,int inicio, int fin, int valor) {
		int indiceMitad=(inicio+fin)/2;
		int mitad=vector[indiceMitad];
		if (mitad==valor) return true;
		if (inicio-fin==1 && vector[inicio]!=valor) return false;
		else if (mitad<valor) return Pertenece(vector,indiceMitad+1,fin,valor);
		else return Pertenece(vector,inicio,indiceMitad-1,valor);
		}
	
	private static int fibonacci(int i) {
		if(i==0) return 0; 
		else if (i==1) return 1;
		else {
			return fibonacci(i-1)+fibonacci(i-2);
		}
	}
	
	

}
