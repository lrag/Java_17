import java.io.IOException;
import java.io.Writer;

//Se puede limitar las clases que pueden sustituir al hueco <T>
//Se utiliza extends siempre, aunque se trate de interfaces!
public class GrabadorDeDatos <T extends Writer>{

	public void grabar(T writer, Object[] datos){
		
		try {
			//T, como m�nimo, es un writer. Nos da sus m�todos.
			writer.write("HOLA");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	
}
