package com.curso.modelo.stream;

import java.util.concurrent.Executor;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

//
// Recibe un cliente que solo tiene el id y lo env�a con sus datos
//
public class ClientesProcessorDatos extends ClientesProcessor {

	//Ning�n elemento del stream debe tener l�gica de negocio y delega la tarea en un servicio
	private ServicioClientes servicioClientes = new ServicioClientes();
	
	public ClientesProcessorDatos(Executor executorService) {
		super(executorService);
	}
	
	public Cliente procesarCliente(Cliente cliente) throws Exception {
		System.out.println(Thread.currentThread().getId()+"-ClientesProcessorDatos.... Elemento recibido: "+cliente);
		return servicioClientes
			.buscarCliente(cliente.getId())
			.orElseThrow(()->new Exception("Zasca"));	
	}

}










