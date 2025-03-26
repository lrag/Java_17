package com.curso.endpoint;

public class Data {

	private String nombre;
	private Object valor;

	public Data() {
		super();
	}

	public Data(String nombre, Object valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Data [nombre=" + nombre + ", valor=" + valor + "]";
	}

}
