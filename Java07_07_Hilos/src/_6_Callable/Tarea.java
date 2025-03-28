package _6_Callable;

import java.util.concurrent.Callable;

//Callable desde Java 1.5
public class Tarea implements Callable<Integer>{

	private int[] datos;

	public Tarea(int[] datos) {
		super();
		this.datos = datos;
	}

	public Integer call(){		
		Integer max = Integer.MIN_VALUE;
			for(int a=0; a<datos.length; a++){
			if(datos[a] > max)
				max = datos[a];
		}

		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Soy la tarea y el máximo es:"+max+", TH:"+Thread.currentThread().getId());
		return max;	
	}
	
}



