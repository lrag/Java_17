package com.curso.endpoint;

import com.curso.modelo.repositorio.ClienteRepositorio;

//@RestController
public class ClientesRest {

	//@Autowired
	private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
	
	//GET /clientes/{id}
	//@GetMapping(path="/clientes/{id}", productes...)
	public Respuesta buscarCliente(Integer id) {
		
		/*
		//Imperativo
		Optional<Cliente> clienteOp = clienteRepositorio.buscar(id);
		if(clienteOp.isEmpty()) {
			return new Respuesta(404,"NOT FOUND", new Error("El cliente no existe",null), null);
		} 
		ClienteDTO clienteDTO = new ClienteDTO(clienteOp.get());
		return new Respuesta(200,"OK", null, new Data("cliente", clienteDTO));
		*/
		
		/////////////////////////////////////////
		
		//Declarativo - funcional
		return clienteRepositorio
			.buscar(id)
			.map( cliente -> new ClienteDTO(cliente) )
			.map( clienteDTO -> new Respuesta(200,"OK", null, new Data("cliente", clienteDTO)))
			.orElse(new Respuesta(404,"NOT FOUND", new Error("El cliente no existe",null), null));
	}
	
}







