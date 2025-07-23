import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparadores {

	public static void main(String[] args) {
		
		Factura f1 = new Factura(200d,5,1000l);
		Factura f2 = new Factura(300d,2,2000l);
		Factura f3 = new Factura(150d,20,1500l);
		
		System.out.println(f1.compareTo(f2));
		System.out.println(f2.compareTo(f1));
		
		List<Factura> facturitas = new ArrayList<>();
		facturitas.add(f1);
		facturitas.add(f2);
		facturitas.add(f3);
		
		facturitas.sort(null);
		System.out.println(facturitas);
		
		facturitas.sort(new ComparadorFacturasFechaAscendente());
		System.out.println(facturitas);
		
		facturitas.sort( (fac1, fac2) -> fac1.getNumeroProductos()-fac2.getNumeroProductos() );
		System.out.println(facturitas);
		
	}	
	
}

//Cuando una clase implementa Comparable estamos definiendo en ella el orden 'natural' de los objetos de esa clase
class Factura implements Comparable<Factura> {
	
	private double total;
	private int numeroProductos;
	private long fecha;
	
	public Factura(double total, int numeroProductos, long fecha) {
		super();
		this.total = total;
		this.numeroProductos = numeroProductos;
		this.fecha = fecha;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getNumeroProductos() {
		return numeroProductos;
	}

	public void setNumeroProductos(int numeroProductos) {
		this.numeroProductos = numeroProductos;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	@Override
	public int compareTo(Factura otraFactura) {
		//Las facturas se ordenan por total ascendente
		return (int) Math.round(total-otraFactura.total);
	}

	@Override
	public String toString() {
		return "Factura [total=" + total + ", numeroProductos=" + numeroProductos + ", fecha=" + fecha + "]";
	}
	
}

class ComparadorFacturasFechaAscendente implements Comparator<Factura> {

	@Override
	public int compare(Factura f1, Factura f2) {
		//Compara las facturas por la fecha ascendente
		return Long.valueOf(f1.getFecha()-f2.getFecha()).intValue();
	}
	
}


