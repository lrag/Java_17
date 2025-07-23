package com.curso.uno;

public class Clase2 extends Clase1 {
	//Los métodos estáticos no se heredan
	//Ni se sobreescriben
	//@Override
	public static void metodoEstatico(){
		System.out.println("Clase2:metodoEstatico");
	}	
	
	
	public static void main(String[] args) {
		
		Clase1.metodoEstatico();
		Clase2.metodoEstatico();
		
		Clase1 c1    = new Clase1();
		Clase2 c2    = new Clase2();
		Clase1 c1Bis = new Clase2();
		//De entrada no deberíamos estar accediendo a componentes estáticos con referencias
		c1.metodoEstatico();
		c2.metodoEstatico();
		c1Bis.metodoEstatico();
		
	}
	
}
