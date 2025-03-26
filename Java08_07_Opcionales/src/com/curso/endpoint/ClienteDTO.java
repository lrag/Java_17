package com.curso.endpoint;

import com.curso.modelo.entidad.Cliente;

public class ClienteDTO {

	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id        = cliente.getId();
		this.nombre    = cliente.getNombre();
		this.direccion = cliente.getDireccion();
		this.telefono  = cliente.getTelefono();
	}
	
	public ClienteDTO(Integer id, String nombre, String direccion, String telefono) {
		super();
		this.id        = id;
		this.nombre    = nombre;
		this.direccion = direccion;
		this.telefono  = telefono;
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

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	public Cliente asCliente() {
		return new Cliente(id,nombre,direccion,telefono,null);
	}

}
