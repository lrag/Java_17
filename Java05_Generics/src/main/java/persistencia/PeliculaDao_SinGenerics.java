package persistencia;


import java.util.List;

import modelo.Pelicula;

public class PeliculaDao_SinGenerics {
	
	public void insertar(Pelicula obj){
		//Codigo insert
		
		//NO SE PUEDEN UTILIZAR VARIABLES GENÉRICAS. SOLO DECLARARLAS!
		Pelicula variable1 = null; 
		//T variable2 = new T(); //NOOOOOO! ¿y si no se pueden crear objetos?
		variable1.toString(); //Los métodos de object nada mas
		
	}	
	
	public void modificar(Pelicula obj){
		//Codigo update
	}
	
	public void borrar(Pelicula obj){
		//Codido delete
	}
	
	public Pelicula buscar(Integer id){
		//Código select
		return null;
	}
	
	public List<Pelicula> listarTodos(){
		//Codigo select
		return null;
	}	
	
}

