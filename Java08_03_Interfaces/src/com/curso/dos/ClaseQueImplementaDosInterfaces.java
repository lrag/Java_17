package com.curso.dos;

//No podemos implementar dos interfaces que tengan un m�todo default llamado igual
public class ClaseQueImplementaDosInterfaces implements InterfazA, InterfazB {
	
	//Si sucede tal cosa implementamos el m�todo y no utilizamos ninguno de los m�todos default
	@Override
	public void metodo(){
		System.out.println("Implementacion de m�todo en la clase");
	}
	
	//No hay problema con los metodos est�ticos porque en java 8 si queremos acceder a un m�todo est�tico
	//debemos usar el nombre de la interfaz
	
}













