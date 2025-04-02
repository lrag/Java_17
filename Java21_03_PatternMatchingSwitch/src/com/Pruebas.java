package com;

import java.util.List;

public class Pruebas {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//
		//Introducido como preview en Java17
		//
		
		Object obj = "¡¡¡BEEEE!!!";

		//
		//Hasta Java20
		//
		System.out.println("=================================");
		String tipo = null;
		if( obj == null) {
			throw new RuntimeException("NULO"); //@SuppressWarnings("unused")
		} else if (obj instanceof Integer) {
			tipo = "Es un integer";
		} else if (obj instanceof List) {
			tipo = "Es una lista";
		} else if (obj instanceof String) {
			tipo = "Es un string";
		}
		System.out.println(tipo);

		//
		//Desde Java21
		//
		System.out.println("=================================");
		String tipo2 = switch(obj) {
			case null       -> throw new RuntimeException("NULO");
			case Integer i  -> "Un integer es";
			case List lista -> "Una lista es";
			case String s   -> "Un string es";
			default         -> "Ni idea de lo que es";
		};
		System.out.println(tipo2);

		//
		//when
		//
		System.out.println("=================================");
		String respuesta = "y";
		switch(respuesta) {
			case String s when s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("S") -> System.out.println("Que si.");
			case String s when s.equalsIgnoreCase("N") || s.equalsIgnoreCase("N") -> System.out.println("Que no.");
			case String s -> System.out.println("¿Qué?");
			//default -> System.out.println("¿Qué?");
		}
		
	}
	
}


