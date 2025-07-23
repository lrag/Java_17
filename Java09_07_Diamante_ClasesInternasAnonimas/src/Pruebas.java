import java.util.ArrayList;
import java.util.List;

public class Pruebas {

	public static void main(String[] args) {
		
		List<String> palabras = new ArrayList<>();
		
		//Hasta Java 8
		EjemploInterfaz<String> ei1 = new EjemploInterfaz<String>() {
			@Override
			public void metodo(String obj) {
				System.out.println(obj);
			}
		};
		
		//Desde Java 9 podemos utilizar el operador diamante en clases internas anónimas
		EjemploInterfaz<String> ei2 = new EjemploInterfaz<>() {
			@Override
			public void metodo(String obj) {
				System.out.println(obj);
			}
		};
		
		ei1.metodo("Hola");
		ei2.metodo("mundo");				
	}
	
}

interface EjemploInterfaz<T>{
	void metodo(T obj);
}