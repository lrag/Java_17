import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.curso.modelo.entidad.Persona;

public class Pruebas {

	public static void main(String[] args) {
		
		//Eval
		System.out.println("============================================");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			String js = "var txt='JS en la JVM!'; print(txt)";
			engine.eval(js);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		
		
		//Desde un fichero
		System.out.println("============================================");
		try {
			engine.eval(new FileReader("script.js"));
		} catch (ScriptException | FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		//Invocar funciones JS desde Java
		System.out.println("============================================");
		try {
			engine.eval(new FileReader("funciones.js"));
		} catch (ScriptException | FileNotFoundException e) {
			e.printStackTrace();
		} 	

		Invocable invocable = (Invocable) engine;
		
		try {
			Double calculo = (Double) invocable.invokeFunction("calcular", 300, 200);
			System.out.println("Cálculo:"+calculo);
		
			String formato = (String) invocable.invokeFunction("formatear", "uno", "dos");
			System.out.println("Formato:"+formato);
			
			Persona p1 = new Persona("bender b rodriguez", "NNY", "555");
			Persona p2 = (Persona) invocable.invokeFunction("funcion", p1);
			//p1 y p2 referencian al mismo objeto:
			System.out.println(p1==p2);
			System.out.println(p1.getNombre());
			System.out.println(p2.getNombre());

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}

		//Arrays tipados
		System.out.println("======================================");
		try {
			engine.eval(new FileReader("arraysTipados.js"));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
		
		//invocable = (Invocable) engine;
		try {
			Persona[] personas = (Persona[]) invocable.invokeFunction("crearPersonas");
			for(Persona p : personas){
				System.out.println(p);
			}
		
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}

		//Colecciones
		System.out.println("======================================");
		try {
			engine.eval(new FileReader("colecciones.js"));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
		
		//invocable = (Invocable) engine;
		try {
			@SuppressWarnings("unchecked")
			List<Persona> personas = 
				(List<Persona>) invocable.invokeFunction("crearPersonasArrayList");
			personas.forEach( p -> System.out.println(p));
			
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}

		//Streams
		System.out.println("======================================");
		try {
			engine.eval(new FileReader("streams.js"));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
		
		//Ficheros
		System.out.println("======================================");
		try {
			engine.eval(new FileReader("ficheros.js"));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}

		//invocable = (Invocable) engine;
		try {
			invocable.invokeFunction("escribir");
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}		

	}

}









