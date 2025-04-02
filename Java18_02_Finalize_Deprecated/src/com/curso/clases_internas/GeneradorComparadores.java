package com.curso.clases_internas;

import java.util.Comparator;

public class GeneradorComparadores {
	
	//static?
	public /*static*/ Comparator<Integer> crearComparador(Integer valorCorrector) {
		
		//'c' tendrá una referencia a la instancia de 'GeneradorComparadores'!
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Comparator<Integer> c = new Comparator() {
			@Override
			public int compare(Object v1, Object v2) {
				Integer i1 = (Integer) v1;
				Integer i2 = (Integer) v2;
				return i1 - i2 - valorCorrector;
			}
		};
		return c;
		
		/*
		//Con las expresiones lambda pasa lo mismo aunque hay una diferencia
		return (i1, i2) -> {
			//¿Y si no se utiliza ningún componente de la clase nido?
			return i1 - i2 - valorCorrector;			
		};
		*/	
		
	}
	
}



class X implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}









