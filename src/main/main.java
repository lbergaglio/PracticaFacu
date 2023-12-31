package main;

import api.GrafoTDA;
import api.ColaPrioridadTDA;
import api.ConjuntoTDA;

import implementacion.Grafo;
import implementacion.Nodo;
import implementacion.ColaPrioridad;
import implementacion.Conjunto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] pesos = {18,15,10};
		int[] valor = {25,24,15};
		double[] mochila = new double[pesos.length];
		mochila = devolverMochila(pesos,valor,20);
		for(int i=0; i < mochila.length; i++) {
			System.out.println(mochila[i]);
		}*/
		System.out.println(calculoInflacionPorDia(365,2));
		
	}
	
	private static double calculoInflacionPorDia(int diasRestantes, double indice) {
		if(diasRestantes==1) return indice;
		else return calculoInflacionPorDia(diasRestantes-1,indice) * (1 + indice/100) + indice;
	}
	
	private static ConjuntoTDA CaminoCines(GrafoTDA grafo,int entrada,int salida) {
		ConjuntoTDA pendientes = new Conjunto();
		
		int cant_vertices = sizeConjunto(pendientes);
		
		Boolean[][] matriz = new Boolean[cant_vertices][cant_vertices];  
		
		for(int i=1; i<=cant_vertices;i++) {
			for(int j=1; j<=cant_vertices;j++) {
				if(grafo.ExisteArista(i, j)) matriz[i-1][j-1]=true;
				else matriz[i-1][j-1]=false;
			}
		}
		
		Nodo nodoRaiz = new Nodo();
		nodoRaiz.setId(entrada);
		pendientes.Sacar(nodoRaiz.getId());
		
		for(int i=0;i<cant_vertices;i++) {
			if(matriz[nodoRaiz.getId()-1][i] && !pendientes.Pertenece(i+1)) nodoRaiz.setVecinos(i+1);
		}
		
		ConjuntoTDA mejorSolucion = new Conjunto();
		mejorSolucion.Agregar(nodoRaiz.getId());
		ConjuntoTDA solucionParcial = mejorSolucion;
		
		while(!nodoRaiz.getVecinos().ConjuntoVacio()) {
			Nodo nodo = new Nodo();
			nodo.setId(nodoRaiz.getVecinos().Elegir());
			solucionParcial.Agregar(nodo.getId());
			pendientes.Sacar(nodo.getId());
			if(nodo.getId()==salida && sizeConjunto(mejorSolucion)<sizeConjunto(solucionParcial)) mejorSolucion=solucionParcial;
			else {
				for(int i=0;i<cant_vertices;i++) {
					if(matriz[nodo.getId()-1][i] && !pendientes.Pertenece(i+1)) nodo.setVecinos(i+1);
				}
				while(!nodo.getVecinos().ConjuntoVacio()) {
						
				}
			
				
			}
		}
		
		
		return null;
	}
	
	
	private static int sizeConjunto(ConjuntoTDA conjunto) {
		ConjuntoTDA aux = conjunto;
		int i=0;
		while(!aux.ConjuntoVacio()) {
			i++;
			aux.Sacar(aux.Elegir());
		}
		return i;
	}
	
	//EJERCICIO 1 GRAFO
	private static int GimnasioMasCercano(GrafoTDA G, int inicio, int fin) {
		GrafoTDA R = new Grafo();
		R.InicializarGrafo();
		ConjuntoTDA visitados = new Conjunto(); 
		ConjuntoTDA pendientes = G.Vertices();
		ConjuntoTDA aux = G.Vertices();
		ConjuntoTDA aux2 = new Conjunto();
		int v,vf,ai,af;
		while(!aux.ConjuntoVacio()) {
			v = aux.Elegir();
			R.AgregarVertice(v);
			aux.Sacar(v);
			aux2=aux;
			ai=v;
			while(!aux2.ConjuntoVacio()) {
				af=aux2.Elegir();
				aux2.Sacar(af);
				if(G.ExisteArista(ai, af)) R.AgregarArista(ai, af, G.PesoArista(ai, af));
			}
		}
		visitados.Agregar(inicio);
		pendientes.Sacar(inicio);
		while(!pendientes.ConjuntoVacio()) {
			int actual,menor;
			aux=pendientes;
			menor=aux.Elegir();
			aux.Sacar(menor);
			while(!aux2.ConjuntoVacio()){
				actual=aux.Elegir();
				if(R.PesoArista(inicio, menor)>R.PesoArista(inicio, actual)) menor=actual;
				aux2.Sacar(actual);
			}
			pendientes.Sacar(menor);
			visitados.Agregar(menor);
			aux2=pendientes;
			while(!aux2.ConjuntoVacio()) {
				vf=aux2.Elegir();
				if(R.ExisteArista(inicio, vf)) ai=R.PesoArista(inicio, vf);
				else ai=1000;
				if(R.ExisteArista(inicio, menor) && R.ExisteArista(menor, vf)) af=R.PesoArista(inicio, menor) + R.PesoArista(menor, vf);
				else af=1100;
				if(ai>af) {
					R.EliminarArista(inicio, vf);
					R.AgregarArista(inicio, vf, af);
				}
				
			}
		}		
		return R.PesoArista(inicio, fin);
	}
	
	//EJERCICIO 1 GREEDY
	private static int[] devolverCambio(int[] billetes, int monto) {
		int[] cambio = new int[billetes.length];
		int i = 0, cant_billetes=0;
		while (monto>0) {
			if(monto/billetes[i]>=1) {
				cant_billetes=monto/billetes[i];
				monto-=cant_billetes*billetes[i];
				cambio[i]=cant_billetes;
			}
			cant_billetes=0;
			i++;
		}
		return cambio;
	}
	
	//EJERCICIO 2 GREEDY
	private static double[] devolverMochila(int[] peso, int[] valor, double pesoMax) {
		double[] mochila = new double[peso.length];
		double[] objetosPromedio = new double[peso.length];
		for(int i=0;i<peso.length;i++) objetosPromedio[i]=valor[i]*peso[i];
		//OrdenarVectorDouble(objetosPromedio,0,objetosPromedio.length-1);
		int i, j;
		int aux2;
		double aux;
        for (i = 0; i < objetosPromedio.length - 1; i++) {
            for (j = 0; j < objetosPromedio.length - i - 1; j++) {                                                              
                if (objetosPromedio[j + 1] < objetosPromedio[j]) {
                    aux = objetosPromedio[j + 1];
                    aux2 = peso[j+1];
                    objetosPromedio[j + 1] = objetosPromedio[j];
                    peso[j+1]=peso[j];
                    objetosPromedio[j] = aux;
                    peso[j]=aux2;
                    aux2=valor[j+1];
                    valor[j+1]=valor[j];
                    valor[j]=aux2;
                }
            }
        }
        int k = 0;
		while(pesoMax>0 && k<peso.length) {
			if(pesoMax/peso[k]>=1) {
				pesoMax-=peso[k];
				mochila[k]=valor[k];	
			}
			else {
				mochila[k]= pesoMax;
				pesoMax=0;
			}
			//System.out.println(pesoMax);
			k++;
		}
		return mochila;
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
	
	private static void OrdenarVectorDouble(double[] A, int izq, int der) {
		double pivote=A[izq]; 
		  int i=izq;        
		  int j=der;         
		  double aux;
		  while(i < j){                                                            
		     while(A[i] <= pivote && i < j) i++; 
		     while(A[j] > pivote) j--;           
		     if (i < j) {                                             
		         aux= A[i];                      
		         A[i]=A[j];
		         A[j]=aux;
		     }
		   }
		   A[izq]=A[j];                                        
		   A[j]=pivote;      
		   if(izq < j-1) OrdenarVectorDouble(A,izq,j-1);         
		   else if(j+1 < der) OrdenarVectorDouble(A,j+1,der);
	}

}
