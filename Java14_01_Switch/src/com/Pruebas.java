package com;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Pruebas {
	
	public static void main(String[] args) throws Exception {

		//
		//Las novedades en switch fueron introducidas en Java 12 y 13, como preview.
		//En la versión 14 ya están disponibles para producción
		//
		
		String txt = "aAa";
		switch(txt) { //Desde Java 1.7 se pueden utilizar cadenas de texto en un switch :D
			case "aaa","aAa" : 
				System.out.println("AAA");
				break;
			case "bbb" : 
				System.out.println("BBB");
			    break;
			case "ccc" : 
				System.out.println("CCC");
				break;
			default : 
				System.out.println("XXX");		
		}
		
		//
		//Si utilizamos la flecha ya no es necesario el break 
		//
		switch(txt) {		
			case "aaa","aAa" -> System.out.println("AAA");
			case "bbb" -> System.out.println("BBB");
			case "ccc" -> System.out.println("CCC");
			default -> System.out.println("XXX");		
		}
		
		//
		//Switch puede devolver un valor
		//
		
		//Antes
		int mes = 4;
		int trimestre = 0; 
		switch(mes) {
			case 1,2,3 : 
				trimestre = 1;
				break;
			case 4,5,6 : 
				trimestre = 2;
				break;
			case 7,8,9 : 
				trimestre = 3;
				break;
			case 10,11,12 : 
				trimestre = 4;
				break;
			default : throw new Exception("Mes incorrecto");
		}
		System.out.println("Trimestre:"+trimestre);
		
		//Mucho mejor así
		trimestre = switch(mes) {
			case 1,2,3 -> 1; //Aqui hay un 'return' implícito
			case 4,5,6 -> 2;
			case 7,8,9 -> 3;
			case 10,11,12 -> 4;
			//Default es obligatorio
			default -> throw new Exception("Mes incorrecto");
		};
		System.out.println("Trimestre:"+trimestre);
		
		//Si el bloque 'case' tiene más de una línea se utiliza 'yield' a modo de 'return'
		//Nueva palabra reservada:
		//-No se puede utilizar como nombre de clase
		//-Pero si como nombre de variable
		trimestre = switch(mes) {
			case 1,2,3 -> {
				System.out.println("Primer trimestre");
				yield 1;
			}
			case 4,5,6 -> {
				System.out.println("Segundo trimestre");
				yield 2;
			}
			case 7,8,9 -> {
				System.out.println("Tercer trimestre");
				yield 3;
			}
			case 10,11,12 -> {
				System.out.println("Cuarto trimestre");
				yield 4;
			}
			default -> throw new Exception("Mes incorrecto");
		};
		System.out.println("Trimestre:"+trimestre);		

	}

}
