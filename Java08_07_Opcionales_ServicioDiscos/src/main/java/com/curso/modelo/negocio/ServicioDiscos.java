package com.curso.modelo.negocio;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Disco;
import com.curso.modelo.persistencia.RepositorioDiscos;

@Service
@Transactional
public class ServicioDiscos {

	private RepositorioDiscos repositorioDiscos;

	public ServicioDiscos(RepositorioDiscos repositorioDiscos) {
		super();
		this.repositorioDiscos = repositorioDiscos;
	}
	
	public Disco insertar(Disco disco) {
		//LN para insertar
		repositorioDiscos.save(disco);
		return disco;
	}
	
	public Disco modificar(Disco disco) {
		//LN para modificar
		repositorioDiscos.save(disco);
		return disco;
	}
	
	public void borrar(Disco disco) {
		repositorioDiscos.delete(disco);
	}
	
	public Optional<Disco> buscar(Integer id) {
		//return repositorioDiscos
		//	.findById(id)
		//	.orElse(null);
		return repositorioDiscos.findById(id);
	}
	
	public Optional<String> buscarTitulo(Integer id) {
		return repositorioDiscos
			.findById(id)
			.map( d -> d.getTitulo() );
	}
	
}
