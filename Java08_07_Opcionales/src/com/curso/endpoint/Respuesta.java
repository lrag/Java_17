package com.curso.endpoint;

public class Respuesta {

	private int status;
	private String mensaje;
	private Error error;
	private Data data;

	public Respuesta() {
		super();
	}

	public Respuesta(int status, String mensaje, Error error, Data data) {
		super();
		this.status = status;
		this.mensaje = mensaje;
		this.error = error;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Respuesta [status=" + status + ", mensaje=" + mensaje + ", error=" + error + ", data=" + data + "]";
	}

}
