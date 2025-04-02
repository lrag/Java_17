package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Introducido como preview en Java19
		//
		
		//Cuando en Java se habla de Pattern Matching se refieren al 'instanceof' de algún modo		
		
		System.out.println("=====================================");
		Cliente c1 = new Cliente(1,"Bud Spencer","Strada del guantazi","123456789");
		
		//Hasta Java20
		Object obj = c1;
		if(obj instanceof Cliente c2) {
			System.out.println(c2.nombre()+", "+c2.direccion());
		}
		
		//En Java21 podemos hacer esto:
		if(obj instanceof Cliente(Integer id, String nombre, String direccion, String telefono)) {
			System.out.println(nombre+", "+direccion);
		}
		

		
	}
	
}


