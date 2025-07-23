package _1_Thread;

public class Carrera {

	public static void main(String[] args) {
		
		
		CaballoThread c1 = new CaballoThread("Rocinante");
		CaballoThread c2 = new CaballoThread("Bucefalo");
		CaballoThread c3 = new CaballoThread("Imperioso");
		
		//Esto se ejecuta secuencialmente. Llamar a 'run' no crea un hilo
		//c1.run();
		//c2.run();
		//c3.run();
		
		//Dentro de start se crea un nuevo hilo que empieza a ejecutar
		//el método run del objeto indicado
		c1.start(); //Start es un método asíncrono
		c2.start();
		c3.start();
		
	}
	
}



