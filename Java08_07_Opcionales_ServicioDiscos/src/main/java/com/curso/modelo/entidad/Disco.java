package com.curso.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String grupo;
	@Column(name = "year_disco")
	private Integer year;
	private String genero;
	private String notas;

	public Disco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disco(Integer id, String titulo, String grupo, Integer year, String genero, String notas) {
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

	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", grupo=" + grupo + ", year=" + year + ", genero=" + genero
				+ ", notas=" + notas + "]";
	}

}
