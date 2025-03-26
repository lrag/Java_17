package _6_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PruebasListaTareas {

	public static void main(String[] args) {

		int[] datos1 = new int[10_000];
		int[] datos2 = new int[10_000];
		int[] datos3 = new int[10_000];
		for(int a=0; a<10_000; a++){
			datos1[a] = (int) Math.round(Math.random()*10_000_000);
			datos2[a] = (int) Math.round(Math.random()*10_000_000);
			datos3[a] = (int) Math.round(Math.random()*10_000_000);
		}
		
		System.out.println("===========================");
		System.out.println("Hilo main haciendo cosas...");
		Tarea t1 = new Tarea(datos1);
		Tarea t2 = new Tarea(datos2);
		Tarea t3 = new Tarea(datos3);

		//Ese executor procesa las tareas de una en una
		//ExecutorService walker = Executors.newSingleThreadExecutor();

		//Este un máximo de dos.
		ExecutorService walker = Executors.newFixedThreadPool(2);
		//Podemos ir añadiendo las tareas una a una según van llegando
		//Y esta la manera más habitual de hacerlo
		//Future<Integer> max1 = walker.submit(t1);
		//Future<Integer> max2 = walker.submit(t2);
		//Future<Integer> max3 = walker.submit(t3);

		//Podemos también enchufarle una lista de tareas al executor
		List<Tarea> tareas = new ArrayList<>();
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);

		try {
			//Invoke any recibe una coleccion de tareas, espera a que una de ellas acabe
			//saca el valor del future y nos lo da.
			//El resto de las tareas son fulminadas (hay excepcion porque son fulminadas en durante un sleep)
			
			//invokeAny es SINCRONO!!!			
			//Integer max = walker.invokeAny(tareas);
			//System.out.println("Invoke any:"+max);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			//Invoke all recibe una coleccion de tareas, espera a que todas
			//acaben y obtenemos una lista de futures
			List<Future<Integer>> maximos = walker.invokeAll(tareas);

			for(Future<Integer> f : maximos){
				System.out.println("InvokeAll:"+f.get());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("Seguimos...");

		//
		walker.shutdown();


	}
	
}
