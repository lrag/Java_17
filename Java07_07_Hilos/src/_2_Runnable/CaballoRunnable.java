package _2_Runnable;

public class CaballoRunnable implements Runnable {

	private String nombre;
	
	public CaballoRunnable(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {

		for(int a=0; a<=100; a++){
			System.out.printf("Soy el caballo %10s y he recorrido %d\n", nombre, a);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
