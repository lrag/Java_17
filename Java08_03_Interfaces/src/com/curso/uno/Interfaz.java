package com.curso.uno;

public interface Interfaz {

	public static final int DATO = 20;
	
	public abstract void metodo();
	
	//M�todos default
	default void saludar(){
		System.out.println("hola"); //Anatema!
		//throw new RuntimeException("Esto no est� implementado todav�a");
	}
	
	/////////////////////////////////////////////
	
	//M�todos est�ticos
	//Siempre con su implementacion
	public static void metodoEstatico(){
		System.out.println("M�todo est�tico");
	}	
	
}

