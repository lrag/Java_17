package com.curso.dos;

public interface InterfazA {

	default void metodo(){
		System.out.println("METODO EN INTERFAZ_A");
	}
	
	static void metodoEstatico() {
		System.out.println("METODO EST�TICO EN INTERFAZ_A");
	}
	
}

