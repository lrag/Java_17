package com.curso.atributo_estatico;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {

	//¿Y si quitamos este static?
	public static List<String> eventos = new ArrayList<String>();

	public void enviarEvento(String evento) {
		//Entregar el evento a los subscriptores
		//...
		eventos.add(evento);
	}	
	
}

