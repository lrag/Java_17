import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

import javax.swing.JButton;

public class PruebasLambdas {
	
	private static void insertar() {
		//Método de palo
		System.out.println("Method of stick");
	}	

	public static void main(String[] args) {
				
		JButton boton = new JButton("Dale");
		
		//OyenteBotonDale oyente = new OyenteBotonDale();
		//ActionListener oyente = new OyenteBotonDale();
		//boton.addActionListener(oyente);
		//boton.addActionListener(new OyenteBotonDale());
		
		
		
		//Definiendo el oyente con una clase interna anónima
		//Una clase interna anónima es
		//-una clase definida dentro otra clase y que no tiene nombre
		//-Con constructor sin parámetros
		//-inaccesible desde el resto de la aplicación
		//-se programan heredando de una clase o implementando una interfaz
		//-en un único movimiento definimos la clase y creamos el objeto		
		
		ActionListener oyente1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón Dale pulsado");
			}
		};	
		boton.addActionListener(oyente1);
		
		//Igual, pero sin usar una variable intermedia	
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón Dale pulsado");
			}
		});		
		
		//
		//Lo mismo con expresiones lambda
		//	
		
		JButton boton3 = new JButton();
		ActionListener oyenteBotonInsertar = e -> insertar();
		boton3.addActionListener(oyenteBotonInsertar);
			
		//Mejor todavía (sin variable):
		boton3.addActionListener( e -> insertar() );		
		
		
		////////////////////////////////////////
		// SINTAXIS DE LAS EXPRESIONES LAMBDA //
		////////////////////////////////////////
		
		//-Solo pueden utilizarse con interfaces
		//-Que además tengan únicamente un método -> interfaces funcionales
		//		
		
		//interface Reloj{
		//	public void decirHora();
		//}			
		System.out.println("========================");
		Reloj r1 = new Reloj() {
			public void decirHora() {
				System.out.println(new Date());
			}
		};
		r1.decirHora();		
	
		//
		//Cuando el método no recibe parámetros los parentesis son obligatorios
		//Cuando el metodo solo tiene una línea nos podemos ahorrar las llaves del método
		//
		Reloj relojDeCuco = () -> System.out.println("CUCÚ CUCÚ: "+new Date());
		relojDeCuco.decirHora();		
		
		//interface Saludador{
		//	public void saludar(String nombre);
		//}
		System.out.println("========================");
		Saludador s1 = new Saludador() {
			public void saludar(String nombre) {
				System.out.println("Hola "+nombre);
			}
		};		
		s1.saludar("Luis Ramón");		
		
		//
		//Podemos ahorrarnos el tipo de los parámetros
		//Cuando el método recibe un único parámetro y no se indica el tipo se pueden quitar los parentesis
		//		
		Saludador s2 = nombre -> System.out.println("Hola Radiola "+nombre);
		s2.saludar("Luis Ramón");
		
		
		
		//interface Calculador{
		//	public void calcular(Double n1, Double n2);
		//}		
		System.out.println("========================");
		Calculador c1 = new Calculador() {
			public void calcular(Double n1, Double n2) {
				System.out.println(n1+n2);
			}
		};
		c1.calcular(25d, 500d);		

		//
		//Cuando se recibe más de un parámetro los parentesis son obligatorios
		//		
		Calculador c2 = (n1, n2) -> System.out.println(n1+n2);
		c2.calcular(25d, 500d);			
		

		//interface Formateador{
		//	public String formatear(String dato1, String dato2);
		//}
		
		System.out.println("========================");
		Formateador f1 = new Formateador() {
			public String formatear(String dato1, String dato2) {
				return dato1+"+"+dato2;
			}
		};		
		System.out.println(f1.formatear("aaa", "bbb"));		
		
		//
		//Cuando quitamos las llaves del método el compilador añade un return IMPLÍCITO
		//		
		Formateador f2 = (dato1, dato2) -> dato1+":"+dato2;
		System.out.println(f2.formatear("aaa", "bbb"));		
		
			
		//
		//¿Son closures las expresiones lambda de java?
		//
		//Solo pueden utilizar variables declaradas fuera de ellas si son finales o 'efectivamente finales'
		//
		int m1=25;	
		Consumer<Integer> multiplicador = m2 -> {
			//m1++;
			System.out.println(m1*m2);
		};		
		//m1++;
		
		multiplicador.accept(10);
		multiplicador.accept(20);			
		
		//
		//Interfaces funcionales en el api de Java8
		//
		//consumer   : public void accept(T t)
		//biconsumer : public void accept(T t, J j)
		//function   : public Tipo1 apply(Tipo2 t)
		//biFunction : public Tipo1 apply(Tipo2 t1, Tipo3 t2)
		//predicate  : public boolean test(T t)
		//supplier   : public T get()
		//	
		//toDoubleFunction: public double applyAsDouble(Tipo t)
		//toIntFunction   : public int applyAsInt(Tipo t)
		//
		System.out.println("===========================================");
		//consumer: public void accept(T t)
		//biconsumer: public void accept(T t, J j)
		Consumer<String> c = txt -> System.out.println("Consumer:"+txt);
		c.accept("Descanso!");	
		
		//predicate: public boolean test(T t)
		Predicate<String> filtro = txt -> txt.length()>10;
		
		boolean rs1 = filtro.test("HOLA");
		boolean rs2 = filtro.test("HOLA CARACOLA");
		System.out.println(rs1+","+rs2);

		//function
		//public Tipo1 apply(Tipo2 t)
		Function<String, String> transformacion = txt -> txt.toUpperCase();
		String txt = transformacion.apply("abcdefg");
		System.out.println(txt);
				
		//supplier
		//public T get()
		Supplier<Double> suplier = () -> Math.random();
		Double n = suplier.get();
		System.out.println(n);			
				
	}
	
}

/*
class OyenteBotonDale implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botón Dale pulsado");
	}
}
*/


/////////////////////////////////////////////////
//Interfaces funcionales: solo tienen un método//
/////////////////////////////////////////////////
//
//La anotación @FunctionalInterface indica al compilador que debe comprobar que efectivamente se trata
//de una interfaz con un único método
//

@FunctionalInterface
interface Reloj{
	void decirHora();
	//void decirHora2();
}

//Consumer
@FunctionalInterface
interface Saludador{
	public void saludar(String nombre);
}

//BiConsumer
interface Calculador{
	public void calcular(Double n1, Double n2);
}

//Function
interface Formateador{
	public String formatear(String dato1, String dato2);
}


class OyenteBotonDale implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botón DALE pulsado...");
	
	}
	
}





