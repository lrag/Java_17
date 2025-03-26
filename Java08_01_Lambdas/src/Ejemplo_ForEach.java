import java.util.function.Consumer;

public class Ejemplo_ForEach {

	public static void main(String[] args) {
		
		ArrayListChungo<String> palabras = new ArrayListChungo<>();
		palabras.add("siete");
		palabras.add("caballos");
		palabras.add("vienen");
		palabras.add("de");
		palabras.add("Bonanza");
		
		System.out.println("=========================================");
		for(int a=0; a<palabras.size(); a++) {
			System.out.println(":::::"+palabras.get(a));
		}	
		for(int a=0; a<palabras.size(); a++) {
			System.out.println(">>>>>"+palabras.get(a));
		}
	 	
		System.out.println("=========================================");

		palabras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println("<<<<<"+s);
			}
		});
		
		palabras.forEach( s -> System.out.println("<<<<<"+s) );
		palabras.forEach( t -> System.out.println(":::::"+t) );
		palabras.forEach( t -> System.out.println(">>>>>"+t) );
		
	}
	
}


class ArrayListChungo<T> {
	
	private Object[] elementos = new Object[20];
	private int contador;
	
	public void add(T elem) {
		elementos[contador] = elem;
		contador++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int pos) {
		return (T) elementos[pos];
	}
	
	public int size() {
		return contador;
	}	
	
	//Esta es una 'función de orden superior' porque recibe por parámetro otra función
	//Tambien lo son las funciones que devuelven funciones
	public void forEach(Consumer<T> consumer) {
		for(int a=0; a<contador; a++) {
			T elemento = (T) elementos[a]; 
			consumer.accept(elemento);
		}
	}
		
}
