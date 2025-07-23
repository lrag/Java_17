package _4_WaitNotify;

public class Productor implements Runnable {

	private String nombre;
	private Cola cola;

	public Productor(String nombre, Cola cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void run(){
		
		for(int a=0; a<10; a++){
			String mensaje = nombre+"_"+a;
			System.out.println(nombre+":"+mensaje);
			cola.addMensaje(mensaje);		
		}
		
	}

}
