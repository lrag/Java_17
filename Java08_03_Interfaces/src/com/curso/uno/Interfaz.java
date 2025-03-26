package com.curso.uno;

public interface Interfaz {

	//              //
	// Hasta java 7 //
	//              //	
	public static final int DATO = 20;
	
	public abstract void metodo();
	
	//              //
	// Desde java 8 //
	//              //

	//Métodos default
	default void saludar(){
		System.out.println("hola (default)"); //Anatema!
		//throw new RuntimeException("Esto no está implementado todavía");
	}
	
	/////////////////////////////////////////////
	
	//Métodos estáticos
	//Siempre con su implementacion
	public static void metodoEstatico(){
		System.out.println("Método estático");
	}	
	
}

