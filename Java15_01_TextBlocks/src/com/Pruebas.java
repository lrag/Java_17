package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Los bloques de texto fueron introducidos de manera experimental en Java 13
		//En Java 15 ya forman parte oficialmente del lenguaje
		//
		
		//Tras las primeras tres comillas dobles no puede colocarse nada, ni siquiera un comentario
		//La cadena de texto comienza en la l�nea 10
		String texto1 = """                    
			Uno
			Dos
			Tres
			Cuatro
			Cinco				
			""";

		//Sangrando mal...
					String texto2 = """                    
							Uno
							Dos
							Tres
							Cuatro
							Cinco				
							""";
					
		//La columna en la que est�n las tres comillas dobles finales tiene importancia
		String texto3 = """                    
				Uno
				Dos
				Tres
				Cuatro
				Cinco				
			""";		
		String texto4 = """                    
				Uno
				Dos
				Tres
				Cuatro
				Cinco				
		""";		
					
		//El compilador tiene en cuenta el sangrado del c�digo
		System.out.println("===================================");
		System.out.println(texto1);
		System.out.println(texto2); //Aparece exactamente igual
		System.out.println(texto3);
		System.out.println(texto4);
	
		//Escapando (barbarismo?) las tres comillas
		System.out.println("===================================");
		String texto5 = """
			Podemos utilizar "comillas dobles"
			Y ""Dobles comillas dobles""
			Pero si queremos introducir \""" 
			en la cadena de texto
			las tendremos que escapar
			con esto \\			
			""";
		System.out.println(texto5);
		
		//Espacios al final de cada l�nea
		System.out.println("===================================");
		String texto6 = """
			Uno      
			Dos      
			Tres     """;
		//Si queremos incluir espacios al final de cada l�nea:
		String texto7 = """
			Uno      \s
			Dos      \s
			Tres     \s""";
		
		System.out.println(texto6+":");
		System.out.println(texto7+":");

		//A�adiendo variables
		System.out.println("===================================");
		String nombre = "Harry Callahan";
		String empleo = "SFPD";
		
		String texto8 = """
			Nombre: %s
			Empleo: %s	
			""".formatted(nombre, empleo);
		System.out.println(texto8);
				
	}
	
}
