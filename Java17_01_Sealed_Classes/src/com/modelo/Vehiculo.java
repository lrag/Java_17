package com.modelo;

import com.modelo.otroPaquete.Camion;
import com.modelo.otroPaquete.Furgoneta;


//
//Definimos qu� clases podr�n heredar de Vehiculo.
//sealed y permits no son palabras reservadas sino identificadores reservados
//
//
//Con las clases selladas podemos tener una clase con acceso p�blico que de la que pueden heredar
//otras situadas en distintos paquetes, manteniendo el control de cu�les son estas
//
//Las clases que hereden de una clase sellada han de ser finales o selladas a su vez
//
public abstract sealed class Vehiculo permits Coche, Camion, Furgoneta {	
	public abstract void arrancar();	
}
