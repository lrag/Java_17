package com.modelo;

public class Cliente {

	private String nombre;

	public Cliente() {
		super();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	//Hasta Java 15
	/*
	public boolean equals(Object otroObjecto) {
		
		if(!(otroObjecto instanceof Cliente)){
			return false;
		}
		Cliente otroCliente = (Cliente) otroObjecto;
		
		return true;
	}
	*/	
	
	//Un equals más reducido con el nuevo instanceof
	public boolean equals(Object otroObjeto) {
		if(!(otroObjeto instanceof Cliente otroCliente)) {
			return false;
		}
		return otroCliente.nombre.equals(nombre);
	}

}
