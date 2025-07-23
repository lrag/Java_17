package _5_Join;

public class PruebaConJoin {

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
		
		TareaRunnableConJoin t1 = new TareaRunnableConJoin(datos1);		
		TareaRunnableConJoin t2 = new TareaRunnableConJoin(datos2);		
		TareaRunnableConJoin t3 = new TareaRunnableConJoin(datos3);		
		Thread thread1 = new Thread(t1);		
		Thread thread2 = new Thread(t2);		
		Thread thread3 = new Thread(t3);		
		
		thread1.start(); //Asíncrona
		thread2.start();
		thread3.start();
		
		System.out.println("Hilo main haciendo más cosas mientras las tareas se completan");
		
		//Una espera activa con while funcionaría
		//-Esto es cutre porque:
		//-existe el 'join'
		//-Tenemos a un hilo dando vueltas a un while desaprovechando el procesador
		//while(t1.getResultado()==null) { }
		//while(t2.getResultado()==null) { }
		//while(t3.getResultado()==null) { }
		
		//Aqui dice 'null'
		System.out.println(t1.getResultado());
		System.out.println(t2.getResultado());
		System.out.println(t3.getResultado());

		//Thread.yield();
		
		try {
			//Cuando un hilo ejecuta un join pasa automáticamente al estado 'wait'
			//En este caso es el hilo 'Main' el que ejecuta el join y pasa a estado 'wait'
			//Cuando el hilo 'th1' termine su tarea ejecutará un 'notify' que sacará del estado 'wait'
			//al hilo main
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t1.getResultado());
		System.out.println(t2.getResultado());
		System.out.println(t3.getResultado());
				
	}
	
}
