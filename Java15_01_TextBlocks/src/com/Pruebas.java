package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//Los bloques de texto fueron introducidos de manera experimental en Java 13
		//En Java 15 ya forman parte oficialmente del lenguaje
		//
		
		//Tras las primeras tres comillas dobles no puede colocarse nada, ni siquiera un comentario
		//La cadena de texto comienza en la línea 15
		String texto1 = """                    
			Uno
			Dos
			Tres
			Cuatro
			Cinco				
			""";
		
		//El sangrado del código no afecta al bloque de texto. texto2 es igual a texto1 
					String texto2 = """                  
							Uno
							Dos
							Tres
							Cuatro
							Cinco				
							""";
					
		//La columna en la que están las tres comillas dobles finales tiene importancia
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
					
		//El compilador tiene en cuenta el sangrado del código
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
		
		//Espacios al final de cada línea
		System.out.println("===================================");
		String texto6 = """
			Uno      
			Dos      
			Tres     """; //despues de 'Tres' tampoco hay espacios en blanco
		//Si queremos incluir espacios al final de cada línea:
		String texto7 = """
			Uno      \s
			Dos      \s
			Tres     \s""";	//Ahora si
		System.out.println(texto6+":");
		System.out.println(texto7+":");

		//Añadiendo variables
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
