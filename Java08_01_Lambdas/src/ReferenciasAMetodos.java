import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReferenciasAMetodos {

	public static void main(String[] args) {
		ReferenciasAMetodos ram = new ReferenciasAMetodos();
		ram.pruebas();
	}
	
	public void imprimir(String txt) {
		System.out.println(">>>>>"+txt);
	}
	
	public void imprimirCiudad(Integer id, String ciudad) {
		System.out.println("Id: "+id+", Ciudad: "+ciudad);
	}
	
	public void pruebas() {
		
		//Referencias a métodos estáticos
		System.out.println("=================================================");
		List<Integer> lista = List.of(1,2,3,4,5,6,7,8,9,10); //Desde Java9
		lista.forEach( e -> System.out.println(e) );
		lista.forEach( System.out::println );
		
		//Referencia al método de un objeto concreto
		System.out.println("=================================================");
		ClienteDao clienteDao = new ClienteDao();
		List<String> clientes = List.of("c1","c2","c3");

		clientes.forEach( c -> clienteDao.insertar(c));
		clientes.forEach( clienteDao::insertar );
		
		//En este 'epígrafe' incluimos llamadas a this
		clientes.forEach(c -> this.imprimir(c));
		clientes.forEach(this::imprimir);
		
		//Ejemplo con dos parámetros
		Map<Integer, String> mapa = new HashMap<>();
		mapa.put(1, "Madrid");
		mapa.put(2, "Salamanca");
		mapa.put(3, "Alicante");
		
		mapa.forEach( (k, v) -> System.out.println(k+":"+v));
		//mapa.forEach( System.out::println ); No compila porque 'println' no admite dos parámetros
		mapa.forEach( this::imprimirCiudad );
				
		//Referencia al método de un objeto cualquiera
		System.out.println("=================================================");
		List<Factura> facturas = List.of(new Factura(List.of("P1","P2"),100d), new Factura(List.of("P3","P4"),200d));

		Optional<Factura> fOp = facturas
			.stream()
			//.reduce( (ac, f) -> ac.sumar(f) )
			.reduce(Factura::sumar);
		if(fOp.isPresent()) {
			System.out.println(fOp.get());
		}
		
	}
	
}

class Factura {
	List<String> productos;
	Double total;
	
	public Factura(List<String> productos, Double total) {
		super();
		this.productos = productos;
		this.total = total;
	}
	
	public Factura sumar(Factura otraFactura) {
		List<String> sumaProductos = new ArrayList<>();
		sumaProductos.addAll(productos);
		sumaProductos.addAll(otraFactura.productos);
		return new Factura(
				sumaProductos,
				total + otraFactura.total
			);				
	}

	@Override
	public String toString() {
		return "Factura [productos=" + productos + ", total=" + total + "]";
	}	
}

class ClienteDao {
	
	public String insertar(String cliente) {
		System.out.println("Insertando: "+cliente);
		return "YEPA!";
	}
	
}