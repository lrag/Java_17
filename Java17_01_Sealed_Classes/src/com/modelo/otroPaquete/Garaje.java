package com.modelo.otroPaquete;

import java.util.List;

import com.modelo.Vehiculo;

//Aunque Vehiculo tenga acceso p�blico no podemos heredar de ella en clases que no est�n
//en la lista 'permits'
public final class Garaje /*extends Vehiculo*/ {

	private List<Vehiculo> vehiculos;
	
	//@Override
	public void arrancar() {
		
	}

}
