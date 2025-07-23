package com.curso.uno;

public class Implementacion2 implements Interfaz {

	private String saludo = "HOLA";
	
	@Override
	public void metodo() {
		System.out.println("Implementacion2:metodo");
	}
		
	@Override
	//Tambien podemos sobreescribir un método default de la interfaz
	public void saludar(String nombre){
		//Para invocar con super el código de un metodo default que 
		//estamos sobreescribiendo debemos utilizar el nombre de la interfaz.
		//Interfaz.super.saludar(nombre);
		System.out.println(saludo+" "+nombre);
	}

}











