package com;

import java.util.ArrayList;

public class Pruebas {

	/////////////////////////////
	// var: variables sin tipo //
	/////////////////////////////
	
	//var solo puede utilizarse en variables automáticas (locales)
	//public var texto = "NO";
		
	public static void main(String[] args) {
		
		//var no es palabra reservada
		int var = 10;
		
		//no admite final
		//final var = "NO";
		
		//Estas variables están estáticamente tipadas!
		var lista = new ArrayList<String>();
		//lista.add(50);
		lista.add("VAR");

		var numero = 5;
		var txt = "Hola";
		//numero = "Hola";
		//txt = 5;

		//Arrays
		//var arr[] = new int[10];
		var arr = new int[10];           
		
		//No podemos dejar la variable sin valor (obvio)
		//var movida;
		//var movida = null;
		//movida = "QUE NO";
				
		//Tampoco podemos declarar varias en la misma línea
		int n1, n2, n3; 
		//var n1, n2, n3;	
		
		//A veces utilizar var implica que nuestro código es menos legible
		var x = getSaludo();
		//Mejor así?
		String y = getSaludo();
		
	}	
	
	public static String getSaludo() {
		return "¡Hola!";
	}
	
}

//Var no es palabra reservada pero si un tipo reservado
//class var {
//}


