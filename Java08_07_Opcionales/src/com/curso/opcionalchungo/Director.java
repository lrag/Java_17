package com.curso.opcionalchungo;

public class Director {

	private String nombre;
	private OptionalChungo direccion;

	public Director() {
		super();
		direccion = OptionalChungo.empty();
	}

	public Director(String nombre) {
		super();
		this.nombre = nombre;
		direccion = OptionalChungo.of(new Direccion("Chinchón","Plaza"));		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public OptionalChungo getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = OptionalChungo.of(direccion);
	}	

}
