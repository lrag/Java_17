
public class Pruebas {

	public static void main(String[] args) {
		
		System.out.println(sumar(1, 2));
		System.out.println(sumar(1, 2, 3));
		System.out.println(sumar(1, 2, 3, 4));
		
		int[] numeros = { 1,2,3,4,5,6,7,8,9};
		System.out.println(sumar(numeros));
		
		//La llamada es mucho más sencilla
		sumar_bis(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
		
	}
	
	public static int sumar(int s1, int s2) {
		return s1+s2;
	}

	public static int sumar(int s1, int s2, int s3) {
		return s1+s2+s3;
	}
	
	public static int sumar(int s1, int s2, int s3, int s4) {
		return s1+s2+s3+s4;
	}
	
	//
	//Podemos recibir un array:
	//
	public static int sumar(int[] sumandos) {
		int total = 0;
		for(int sumando: sumandos) {
			total = total + sumando;
		}
		return total;
	}
	
	//
	//Mejor con parametros variables:
	//
	//-Solo puede haber un parámetro variable
	//-Debe ser el último parámetro
	//
	public static int sumar_bis(int...sumandos) {
		//Sumandos es un array
		int total = 0;
		for(int sumando: sumandos) {
			total = total + sumando;
		}
		return total;		
	}
	
}
