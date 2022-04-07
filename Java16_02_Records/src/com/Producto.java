package com;

//Record con sobreescritura y m�todos
public record Producto(Integer id, String nombre, String fabricante) {
	
	@Override
	public String toString() {
		return id+","+nombre+","+fabricante;
	}
	
	@Override
	public boolean equals(Object otroObjeto) {
		if(!(otroObjeto instanceof Producto otroProducto)) {
			return false;
		}
		return id.equals(otroProducto.id);
	}
	
	public void metodo() {
		System.out.println("M�todo del record Producto");
	}
	
}
