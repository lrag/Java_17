package com;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.stream.ClientesProcessorDatos;
import com.curso.modelo.stream.ClientesProcessorFacturas;
import com.curso.modelo.stream.ClientesProcessorPedidos;
import com.curso.modelo.stream.ClientesPublisher;
import com.curso.modelo.stream.ClientesSubscriber;
import com.curso.modelo.stream.EstadisticasSubscriber;

public class Pruebas {

	public static void main(String[] args) throws InterruptedException {

		List<Cliente> clientes = List.of(new Cliente(1), new Cliente(2), new Cliente(3), new Cliente(4), new Cliente(5),
				new Cliente(6), new Cliente(7), new Cliente(8), new Cliente(9));

		//Executor executorService = Executors.newSingleThreadScheduledExecutor();
		Executor executorService = Executors.newFixedThreadPool(8);

		// Creamos los elementos del stream
		ClientesPublisher cliPublisher = new ClientesPublisher(executorService);
		ClientesProcessorDatos cliProcessorDatos = new ClientesProcessorDatos(executorService);
		ClientesProcessorPedidos cliProcessorPedidos = new ClientesProcessorPedidos(executorService);
		ClientesProcessorFacturas cliProcessorFacturas = new ClientesProcessorFacturas(executorService);
		ClientesSubscriber cliSubscriber = new ClientesSubscriber();
		EstadisticasSubscriber estadisticasSubscriber = new EstadisticasSubscriber();

		// Construimos el stream
		cliPublisher.addSubscriber(cliProcessorDatos);
		cliProcessorDatos.subscribe(cliProcessorPedidos);
		cliProcessorPedidos.subscribe(cliProcessorFacturas);
		//Añadimos dos subscriptores al último processor
		cliProcessorFacturas.subscribe(cliSubscriber);
		cliProcessorFacturas.subscribe(estadisticasSubscriber);

		// Le enviamos elementos al publisher para que los lance por el stream
		for (Cliente cliente : clientes) {
			cliPublisher.publicarCliente(cliente);
		}
		cliPublisher.finalizarStream();

		Thread.sleep(20000);
		System.exit(0);
	}

}
