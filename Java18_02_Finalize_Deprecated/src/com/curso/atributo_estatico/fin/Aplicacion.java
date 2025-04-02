package com.curso.atributo_estatico.fin;



public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("=======================================");
		System.out.println("Iniciando test 'static'...");
		Thread.sleep(10_000);
		System.out.println("Creando eventos...");
		
		GestorEventos ge = new GestorEventos();
		for(int a=0; a<10_000_000; a++) {
			ge.addEvento(Long.toString(Math.round(Math.random()*10_000)));
		}
		
		System.out.println("=======================================");

		ge = null;
		
		//Esto, si nos hacen caso, fuerza un GENERAL GC
		long inicio = System.currentTimeMillis();
		System.gc(); // :D
		long fin = System.currentTimeMillis();
		System.out.println("GC:"+(fin-inicio));
		
		Thread.sleep(160_000);
		
		System.out.println("FIN");
	}
	
}




