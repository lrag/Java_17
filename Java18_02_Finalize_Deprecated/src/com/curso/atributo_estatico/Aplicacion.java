package com.curso.atributo_estatico;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("=======================================");
		System.out.println("Iniciando test 'static'...");
		Thread.sleep(10_000);
		System.out.println("Creando eventos...");
		
		GestorEventos ge = new GestorEventos();
		for(int a=0; a<10_000_000; a++) {
			ge.enviarEvento(Long.toString(Math.round(Math.random()*10_000)));
		}
		
		System.out.println("=======================================");

		ge = null;
		System.gc(); // :D
		
		Thread.sleep(160_000);
		
		System.out.println("FIN");
	}
	
}
