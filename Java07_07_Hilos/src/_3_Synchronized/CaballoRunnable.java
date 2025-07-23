package _3_Synchronized;

public class CaballoRunnable implements Runnable {

	private String nombre;
	private Meta meta;
	
	public CaballoRunnable(String nombre, Meta meta) {
		super();
		this.nombre = nombre;
		this.meta   = meta;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {

		for(int a=0; a<=100; a++){
			System.out.printf("Soy el caballo %10s y he recorrido %d\n", nombre, a);
			
			/*
			try {
				Thread.sleep(0,500_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/

		}
		
		meta.apuntar(this);
	}

}
