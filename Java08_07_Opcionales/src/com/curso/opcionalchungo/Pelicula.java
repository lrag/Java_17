package com.curso.opcionalchungo;

public class Pelicula {
	
	private Integer id;
	private String titulo;
	private OptionalChungo director;
	
	public Pelicula() {
		super();
		director = OptionalChungo.empty();
	}

	public Pelicula(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		
		//Esto sería lo adecuado
		//director = Optional.empty();
		
		Director d = new Director("Sr. Smith");
		this.director = OptionalChungo.of(d);
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

	public OptionalChungo getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = OptionalChungo.of(director);
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + "]";
	}

}
