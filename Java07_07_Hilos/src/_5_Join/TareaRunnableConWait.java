package _5_Join;


public class TareaRunnableConWait implements Runnable{

	private int[] datos;
	private Integer resultado;

	public TareaRunnableConWait(int[] datos) {
		super();
		this.datos = datos;
	}
	
	public synchronized Integer getResultado() throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName()+": Entrando en getResultado");
		
		if(resultado == null) {
			System.out.println(Thread.currentThread().getName()+": wait");
			wait();
		}
		
		return resultado;
	}
	
	public void run(){
		
		Integer max = Integer.MIN_VALUE;
		for(int a=0; a<datos.length; a++){
			if(datos[a] > max)
				max = datos[a];
		}

		try {
			Thread.sleep(5_0_0_0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Soy la tarea y el máximo es:"+max+", TH:"+Thread.currentThread().getId());
		
		resultado = max;
		
		synchronized(this) {
			notify();
		}
	}
	
}
