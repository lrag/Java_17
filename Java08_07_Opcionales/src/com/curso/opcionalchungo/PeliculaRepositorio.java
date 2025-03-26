package com.curso.opcionalchungo;

public class PeliculaRepositorio {

	public OptionalChungo buscar(Integer id){
		switch(id){
			case 1 : return OptionalChungo.of(new Pelicula(1,"Alien"));
			case 2 : return OptionalChungo.of(new Pelicula(2,"Die Hard"));
			case 3 : return OptionalChungo.of(new Pelicula(3,"Bracula"));
			default: return OptionalChungo.empty();		
		}
	}

}


