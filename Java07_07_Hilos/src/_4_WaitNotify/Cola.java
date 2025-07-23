package _4_WaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	private Queue<String> cola = new LinkedList<>();

	public synchronized void addMensaje(String mensaje) {
		
		while(cola.size()>3) {
			try {
				System.out.println("Cola llena");
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		cola.offer(mensaje);	
		notify();
	}
	
	public synchronized String getMensaje() {
		
		while(cola.size()==0) {
			try {
				System.out.println("Cola vacía");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
		notify();
		return cola.poll();		
	}	
	
}

