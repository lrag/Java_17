package com.curso.modelo.negocio;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

import com.curso.modelo.entidad.Cliente;

//
// Recibe elementos de un stream por parte del anterior eslab�n de la cadena
// Env�a un elemento al siguiente eslab�n
//
public class ClientesProcessor extends SubmissionPublisher<Cliente> implements Processor<Cliente, Cliente> {

	private FunctionThrows<Cliente, Cliente> funcion;
	private Subscription subscription;
	
	//Dentro de esta funci�n est� el c�digo que procesar� el elemento recibido
	public ClientesProcessor(FunctionThrows<Cliente, Cliente> funcion, Executor executorService) {
		super(executorService,Flow.defaultBufferSize());
		this.funcion = funcion;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
	    this.subscription = subscription;  
	    subscription.request(1); 		
	}

	@Override
	public void onNext(Cliente cliente) {
		try {
			//Invocando la funci�n recibida en el constructor para procesar el elemento y env�a el resultado al siguiente
			submit(funcion.apply(cliente));
			subscription.request(1);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Error procesando:"+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		close();
	}

}


















