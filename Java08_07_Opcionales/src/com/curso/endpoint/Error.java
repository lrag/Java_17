package com.curso.endpoint;

public class Error {

	private String mensaje;
	private String descripcion;

	public Error() {
		super();
	}

	public Error(String mensaje, String descripcion) {
		super();
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Error [mensaje=" + mensaje + ", descripcion=" + descripcion + "]";
	}

}
