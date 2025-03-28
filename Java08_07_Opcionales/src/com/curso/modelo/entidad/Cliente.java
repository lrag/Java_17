package com.curso.modelo.entidad;

public class Cliente {

	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String cuentaBancaria;

	public Cliente() {
		super();
	}
	
	public Cliente(Integer id, String nombre, String direccion, String telefono, String cuentaBancaria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cuentaBancaria = cuentaBancaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", cuentaBancaria=" + cuentaBancaria + "]";
	}

}
