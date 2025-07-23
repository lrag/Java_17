import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Pruebas {

	public static void main(String[] args) {
		
		/*
		ArrayList lista = new ArrayList();
		
		lista.add("HOLA");
		lista.add(new Integer(50));
		lista.add(33); //Autoboxing
		lista.add(new Scanner(System.in));
		
		ArrayList palabras = new ArrayList();
		palabras.add("BO");
		palabras.add("QUE");
		palabras.add("PASA");
		
		//Aunque sepamos que solo hay strings, debemos hacer el cast
		String txt = (String) palabras.get(0);
		
		//Lo peor: podemos añadir cualquier otra cosa a nuestra lista de palabras
		//Es un problema en potencia
		palabras.add(50);
		*/
		
		ArrayListChungoConGenerics<String> palabras2 = new ArrayListChungoConGenerics<String>();
		palabras2.add("DOLOR DE ESPALDA");
		//palabras2.add(100); //Error!! Solo admite Strings
		
		String txt2 = palabras2.get(0); //No es necesario el cast.
		
		
		GrabadorDeDatos<FileWriter> gdd = new GrabadorDeDatos<FileWriter>();
		//GrabadorDeDatos<Scanner> gdd2 = new GrabadorDeDatos<Scanner>();
		
		
		//METODOS GENERICOS
		Veterinario<Perro> v = new Veterinario<Perro>();
		Perro p = new Perro();
		Gato g = new Gato();
		v.tratarAnimal(p);
		
		List<Perro> jauria2 = new ArrayList<Perro>();
		Set<Perro> jauria3 = new HashSet<Perro>();
		
		List<Gato> gatos = new ArrayList<Gato>();
		List<Pajaro> pajaros = new ArrayList<Pajaro>();
		
		v.curarAnimales(jauria2);
		
		v.examinarAnimales(gatos);
		v.examinarAnimales(pajaros);
		v.examinarAnimales(jauria2);
		v.examinarAnimales(jauria3);

		//v.examinarAnimales2(gatos);
		v.examinarAnimales2(jauria2);
		
	}
	
}





