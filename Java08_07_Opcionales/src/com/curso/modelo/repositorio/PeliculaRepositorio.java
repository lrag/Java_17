package com.curso.modelo.repositorio;

import java.util.Optional;

import com.curso.modelo.entidad.Pelicula;

public class PeliculaRepositorio {

	public Pelicula buscar(Integer id){
		switch(id){
			case 1 : return new Pelicula(1,"Alien");
			case 2 : return new Pelicula(2,"Die Hard");
			case 3 : return new Pelicula(3,"Brácula");
			default: return null;		
		}
	}
	
	public Optional<Pelicula> buscarOptional(Integer id){
		
		//Si creamos un opcional con un nulo tenemos un NullPointerException :) 
		//Pelicula p = null;
		//return Optional.of(p);

		switch(id){
			case 1 : return Optional.of(new Pelicula(1,"Alien"));
			case 2 : return Optional.of(new Pelicula(2,"Die Hard"));
			case 3 : return Optional.of(new Pelicula(3,"Bracula"));
			default: return Optional.empty();		
		}
	}

	//Una tercera opción (en un repositorio no tiene sentido)
	public Pelicula buscarExcepción(Integer id) throws NoExisteException{
		switch(id){
			case 1 : return new Pelicula(1,"Alien");
			case 2 : return new Pelicula(2,"Die Hard");
			case 3 : return new Pelicula(3,"Bracula");
			default: throw new NoExisteException();		
		}
	}	
	
}

class NoExisteException extends Exception {
	
}

