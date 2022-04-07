package com;

//Constructores compactos
public record Coche(Integer id, String marca, String modelo, String matricula) {
	
	//Si necesitamos proporcionar nuestro c�digo al constructor debemos 'sobreescribirlo' 
	
	//Recibe los par�metros definidos en el record
	public Coche {
		//Esta clase existe desde Java 1.7
		java.util.Objects.requireNonNull(marca, "Marca no puede ser nulo");
	}
	
}