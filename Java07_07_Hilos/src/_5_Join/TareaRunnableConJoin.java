package _5_Join;


public class TareaRunnableConJoin implements Runnable{

	private int[] datos;
	private Integer resultado;

	public TareaRunnableConJoin(int[] datos) {
		super();
		this.datos = datos;
	}
	
	public Integer getResultado() {
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
