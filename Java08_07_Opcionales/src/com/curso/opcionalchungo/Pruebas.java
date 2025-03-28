package com.curso.opcionalchungo;

public class Pruebas {
	
	public static void main(String[] args) {
		
		System.out.println("===================================");
		OptionalChungo op1 = OptionalChungo.of("ringo starr");		
		System.out.println(op1.get());
		
		//Object op2 = OptionalChungo.of("hola")
		Object op2 = OptionalChungo.empty()
				.map( v -> ((String) v).toUpperCase() )
				.map( v -> ((String) v)+((String) v) )
				.orElse("NO HAY");		
		System.out.println(op2);	
		
		System.out.println("===================================");
		
		PeliculaRepositorio peliculaRepo = new PeliculaRepositorio();
		
		OptionalChungo op3 = peliculaRepo.buscar(1)
			.flatMap(p -> ((Pelicula)p).getDirector())
			.flatMap(d -> ((Director)d).getDireccion())
			.map(d -> ((Direccion)d).getCalle());		
		if(op3.isPresent()) {
			System.out.println("Calle: "+op3.get());
		}
					
		Object calle = peliculaRepo.buscar(1)
			.flatMap(p -> ((Pelicula)p).getDirector())
			.flatMap(d -> ((Director)d).getDireccion())
			.map(d -> ((Direccion)d).getCalle())
			.orElse("Na de ná");			
		System.out.println("Calle: "+calle);
		
	}	

}
