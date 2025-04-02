package com;

//Constructores compactos
public record Coche(Integer id, String marca, String modelo, String matricula) {
	
	//Si necesitamos proporcionar nuestro código al constructor debemos 'sobreescribirlo' 
	
	//Recibe los parámetros definidos en el record
	public Coche {
		//Esta clase existe desde Java 1.7
		java.util.Objects.requireNonNull(marca, "Marca no puede ser nulo");
	}
	
}

