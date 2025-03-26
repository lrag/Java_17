package _5_Join;


public class TareaRunnable implements Runnable{

	private int[] datos;
	private int resultado;

	public TareaRunnable(int[] datos) {
		super();
		this.datos = datos;
	}
	
	public int getResultado() {
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
	}
	
}
