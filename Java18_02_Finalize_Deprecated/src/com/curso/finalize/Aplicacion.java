package com.curso.finalize;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("=======================================");
		System.out.println("Iniciando test 'finalize'...");
		Thread.sleep(10_000);	
		System.out.println("Creando objetos...");			
		
		//Hasta que el cuerpo aguante
		boolean Smith = true;
		while(Smith) {
			ClaseConFinalize ccf = new ClaseConFinalize();
		}
		
		/*
		System.out.println("=======================================");
		Thread.sleep(160_000);
		System.out.println("FIN");
		*/
		
	}
	
	
}
