
public class Pruebas {

	public static void main(String[] args) {
		
		//Hasta Java 8
		EjemploInterfaz<String> ei1 = new EjemploInterfaz<String>() {
			@Override
			public void metodo(String obj) {
				System.out.println(obj);
			}
		};

		//Desde Java 9 podemos utilizar el operador diamante en clases internas an�nimas
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