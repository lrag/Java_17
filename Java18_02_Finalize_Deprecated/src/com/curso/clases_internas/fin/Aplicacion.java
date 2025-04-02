package com.curso.clases_internas.fin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("=======================================");
		System.out.println("Iniciando test 'clases internas anónimas'...");
		Thread.sleep(10_000);	
		System.out.println("Creando objetos...");			
		
		//Hay que tener en cuenta que los objetos de clases internas anónimas 
		//tienen una referencia al objeto que las ha creado
		
		List<Comparator> lista = new ArrayList<>();
		for(int a=0; a<10_000_000; a++) {
			//Se crean diez millones de instancias de la clase 'Ejemplo'
			GeneradorComparadores e = new GeneradorComparadores();
			//Se crean diez millones de comparadores y se guardan en una lista
			//Aunque la variable 'c' salga de su ámbito estos objetos no serán recolectados
			Comparator c = e.crearComparador(1);
			lista.add(c);
			
			//Aqui también sale de su ámbito la variable 'e' y es recolectada por
			//el GC puesto que el comparador ya no tiene una referencia a ella
			
			//Si examinamos la VM con el VisualVM comprobamos que al final tenemos
			//-10M de comparadores, que era lo esperado
			//-0 objetos del tipo 'Ejemplo'			
		}	
		
		System.out.println("=======================================");
		Thread.sleep(160_000);
		System.out.println("FIN");	
	}
	
}
