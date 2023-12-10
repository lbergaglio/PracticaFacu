package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vector= {1,1,0,0,1,0,1,0,1};
		//System.out.print(ElementoEnPosicion(vector,0,vector.length));
		//mergeSort(vector,0,vector.length);
		//DevolverUnos(vector,vector.length-1);
		System.out.print(DevolverUnos(vector,vector.length-1));
	}
	
	//EJERCICIO 9 DIVIDE Y CONQUISTA
	private static int DevolverUnos(int[] vector, int inicio) {
		if(inicio==0) {
			if(vector[inicio]==1) return 1;
			else return 0;
		}
		else {
			if(vector[inicio]==1) return 1 + DevolverUnos(vector,inicio-1);
			else return DevolverUnos(vector,inicio-1);
		}
	}
	
	//EJERCICIO 6 DIVIDE Y CONQUISTA
	private static void mergeSort(int a[], int inicio, int fin) {
		if(inicio<fin){
			int medio=(inicio+fin)/2;
			mergeSort(a,inicio,medio);
			mergeSort(a,medio+1,fin);
			merge(a,inicio,medio,fin);
		}
	}
	
	private static void merge(int a[],int inicio, int medio, int fin) {
		int i,j,k;
		int b[]=new int[a.length];
		for(i=inicio;i<=fin;i++) b[i]=a[i];
		i=inicio;
		j=medio+1;
		k=inicio;
		while(i<=medio && j<=fin) {
			if(b[i]<=b[j]) a[k++]=b[i++];
			else a[k++]=b[j++];
		}
		while(i<=medio) a[k++]=b[i++];
	}
	
	
	//EJERCICIO 5 DIVIDE Y CONQUISTA
	private static int ElementoEnPosicion(int[] vector, int inicio, int fin) {
		int medio=(fin+inicio)/2;
		if(vector[medio]==medio) return medio;
		else if(medio<vector[medio] && fin-inicio!=0) return ElementoEnPosicion(vector,inicio,medio-1);
		else if(medio>vector[medio] && fin-inicio!=0) return ElementoEnPosicion(vector,medio+1,fin);
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
