package com.curso.endpoint.dto;

import com.curso.modelo.entidad.Disco;

public class DiscoDTO {

	private Integer id;
	private String titulo;
	private String grupo;
	private Integer year;
	private String genero;
	private String notas;

	public DiscoDTO() {
		super();
	}
	
	public DiscoDTO(Disco disco) {
		super();
		id = disco.getId();
		titulo = disco.getTitulo();
		grupo = disco.getGrupo();
		year = disco.getYear();
		genero = disco.getGenero();
		notas = disco.getNotas();
	}
	
	public DiscoDTO(Integer id, String titulo, String grupo, Integer year, String genero, String notas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.grupo = grupo;
		this.year = year;
		this.genero = genero;
		this.notas = notas;
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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public Disco asDisco() {
		return new Disco(id, titulo, grupo, year, genero, notas);
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", grupo=" + grupo + ", year=" + year + ", genero=" + genero
				+ ", notas=" + notas + "]";
	}

}
