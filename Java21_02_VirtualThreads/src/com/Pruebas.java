package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Pruebas 
{
    public static void main(String[] args) throws IOException, InterruptedException {
          
    	//
    	//Introducidos como preview en Java 19
    	//
    	
    	Thread.sleep(10_000);
    	
    	int nHilos = 10_000;
    	
    	System.out.println("================================");
    	
    	AtomicLong fin = new AtomicLong();
    	
    	long inicio = System.currentTimeMillis();
    	for(int a=0; a<nHilos; a++) {
    		//Thread th = new Thread(new Tarea(fin));
    		//th.start();
    		
    		Thread.startVirtualThread(new Tarea(fin));
    	}
    	
    	long tCreacion = System.currentTimeMillis()-inicio;
    	
    	boolean esperar = true;
    	while(esperar) {
    		
    		long mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    		
    		long tareasCompletadas = fin.get();
    		System.out.println(tareasCompletadas+" - "+mem);
    		if(tareasCompletadas == nHilos) {
    			esperar = false;
    		}
    		Thread.sleep(100);
    	}
    	
    	System.out.println("Tiempo de creación y lanzamiento: "+tCreacion);
    	System.out.println("FIN");
    	
    }

}

class Tarea implements Runnable {
	
	AtomicLong fin;
	
	public Tarea(AtomicLong fin) {
		super();
		this.fin = fin;
	}

	public void run() {
		/*
		List<Double> datos = new ArrayList<>(1_000_000);
		for(int a=0; a<1_000_000; a++) {
			datos.add(Math.random());
		}
		
		datos.stream().sorted().collect(Collectors.toList());
		*/
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fin.incrementAndGet();		
	}
	
}