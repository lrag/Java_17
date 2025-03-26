package com.curso.modelo.entidad;

import java.util.Optional;

public class Pelicula {
	
	private Integer id;
	private String titulo;
	
	//No es buena idea definir atributos de tipo Optional. 
	//Es muy mala idea
	//Es una mala práctica
	//Es un antipatrón
	//Es querer morirse
	//Debemos utilizarlos sólo como return en métodos
	private Optional<Director> director;
	
	public Pelicula() {
		super();
		director = Optional.empty();
	}

	public Pelicula(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		
		//Esto sería lo adecuado
		//director = Optional.empty();
		
		Director d = new Director("Sr. Smith");
		this.director = Optional.of(d);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Optional<Director> getDirector() {
		return director;
	}
	
	//
	//Esto no:
	/*
	public void setDirector(Optional<Director> director) {
		this.director = director;
	}*/

	//Asín:
	public void setDirector(Director director) {
		this.director = Optional.of(director);
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + "]";
	}

}
