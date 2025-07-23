package _3_Synchronized;

import java.util.ArrayList;
import java.util.List;

public class Meta {

	//
	//CUIDADO CON ARRAY LIST QUE NO ES THREAD SAFE!
	//
	private List<CaballoRunnable> clasificacion = new ArrayList<>();
 	
	public List<CaballoRunnable> getClasificacion(){
		return clasificacion;
	}
		
	//Sincronizando el método impedimos que entre más de un hilo a la vez
	public synchronized void apuntar(CaballoRunnable caballo){
		
		//System.out.println(caballo.getNombre()+": Pos "+clasificacion.size());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		clasificacion.add(caballo);
		
	}	
	
	public void apuntar2(CaballoRunnable caballo){
		
		//
		//
		//
		//
		//Aqui tambien serviría 'clasificacion'
		//synchronized(clasificacion) {
		
		//Si hacemos esto estamos haciendo el tonto porque cada hilo tiene su propio 'recurso compartido'
		//Object obj = new Object();
		//synchronized(obj) {
			
		synchronized(this) {			
			clasificacion.add(caballo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();			}
			System.out.println(caballo.getNombre()+": Pos "+clasificacion.size());
		}
		//
		//
		//
		//
		
	}	
	
	
}




class Movida {
	
	int dato;
	
	public synchronized void metodo1() {
		dato++;
	}
	
	public void metodo2() {
		//Aqui no usamos dato
	}
	
	public synchronized void metodo3() {
		dato--;
	}
	
}



class Movida2 {
	
	Integer dato1;
	Integer dato2;
	
	public void metodo1() {
		
		synchronized(dato1) {
			dato1++;
		}
	}
	
	public void metodo2() {
		//Aqui no usamos dato
	}
	
	public void metodo3() {
		synchronized(dato2) {
			dato2--;
		}
	}
	
}


