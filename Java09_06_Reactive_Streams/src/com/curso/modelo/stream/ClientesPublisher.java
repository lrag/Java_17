package com.curso.modelo.stream;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

import com.curso.modelo.entidad.Cliente;

//
// Esta clase utiliza un SubmissionPublisher para enviar elementos a un stream
// No hereda ni implementa nada
//
public class ClientesPublisher {
	
	private SubmissionPublisher<Cliente> publisher;

	public ClientesPublisher(Executor executorService) {
		super();
		//Si queremos solo un hilo para procesar los clientes en la cadena
		//Executor executorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Flow.defaultBufferSize:"+Flow.defaultBufferSize());
		publisher = new SubmissionPublisher<>(executorService,Flow.defaultBufferSize());
	}
	
	//Env�a el elemento al primer eslab�n del stream
	public void publicarCliente(Cliente cliente) {
		System.out.println(Thread.currentThread().getId()+"-ClientesPublisher.......... Publicando cliente "+cliente);		
		publisher.submit(cliente);
	}	

	//Para indicar a los subscriptores que no habr� m�s elementos
	public void finalizarStream() {
		System.out.println(Thread.currentThread().getId()+"-ClientesPublisher.......... Cerrando el stream");		
		publisher.close();
	}		
	
	public void addSubscriber(Subscriber<Cliente> subscriptor) {
		publisher.subscribe(subscriptor);
	}
	
}
