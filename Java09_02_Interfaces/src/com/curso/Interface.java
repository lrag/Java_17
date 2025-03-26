package com.curso;

public interface Interface {

	//              //
	// Hasta java 7 //
	//              //
	public static final int DATO=42; 
	
	public abstract void metodo1();
		
	//              //
	// Desde Java 8 //
	//              //
	default void metodo2() {
		System.out.println("Default. Esto es posible en Java8");
	}
	
	static void metodo3() {
		System.out.println("Static. Esto es posible en Java8");
	}
	
	//              //
	// Desde Java 9 //
	//              //
	default void metodo4() {
		metodo5();
	}
	
	//Metodos din�micos y privados
	private void metodo5() {
		System.out.println("M�todos privados y din�micos en interfaces de Java9");
	}

	static void metodo6() {
		metodo7();
	}
	
	//M�todos est�ticos y privados
	private static void metodo7() {
		System.out.println("M�todos est�ticos privados en interfaces de Java9");		
	}	
	
}
