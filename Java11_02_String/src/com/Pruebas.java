package com;

public class Pruebas {

	public static void main(String[] args) {
		
		//							      //
		//Nuevos métodos en la clas String//
		//							      //
		
		//Lines: parte la cadena por los saltos de línea
		System.out.println("============================");
		String txt4 = "111\n222\n333\n444\n555\n666";
		txt4.lines().forEach(txt -> System.out.println(txt));
		
		//isEmpty: true cuando la cadena tiene longitud 0
		//isBlanck: cuando la cadena tiene longitud pero está vacía (espacio, tab...)
		System.out.println("============================");
		String txt1 = "";
		String txt2 = "   ";
		
		//Hasta java 10...
		//if(txt.trim().length()==0) {
		//	System.out.println("Cadena vacía");
		//}
		
		if(txt1.isEmpty()) {
			System.out.println("txt1: cadena de longitud 0");
		}
		if(txt1.isBlank()) {
			System.out.println("txt1: cadena vacía");
		}		

		if(txt2.isEmpty()) {
			System.out.println("txt2: cadena de longitud 0");
		}
		if(txt2.isBlank()) {
			System.out.println("txt2: cadena vacía");
		}		

		//Strip: muy parecido a trim
		System.out.println("============================");
        String s1 = "\t abc \n";
        String s2 = s1.trim();
        String s3 = s1.strip();
        
        System.out.println(":"+s2+":");
        System.out.println(":"+s3+":");
        System.out.println(s2.equals(s3));
        
        Character c = '\u2000'; //Caracter equivalente al espacio
        String s4 = c + "hola" + c;
        String s5 = s4.trim();
        String s6 = s4.strip();
		System.out.println(":"+s5+":"); //trim no ha quitado un caracter que no conoce
		System.out.println(":"+s6+":"); //strip si

		//Tambien podemos eliminar caracteres en blanco solo por el principio o por el final
		//stripLeading()
		//stripTailing()
		
		//repeat
		System.out.println("============================");
		String str1 = "ja mon";
		String str2 = str1.repeat(6);
		System.out.println(str2);
		
	}
	
}
