package com.curso.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.DiscoDTO;
import com.curso.modelo.entidad.Disco;
import com.curso.modelo.negocio.ServicioDiscos;
import com.curso.modelo.persistencia.RepositorioDiscos;

@RestController
public class DiscosEndpoint {

	private RepositorioDiscos repositorioDiscos;
	private ServicioDiscos servicioDiscos;
	
	public DiscosEndpoint(RepositorioDiscos repositorioDiscos, ServicioDiscos servicioDiscos) {
		super();
		this.repositorioDiscos = repositorioDiscos;
		this.servicioDiscos = servicioDiscos;
	}
	
	@GetMapping(
			path = "/discos",
			produces = "application/json"
		)
	public List<DiscoDTO> listar(){
		/*
		List<Disco> discos = repositorioDiscos.findAll();
		List<DiscoDTO> discosDTO = new ArrayList<>();
		for(Disco d : discos) {
			discosDTO.add(new DiscoDTO(d));
		}
		return discosDTO;
		*/
		
		return repositorioDiscos.findAll()
			.stream()
			.map( d -> new DiscoDTO(d))
			.collect(Collectors.toList());
	}
	
	/*
	@GetMapping(
			path = "/discos/{id}",
			produces = "application/json"
			)
	public ResponseEntity<DiscoDTO> buscar(@PathVariable Integer id){
		return repositorioDiscos
				.findById(id)
				.map(d -> new ResponseEntity<DiscoDTO>(new DiscoDTO(d), HttpStatus.OK))			
				.orElse(new ResponseEntity<DiscoDTO>(HttpStatus.NOT_FOUND));
	}
	*/
	
	@GetMapping(
			path = "/discos/{id}",
			produces = "application/json"
			)
	public ResponseEntity<DiscoDTO> buscar(@PathVariable Integer id){
		/*
		Disco d = servicioDiscos.buscar(id);
		if(d != null) {
			return new ResponseEntity<DiscoDTO>(new DiscoDTO(d), HttpStatus.OK);
		}
		return new ResponseEntity<DiscoDTO>(HttpStatus.NOT_FOUND);
		*/
		return servicioDiscos.buscar(id)
				.map(d -> new ResponseEntity<DiscoDTO>(new DiscoDTO(d), HttpStatus.OK))			
				.orElse(new ResponseEntity<DiscoDTO>(HttpStatus.NOT_FOUND));
		
	}

	@GetMapping(
			path = "/discos/{id}/titulo",
			produces = "application/json"
			)
	public ResponseEntity<String> buscarTitulo(@PathVariable Integer id){
		return servicioDiscos.buscarTitulo(id)
				.map( titulo -> new ResponseEntity<String>(titulo, HttpStatus.OK))			
				.orElse(new ResponseEntity<String>(HttpStatus.NOT_FOUND));
		
	}
	
	@PostMapping( 
			path = "/discos",
			consumes = "application/json",
			produces = "application/json"
			)
	public ResponseEntity<DiscoDTO> insertar(@RequestBody() DiscoDTO discoDto) {
		Disco discoInsertado = servicioDiscos.insertar(discoDto.asDisco());
		return new ResponseEntity<>(new DiscoDTO(discoInsertado), HttpStatus.CREATED);		
	}
	
}
