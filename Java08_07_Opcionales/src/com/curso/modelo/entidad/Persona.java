package com.curso.modelo.entidad;

import java.util.Optional;

public class Persona {

	private String nombre;
	private Optional<Direccion> direccion;

	public Persona() {
		super();
	}

	public Persona(String nombre, Direccion direccion) {
		super();
		this.nombre = nombre;
		if(direccion != null) {
			this.direccion = Optional.of(direccion);
		}
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
		if(direccion != null) {
			this.direccion = Optional.of(direccion);
		}
	}

}
