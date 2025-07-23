package _4_WaitNotify;

public class Pruebas {

	public static void main(String[] args) {
		
		Cola c = new Cola();
		
		Productor p1 = new Productor("P1", c);
		Productor p2 = new Productor("P2", c);
		Productor p3 = new Productor("P3", c);
		
		Consumidor c1 = new Consumidor("C1", c);
		Consumidor c2 = new Consumidor("C2", c);
		Consumidor c3 = new Consumidor("C3", c);
		
		Thread th1 = new Thread(p1);
		Thread th2 = new Thread(p2);
		Thread th3 = new Thread(p3);
		Thread th4 = new Thread(c1);
		Thread th5 = new Thread(c2);
		Thread th6 = new Thread(c3);

		th1.start(); 
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		
	}
	
}
