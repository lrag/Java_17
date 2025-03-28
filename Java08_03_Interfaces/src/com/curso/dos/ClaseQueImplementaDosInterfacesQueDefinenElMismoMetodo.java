package com.curso.dos;

//No podemos implementar dos interfaces que tengan un m�todo default llamado igual
public class ClaseQueImplementaDosInterfacesQueDefinenElMismoMetodo implements InterfazA, InterfazB {

	//Si sucede tal cosa sobreescribimos el m�todo y no utilizamos ninguno de los m�todos default
	@Override
	public void metodo(){
		System.out.println("Implementacion de m�todo en la clase");
		
		//Podemos utilizar super, que como obliga a poner el nombre de la interfaz no tiene ambiguedad
		InterfazA.super.metodo();
		InterfazB.super.metodo();
	}
	
	//No hay problema con los metodos est�ticos porque en java 8 si queremos acceder a un m�todo est�tico
	//debemos usar el nombre de la interfaz
	public void metodo2() {
		InterfazA.metodoEstatico();
		InterfazB.metodoEstatico();
	}
	
	
}













