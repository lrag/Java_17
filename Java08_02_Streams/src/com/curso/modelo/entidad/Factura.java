package com.curso.modelo.entidad;

import java.util.Comparator;

public class Factura implements Comparable<Factura>{

	private Integer id;
	private String codigo;
	//n..1
	private Cliente cliente;
	private Double total;

	public Factura() {
		super();
	}
	
	public Factura(String codigo) {
		super();
		this.codigo = codigo;
	}

	public Factura(Integer id, String codigo, Cliente cliente, Double total) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cliente = cliente;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", codigo=" + codigo + ", total=" + total /*+ ", idCliente="+cliente.getId()*/+"]";
	}

	@Override
	//El orden natural de las facturas en esta aplicacion es por importe
	public int compareTo(Factura otraFactura) {
		return total.intValue()-otraFactura.total.intValue();
	}
	
}




