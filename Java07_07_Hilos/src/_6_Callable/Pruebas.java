package _6_Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pruebas {

	public static void main(String[] args) {

		System.out.println("===================================");
		
		int[] datos = new int[10_000];
		for(int a=0; a<10_000; a++){
			datos[a] = (int) Math.round(Math.random()*10_000_000);
		}

		Tarea t = new Tarea(datos);

		//Integer resultado = t.call(); esto es como llamar directamente al run de un runnable

		//Un runnable se lanza como hilo usando un objeto de la clase Thread
		//Un callable necesita un ExecutorService
		
		ExecutorService terminator = Executors.newSingleThreadExecutor(); //El ejecutor dispone de solo un hilo
		
		//La llamada a submit es asíncrona
		System.out.println("Hilo "+Thread.currentThread().getName()+" lanzando una tarea...");
		Future<Integer> max = terminator.submit(t);
		
		System.out.println("Seguimos...");

		
		try {
			System.out.println("Pruebas.java:"+max.get()); //hace un join si el integer no está 
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("Fin");

		//
		terminator.shutdown();

	}
	
}
