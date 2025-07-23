import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Veterinario<T extends Animal> {
	
	//Con polimorfismo, este metodo recibe cualquier animal
	//y no es necesario generics
	//public void tratarAnimal(Animal a){
	//	System.out.println(a.getClass());
	//}
	
	//Pero la idea es que quiero un veterinario especializado
	//en perros, otro en gatos...
	public void tratarAnimal(T a){
		System.out.println(a.getClass());
	}	
	
	//Un veterinario especializado, admite cualquier coleccion de animales
	//de su especialidad para curarlos
	public void curarAnimales(Collection<T> animales){
		
	}
	
	//METODOS GENÉRICOS:

	//Un veterinario especializado podrá tambien examinar colecciones de otros bichejos
	//Ponemos como limitacion que las colecciones son todas del mismo tipo de animal
	//Lo solucionamos haciendo el metodo generico y que en el momento de llamar sea cuando se
	//escoja de que tipo es la collection
	//public void examinarAnimales(Collection<Perro> animales){
	public void examinarAnimales(Collection<? extends Animal> animales){
		//Atiza!
		//Puedo acceder sin nigun problema a la lista
		for(Animal a: animales){
			System.out.println(a);
		}
		
		//Pero NO puedo modificarla. Si me llaman con una lista de gatos, no va a dejar
		//insertar un perro. Hay que recordar que esto se decide en TIEMPO DE EJECUCION
		//animales.add(new Perro());
		//animales.add(new Gato());
		//animales.add(new Animal());		
	}
	
	//Similar al anterior
	public void examinarAnimales2(Collection<? super Perro> animales){
		
		//animales.add(new Gato());
		//animales.add(new Animal());
		animales.add(new Perro());
		animales.add(new PerroPolicia());
		animales.add(new PerritoPiloto());

		
	}
	

	
	
	
}
