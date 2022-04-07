package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//
		//INDENT
		//		
		System.out.println("============================");
		String txt1 = "Cadena de texto";
		String txt2 = "Una l�nea de texto\nOtra l�nea";

		System.out.println(txt1);
		System.out.println(txt2);
		
		//10 caracteres de sangrado
		txt1 = txt1.indent(10);
		txt2 = txt2.indent(10);

		
		System.out.println("----------------------------");
		System.out.println(txt1);
		System.out.println(txt2);


		//-5 caracteres de sangrado
		txt1 = txt1.indent(-5);
		txt2 = txt2.indent(-5);
		
		System.out.println("----------------------------");
		System.out.println(txt1);
		System.out.println(txt2);
		
		//-15 caracteres de sangrado
		txt1 = txt1.indent(-15);
		txt2 = txt2.indent(-15);

		System.out.println("----------------------------");
		System.out.println(txt1);
		System.out.println(txt2);
		
		//
		//TRANSFORM
		//
		System.out.println("============================");
		String txt3 = "Hola Radiola";
		String txt4 = txt3.toUpperCase();
		String txt5 = txt3.transform(txt -> txt.toUpperCase());
		System.out.println(txt4);

	
	}
	
}
