package com.curso.modelo.stream;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

//
// Un Subscriber recibe elementos del estream y es el final de la cadena
// Varios subscribers pueden subscribirse al stream
//
public class ClientesSubscriber implements Subscriber<Cliente> {

	//Ning�n elemento del stream debe tener l�gica de negocio y delega la tarea en un servicio
	private ServicioClientes servicioClientes = new ServicioClientes();
		
	//La subscripci�n es una representaci�n del enlace entre el productor/publisher y el consumidor/subscriber
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1); 
	}

	@Override
	public void onNext(Cliente cliente) {
		System.out.println(Thread.currentThread().getId()+"-ClientesSubscriber........ Elemento recibido: "+cliente);
		servicioClientes.insertarCliente(cliente);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable e) {
		System.out.println(Thread.currentThread().getId()+"-Error");
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println(Thread.currentThread().getId()+"-ClientesSubscriber........ FIN");
	}

}




























