package com.curso.modelo.repositorio;

import java.util.Optional;

import com.curso.modelo.entidad.Cliente;

public class ClienteRepositorio {
	
	public Optional<Cliente> buscar(Integer id){
			
		switch(id){
			case 1 : return Optional.of(new Cliente(1,"Fistro","C/Tal, 123","123456789","CB1"));
			case 2 : return Optional.of(new Cliente(2,"Fistra","C/Pascual, 123","987654321","CB2"));
			case 3 : return Optional.of(new Cliente(3,"Menganita","C/Tal y Pascual, 123","111222333","CB3"));
			case 4 : return Optional.of(new Cliente(4,"Menganito","C/Pascual y Tal, 123","444555666","CB4"));
			case 5 : return Optional.of(new Cliente(5,"John Lewis","C/Falsa, 123","555555555","CB5"));
			default: return Optional.empty();		
		}
		
	}
	
}
