package com.curso.modelo.stream;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.curso.modelo.entidad.Cliente;

//
// Env�a un elemento al siguiente eslab�n (por eso hereda de publisher)
// Recibe elementos de un stream por parte del anterior eslab�n de la cadena (por eso implementa processor)
// 
public abstract class ClientesProcessor extends SubmissionPublisher<Cliente> implements Processor<Cliente, Cliente> {

	//La subscripci�n es una representaci�n del enlace entre el productor/publisher y el consumidor/subscriber
	private Subscription subscription;
	
	public ClientesProcessor(Executor executorService) {
		super(executorService,Flow.defaultBufferSize());
	}
	
	public abstract Cliente procesarCliente(Cliente cliente) throws Exception;

	//Estos son los m�todos que tienen los subscriptores
	//Cada uno de ellos es un callback que se ejecuta en el momento adecuado:
	//-onSubscribe: cuando se efect�a la subscripcion
	//-onNext: cuando llega un elemento
	//-onError: cuando el elemento que llega es un error
	//-onComplete: cuando el que env�a los elementos dice que ya no hay m�s

	@Override
	//Este callback se ejecuta cuando el processor se subscribe a un publisher
	//Nada m�s subscribirse solicita un elemento
	public final void onSubscribe(Subscription subscription) {
	    //Si nos quedamos con la subscripcion, por ejemplo, cancelarla
		this.subscription = subscription; 
		//Se solicita el primer elemento
		//Si no lo hay se espera
	    subscription.request(1); 		
	}
	
	@Override
	//Cada vez que llega un elemento por el stream se invoca este callback
	public final void onNext(Cliente cliente) {
		try {
			//Procesa el cliente
			Cliente clienteProcesado = procesarCliente(cliente);
			//Env�a el resultado al siguiente del stream 
			submit(clienteProcesado);
			//Solicita un elemento m�s
			subscription.request(1);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public final void onError(Throwable throwable) {
		System.out.println("Error procesando:"+throwable.getMessage());
	}

	@Override
	public final void onComplete() {
		System.out.println(Thread.currentThread().getId()+"-ClientesProcessor......... FIN");
		close();
	}

}










