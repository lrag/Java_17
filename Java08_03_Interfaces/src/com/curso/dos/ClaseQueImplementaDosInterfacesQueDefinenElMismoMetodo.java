package com.curso.dos;

//No podemos implementar dos interfaces que tengan un método default llamado igual
public class ClaseQueImplementaDosInterfacesQueDefinenElMismoMetodo implements InterfazA, InterfazB {

	//Si sucede tal cosa sobreescribimos el método y no utilizamos ninguno de los métodos default
	@Override
	public void metodo(){
		System.out.println("Implementacion de método en la clase");
		
		//Podemos utilizar super, que como obliga a poner el nombre de la interfaz no tiene ambiguedad
		InterfazA.super.metodo();
		InterfazB.super.metodo();
	}
	
	//No hay problema con los metodos estáticos porque en java 8 si queremos acceder a un método estático
	//debemos usar el nombre de la interfaz
	public void metodo2() {
		InterfazA.metodoEstatico();
		InterfazB.metodoEstatico();
	}
	
	
}













