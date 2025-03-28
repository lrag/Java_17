package com.curso.negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class GestorFicheros {

	//
	//Síncrono
	//
	public String leerFicheroSincrono(String fichero) throws IOException{
		Path path = Paths.get(fichero);
		byte[] contenido = Files.readAllBytes(path);
		return new String(contenido);
	}	
	
	//
	//Devolviendo un valor conocido en caso de fallo
	//
	//CompletableFuture hereda de Future
	public Future<String> leerFicheroAsincrono(String fichero){

		CompletableFuture<String> cf = new CompletableFuture<>();
		
		//submit recibe un objeto callable o runnable y crea un nuevo hilo para
		//ejecturar su método call/run		
		Executors.newSingleThreadExecutor().submit( () -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Path path = Paths.get(fichero);	
				try {
					byte[] contenido = Files.readAllBytes(path);
					cf.complete(new String(contenido));					
				} catch (IOException e) {
					e.printStackTrace();
					//Esto es cutre
					cf.complete("No existe el fichero");
				}				
			});
		
		return cf;
	}

	//
	//Tratamiento de errores
	//
	public Future<String> leerFicheroAsincrono2(String fichero){

		CompletableFuture<String> cf = new CompletableFuture<>();
		
		Executors.newCachedThreadPool().submit( () -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Path path = Paths.get(fichero);
				try {					
					byte[] contenido = Files.readAllBytes(path);
					cf.complete(new String(contenido));					
					//cf.complete(Files.readString(path));
				} catch (IOException e) {
					e.printStackTrace();
					cf.completeExceptionally(new Exception("NO EXISTE EL FICHERO"));
					//Si queremos pasar la verdadera excepción:
					//cf.completeExceptionally(e);
				}
			});

		return cf;
	}

	//
	//Tal y como está este método es equivalente a 'leerFicheroAsincrono'
	//
	public Future<String> leerFicheroAsincrono3(String fichero){

		return CompletableFuture.supplyAsync(
			() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Path path = Paths.get(fichero);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return new String(contenido);
					//return Files.readString(path);
				} catch (IOException e) {
					//e.printStackTrace();
					//Esto es cutre
					return "El fichero no existe";
				}
			});
	}

	//
	//Tal y como está este método es equivalente a 'leerFicheroAsincrono2'
	//(tratamiento de errores con excepciones)
	//
	public Future<String> leerFicheroAsincrono4(String fichero){
		
		//CompletableFuture.supplyAsync(Supplier, Executor);
		
		return CompletableFuture.supplyAsync(
			() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Path path = Paths.get(fichero);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return new String(contenido);
					//return Files.readString(path);
				} catch (IOException e) {
					//e.printStackTrace();
					throw new CompletionException(new Exception("El fichero no existe"));
				}
			});
	}	
	
	//
	//Handle
	//
	/*
	public Future<String> leerFicheroAsincrono5(String fichero){
		
		//CompletableFuture.supplyAsync(Supplier, Executor);
		
		return CompletableFuture.supplyAsync(
				() -> {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	
					
					Path path = Paths.get(fichero);
					byte[] contenido = Files.readAllBytes(path);
					return new String(contenido);
				})
				.handle( (resultado, throwable) -> {
					if(throwable != null) {
						//Podemos lanzar la excepción real
						//throw throwable;
						//O la que estimemos oportuna
						throw new Exception("Error al leer el fichero");
					}
					return resultado;
				});				
	}
	*/
	
	//
	//Síncrono
	//
	public String concatenarSincrono(String fichero1, String fichero2) throws IOException{
		Path path1 = Paths.get(fichero1);
		byte[] contenido1 = Files.readAllBytes(path1);
		Path path2 = Paths.get(fichero2);
		byte[] contenido2 = Files.readAllBytes(path1);
		//Mejor usar un StringBuilder... 
		return new String(contenido1)+new String(contenido2);
	}
	
	public Future<String> concatenar(String fichero1, String fichero2){

		//Leyendo los dos ficheros y concatenandolos en el mismo supplier
		//(El mismo hilo lee los dos ficheros)
		/*
		return CompletableFuture.supplyAsync(
				() -> {
					Path path1 = Paths.get(fichero1);
					Path path2 = Paths.get(fichero2);
					try {
						byte[] contenido1 = Files.readAllBytes(path1);
						byte[] contenido2 = Files.readAllBytes(path2);
						return new String(contenido1)+new String(contenido2);
						//Java 11:
						//return Files.readString(path1)+Files.readString(path2);
					} catch (IOException e) {
						e.printStackTrace();
						return null;
					}
				})
			.handle(
				(contenidoConcatenado, throwable) -> {
					if(contenidoConcatenado!=null) {
						return contenidoConcatenado;
				} else {
						return "ERROR AL CONCATENAR";
					}
				});
		*/

		//Podemos concatenar la ejecución de varios callables con 'thenApply'
		//Cada callable recibe por parámetro el sesultado creado por el anterior
		return CompletableFuture.supplyAsync(
			() -> {
				
				System.out.println("Bloque 1:"+Thread.currentThread().getId());
				
				Path path = Paths.get(fichero1);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return new String(contenido);					
					//return Files.readString(path);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					return null;
				}
			})
		.thenApply(
			(contenidoFichero1) -> {
				System.out.println("Bloque 2:"+Thread.currentThread().getId());
				Path path = Paths.get(fichero2);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return contenidoFichero1 + new String(contenido);
					//return contenidoFichero1 + Files.readString(path);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					return null;
				}
			})
		.handle(
			(contenidoConcatenado, throwable) -> {
				System.out.println("JANDLE:"+Thread.currentThread().getId());
				if(contenidoConcatenado!=null) {
					return contenidoConcatenado;
				} else {
					return "ERROR AL CONCATENAR";
				}
			});

	}
	
	//Controlando errores con excepciones
	public Future<String> concatenar2(String fichero1, String fichero2){

		String txt = new String();
		
		return CompletableFuture.supplyAsync(
			() -> {
				Path path = Paths.get(fichero1);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return new String(contenido);							
					//return Files.readString(path);
				} catch (IOException e) {
					throw new CompletionException(e);
				}
			})
		.thenApply(
			(contenidoFichero1) -> {
				Path path = Paths.get(fichero2);
				try {
					byte[] contenido = Files.readAllBytes(path);
					return contenidoFichero1 + new String(contenido);					
					//return contenidoFichero1 + Files.readString(path);
				} catch (IOException e) {
					throw new CompletionException(e);
				}
			});
	}

}







