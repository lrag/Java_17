package _5_Join;

public class PruebaConWait {

	public static void main(String[] args) {
		
		int[] datos1 = new int[10_000];
		for(int a=0; a<10_000; a++){
			datos1[a] = (int) Math.round(Math.random()*10_000_000);
		}
		
		System.out.println("===========================");
		System.out.println("Hilo main haciendo cosas...");
		
		TareaRunnableConWait t1 = new TareaRunnableConWait(datos1);		
		Thread th1 = new Thread(t1);	
		th1.start();
		
		System.out.println("Hilo main haciendo más cosas mientras las tareas se completan");
		
		try {
			Integer rs = t1.getResultado();
			System.out.println(rs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	
}
