package _5_Join;

public class Prueba {

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
		
		TareaRunnable t1 = new TareaRunnable(datos1);		
		TareaRunnable t2 = new TareaRunnable(datos2);		
		TareaRunnable t3 = new TareaRunnable(datos3);		
		Thread th1 = new Thread(t1);		
		Thread th2 = new Thread(t2);		
		Thread th3 = new Thread(t3);		
		
		th1.start(); //As�ncrona
		th2.start();
		th3.start();
		
		System.out.println("Hilo main haciendo m�s cosas mientras las tarea se completan");
		
		//Una espera activa con while funcionar�a
		//-Esto es cutre porque:
		//-existe el 'join'
		//-Tenemos a un hilo dando vueltas a un while desaprovechando el procesador
		//while(t1.getResultado()==0) { }
		//while(t2.getResultado()==0) { }
		//while(t3.getResultado()==0) { }
		
		//Aqui dice '0'
		System.out.println(t1.getResultado());
		System.out.println(t2.getResultado());
		System.out.println(t3.getResultado());

		try {
			//Cuando un hilo ejecuta un join pasa autom�ticamente al estado 'wait'
			//En este caso es el hilo 'Main' el que ejecuta el join y pasa a estdo 'wait'
			//Cuando el hilo 'th1' termine su tarea ejecutar� un 'notify' que sacar� del estado 'wait'
			//al hilo main
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t1.getResultado());
		System.out.println(t2.getResultado());
		System.out.println(t3.getResultado());
				
	}
	
}
