package _4_WaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	private Queue<String> cola = new LinkedList<>();

	public synchronized void addMensaje(String mensaje) {
		
		while(cola.size()==4) {
			System.out.println("Cola llena");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		
		notify();
		cola.offer(mensaje);				
	}
	
	public synchronized String getMensaje() {
		
		while(cola.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		
		notify();		
		//notifyAll();
		
		return cola.poll();		
	}
	
}

