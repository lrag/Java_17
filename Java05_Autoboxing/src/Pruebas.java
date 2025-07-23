import java.util.ArrayList;
import java.util.List;


public class Pruebas {

	public static void main(String[] args) {
		
		/*
		int n = 5;
		
		Integer n2 = new Integer(5);
		Integer n3 = new Integer(10);
		
		Integer n4 = new Integer(n2.intValue()+n3.intValue());
		*/
		
		Integer i1 = 500; //Autoboxing: new Integer(500);
		Long l1 = 1111l;
		 
		int i2 = i1; //Autounboxing: = i1.intValue();
		
		Integer i3 = 1000; //Autoboxing
		Integer i4 = i1 + i3; //Mixto
		
		Integer i5 = 128;
		Integer i6 = 128;
		
		Integer i7 = new Integer(127);
		Integer i8 = new Integer(127);

		System.out.println(i5 == i6); //true
		System.out.println(i7 == i8); //false

		
		System.exit(0);
		
		
		/*
		String txt1 = "hola";
		String txt2 = "hola";
		String txt3 = new String("hola");
		String txt4 = new String("hola");
		System.out.println(txt1 == txt2); //
		System.out.println(txt3 == txt4); //
		txt1 = txt1.toUpperCase();
		System.out.println(txt1);
		*/
		
	
		
	}	
	
}










