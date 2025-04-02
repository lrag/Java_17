package com.curso.equals_hash_code.fin;

import java.util.Objects;

public class Producto {

	private String nombre;
	private String fabricante;
	private String descripcion;

	public Producto() {
		super();
	}

	public Producto(String nombre, String fabricante, String descripcion) {
		super();
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//Estos dos métodos siempre tienen que estar correctamente implementados
	@Override
	public int hashCode() {
		return Objects.hash(nombre,fabricante,descripcion);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Producto)) {
			return false;
		}
		
		Producto otroProducto = (Producto) obj;
		return nombre.equals(otroProducto.nombre) 
			   && fabricante.equals(otroProducto.fabricante)
			   && descripcion.equals(otroProducto.descripcion);
	}

	
}
