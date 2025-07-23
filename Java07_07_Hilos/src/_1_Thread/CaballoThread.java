package _1_Thread;

public class CaballoThread extends Thread {

	private String nombre;
	
	public CaballoThread(String nombre) {
		super();
		this.nombre = nombre;
	}

	//El método run de la clase Thread está vacío y debemos sobreescribirlo si estamos heredando
	//public void run() {
	//
	//}
	
	@Override
	public void run() {

		for(int a=0; a<=100; a++){
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.printf("Soy el caballo %10s y he recorrido %d\n", nombre, a);
		}
		
	}

}
