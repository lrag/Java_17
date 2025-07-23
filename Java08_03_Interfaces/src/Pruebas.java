import com.curso.dos.ClaseQueImplementaDosInterfacesQueDefinenElMismoMetodo;
import com.curso.dos.InterfazA;
import com.curso.dos.InterfazB;
import com.curso.uno.Clase1;
import com.curso.uno.Implementacion1;
import com.curso.uno.Implementacion2;
import com.curso.uno.Interfaz;


public class Pruebas {

	public static void main(String[] args) {
		
		Implementacion1 i1 = new Implementacion1();
		Implementacion2 i2 = new Implementacion2();
		
		//Metodos 'normales' y default
		i1.metodo();
		i1.saludar("Luis Ramón");
		
		i2.metodo();
		i2.saludar("Luis Ramón");
		
		System.exit(42);
		
		
		//Métodos estáticos
		Clase1 c1 = new Clase1();
		//Esto está mal, pero se puede hacer
		c1.metodoEstatico();
		//Lo correcto es utilizar la clase
		Clase1.metodoEstatico();
		
		
		//No podemos acceder a los métodos estáticos definidos en la interfaz utilizando una variable
		//del tipo que la implementa
		//i1.metodoEstatico();

		
		//Tenemos que utilizar la interfaz para ello
		Interfaz.metodoEstatico();
		
		//Tampoco nos dejan aunque utilizemos una variable del tipo 'Interfaz'
		Interfaz interfaz = null;
		//interfaz.metodoEstatico(); No compila
		//interfaz.metodo(); //NullPointerEx
		//interfaz.saludar();
		
		
		ClaseQueImplementaDosInterfacesQueDefinenElMismoMetodo x = new ClaseQueImplementaDosInterfacesQueDefinenElMismoMetodo();
		x.metodo();
		//x.metodoEstatico();
		InterfazA.metodoEstatico();
		InterfazB.metodoEstatico();
		
		
	}
	
}











