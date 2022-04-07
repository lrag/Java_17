package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Los records fueron introducidos de forma experimental en Java 14
		//	
		
		//Los objetos de tipo record son inmutables
		//Por defecto incluyen �nicamente un constructor con par�metros
		System.out.println("=====================================");
		Cliente c = new Cliente(1,"Bud Spencer","Strada del guantazi","123456789");
		System.out.println(c);
		//No siguen la especificaci�n Java bean para los m�todos accesores!
		System.out.println(c.id());
		System.out.println(c.nombre());
		System.out.println(c.direccion());
		System.out.println(c.telefono());
		
		//Constructores compactos
		System.out.println("=====================================");
		try {
			Coche ch1 = new Coche(1,null,"","");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Podemos sobreescribir m�todos
		System.out.println("=====================================");
		Producto p1 = new Producto(1,"Fleje","Ib�rica de Flejes S.A.");
		Producto p2 = new Producto(1,"Fleje de primera calidad","Ib�rica de Flejes S.A.");
		System.out.println(p1);
		System.out.println(p1.equals(p2));
		//E incluir otros (si es que tiene sentido)
		p1.metodo();				
	}
	
}


