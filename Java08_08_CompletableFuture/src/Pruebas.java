import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.curso.negocio.GestorFicheros;

public class Pruebas {

	public static void main(String[] args) throws IOException {
		
		GestorFicheros gf = new GestorFicheros();

		
		//Síncrono
		/*
		System.out.println("===================================");
		String contenidoStr = gf.leerFicheroSincrono("fichero.txt");
		System.out.println(contenidoStr);
		*/
	
		System.out.println("===================================");
		Future<String> contenido = gf.leerFicheroAsincrono("fichero.txt");	
		//
		//Hacer otras cosas
		//
		System.out.println("Haciendo otras cosas...");
		
		try {
			System.out.println(contenido.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("===================================");
		Future<String> contenido2 = gf.leerFicheroAsincrono2("ficheroTOCOTO.txt");
		//
		// Más código
		//
		System.out.println("Haciendo más cositas...");
		
		try {
			System.out.println(contenido2.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================");
		Future<String> contenido3 = gf.leerFicheroAsincrono3("fichero.txt");		
		//
		// Más movidas
		//
		System.out.println("Haciendo otras movidas mientras tanto...");
		
		try {
			System.out.println(contenido3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}	
		
		System.out.println("===================================");
		Future<String> contenido3Bis = gf.leerFicheroAsincrono4("fichero.txt");		
		//
		// Más movidas
		//
		System.out.println("Haciendo otras historias...");
		
		try {
			System.out.println(contenido3Bis.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}	

		System.out.println("===================================");
		Future<String> contenido4 = gf.concatenar("fichero.txt", "fichero2.txt");
		//
		// Más historias
		//
		System.out.println("Dándolo todo con otras tareas..."+Thread.currentThread().getId());
		
		try {
			System.out.println(contenido4.get());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		System.exit(42);
		
		
		System.out.println("===================================");
		Future<String> contenido5 = gf.concatenar2("fichero.txt", "fichero2.txt");		
		//
		// Movidas gordísimas
		//
		System.out.println("A tope con las tareas en paralelo...");
		try {
			System.out.println(contenido5.get());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("FIN");
		
	}

}












