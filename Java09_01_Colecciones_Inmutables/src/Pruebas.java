import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.curso.modelo.Disco;

public class Pruebas {

	public static void main(String[] args) {
		
		//              //
		// Hasta Java 8 //
		//              //
		List<String> palabras = new ArrayList<String>();
		palabras.add("txt1");
		palabras.add("txt2");
		palabras.add("txt3");
		palabras.add("txt4");
		palabras.add("txt5");
		List<String> palabrasInmutable = Collections.unmodifiableList(palabras);	

		//
		//Cuidado que los métodos para modificar la colección existen, pero lanzan una runtime exception
		//palabrasInmutable.add("ZASCA");
		//
		
		System.out.println("==================================");
		Set<Disco> discos = new HashSet<Disco>();
		discos.add(new Disco("Dark side of the moon"));
		discos.add(new Disco("Machine head"));
		discos.add(new Disco("Back in black"));
		Set<Disco> discosInmutable = Collections.unmodifiableSet(discos);
		discosInmutable.forEach( d -> d.setTitulo(d.getTitulo().toUpperCase()));
		discosInmutable.forEach( d -> System.out.println(d));
		
		//Si modificamos el set original...
		System.out.println("==================================");
		discos.add(new Disco("Dark side of the moon"));
		discos.add(new Disco("Machine head"));
		discos.add(new Disco("Back in black"));
		//Tan inmutable no era...
		discosInmutable.forEach( d -> System.out.println(d));
		
		System.exit(0);
		
		//        //
		// Java 9 //
		//        //
		
		//Ya no hay manera de modificar estas colecciones
		System.out.println("==================================");
		
		List<Disco> discosInmutable2 = List.of(
			new Disco("Thick as a brick"), 
			new Disco("Five miles out"), 
			new Disco("Misplaced Childhood")
		);
		discosInmutable2.forEach( d -> System.out.println(d));
		
		Set<String> setInmutble = Set.of("uno","dos","tres","cuatro","cinco");
	
	}	
	
}
