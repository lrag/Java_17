package _2_Runnable;

public class Carrera {

	public static void main(String[] args) {
		
		CaballoRunnable c1 = new CaballoRunnable("Rocinante");
		CaballoRunnable c2 = new CaballoRunnable("Bucefalo");
		CaballoRunnable c3 = new CaballoRunnable("Imperioso");
		
		//Esto se ejecuta secuencialmente. Llamar a 'run' no crea un hilo
		//c1.run();
		//c2.run();
		//c3.run();
		
		Thread th1 = new Thread(c1);
		Thread th2 = new Thread(c2);
		Thread th3 = new Thread(c3);
		th1.start();
		th2.start();
		th3.start();
		
		//...
	}
	
}
