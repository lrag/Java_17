package com.curso.modelo.entidad;

import java.util.Optional;

public class Director {

	private String nombre;
	private Optional<Direccion> direccion;

	public Director() {
		super();
		direccion = Optional.empty();
	}

	public Director(String nombre) {
		super();
		this.nombre = nombre;

		//direccion = Optional.empty();

		direccion = Optional.of(new Direccion("Chinchón","Plaza"));		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Optional<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = Optional.of(direccion);
	}	

}
