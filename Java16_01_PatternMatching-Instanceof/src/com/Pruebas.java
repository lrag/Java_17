package com;

import com.modelo.Cliente;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Los cambios en el operador instanceof se introdujeron de manera experimental en Java 14
		//		
		
		Object obj = new Cliente();
		
		if(obj instanceof Cliente) {
			//Una y otra vez...
			Cliente cli = (Cliente) obj;
			cli.setNombre("Ringo Starr");
		}
	
		//Azucar sintáctico del bueno: el cast es implícito
		if(obj instanceof Cliente c) {
			c.setNombre("Malcolm Young");
		}
		
	}
	
}


