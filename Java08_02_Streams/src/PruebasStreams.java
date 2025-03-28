import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.FacturaDTO;
import com.curso.modelo.entidad.Persona;


public class PruebasStreams {

	private static int n;
	
	public static void main(String[] args) {
		PruebasStreams m = new PruebasStreams();
		m.movidas();
	}

	public int comparar(Factura f1, Factura f2 ) {
		return f1.getTotal().intValue() - f2.getTotal().intValue();
	}
	
	public void movidas() {
		
		Cliente c1 = new Cliente(1,"C1","D1","T1");
		Cliente c2 = new Cliente(2,"C2","D2","T2");
		Cliente c3 = new Cliente(3,"C3","D3","T3");
		
		List<Cliente> clientes = Arrays.asList(c1, c2, c3); //Entrega una coleccion inmutable
		//clientes.add(c1);
		//clientes.add(c2);
		//clientes.add(c3);			
		
		List<Factura> facturas = new LinkedList<>();
		Factura f1 = new Factura(1,"FAC-1",c1,100D);
		Factura f2 = new Factura(2,"FAC-2",c2,200D);
		Factura f3 = new Factura(3,"FAC-3",c3,300D);
		facturas.add(f1);
		facturas.add(f2);
		facturas.add(f3);
		facturas.add(new Factura(4,"FAC-4",c1,125D));
		facturas.add(new Factura(5,"FAC-5",c2,200D));
		facturas.add(new Factura(6,"FAC-6",c3,275D));
		facturas.add(new Factura(7,"FAC-7",c1,150D));
		facturas.add(new Factura(8,"FAC-8",c2,200D));
		facturas.add(new Factura(9,"FAC-9",c3,250D));	

		
		//Recorriendo una coleccion
		System.out.println("====================================================");
		//Con un for de toda la vida (solo si es list y con mucho cuidado)
		for(int a=0; a<facturas.size(); a++){
			System.out.println(facturas.get(a));
		}		
		
		//Con un iterador de toda la vida
		Iterator<Factura> iterador = facturas.iterator();
		//while(iterador.hasNext()) {
			//System.out.println(iterador.next());
		//}
		
		//Java 5: forEach, que utiliza un iterador
		for( Factura f: facturas ){
			//System.out.println(f);			
		}	
		
		//Java 8: nuevo método en la interfaz collection para recorrer colecciones (tambien lo tienen los mapas).
		//Recibe un Consumer por parámetro:
		facturas.forEach( e -> System.out.println(e) );

		///////////
		//STREAMS//
		///////////
		System.out.println("====================================================");
		
		Stream<Factura> s1 = facturas.stream();
		long n = s1.count();
		System.out.println("Nº fra: "+n);
		
		//Los streams solo pueden utilizarse una vez:
		//long n2 = s1.count();
		
		//Debemos crear un nuevo stream
		Stream<Factura> s2 = facturas.stream();
		System.out.println(s2.count());			
		
		//
		//Stream.forEach(Consumer consumer). Recibe un consumer
		//
		System.out.println("====================================================");		
		facturas
			.stream() //De aqui van saliendo las facturas de una en una
			.forEach( f -> System.out.println(f) ); //Para este viaje habíamos hecho directamente facturas.forEach(...)
		
		//
		//Stream.of : No siempre tenemos una colección a la que pedirle un stream o nos da pereza hacerla
		//
		
		/*Aqui creamos primero una colección y luego a la colección le pedimos un stream
		List<Cliente> ccc = new ArrayList();
		ccc.add(c1);
		ccc.add(c2);
		ccc.add(c3);
		ccc.stream();*/
		
		//Con stream of podemos ahorrarnos el crear la colección
		Stream<Cliente> stream = Stream.of(c1, c2, c3);
		
		//
		//Stream.filter(Predicate predicate). recibe un predicate
		//predicate: public boolean test(T t)
		//		
		//Imperativo:
		for(Factura f: facturas) {
			if(f.getTotal()<=200) {
				continue;
			}
			System.out.println(f);
		}
		
		System.out.println("====================================================");
		//Declarativo 
		facturas
			.stream()
			.filter(f -> f.getTotal() > 200)
			.forEach(System.out::println);
		
		
		
		//Concatenando filtros
		System.out.println("====================================================");
		int id = 2;
		facturas
			.stream()
			.filter( f -> f.getTotal()>=200 )
			.filter( f -> f.getCliente().getId() == id )
			.forEach( f -> System.out.println(f) );			
		
		//cada objeto que sale del stream recorre toda la cadena antes
		//de que salga el siguiente
		System.out.println("====================================================");
		facturas
			.stream()
			.filter( fra -> { 
				System.out.println("1:"+fra);
				return fra.getTotal()>130;
			})
			.filter( fra -> {
				System.out.println("2:"+fra);
				return fra.getCliente().getId()==id;
			})
			.forEach( fra -> System.out.println("3:"+fra));
		
		//
		//Iterator: devuelve un iterador
		//Lo utilizamos para controlar nosotros el ritmo con el que los objetos salen del stream
		System.out.println("====================================================");
		Iterator<Factura> it = 
			facturas
				.stream()
				.filter( fra -> { 
					System.out.println("1:"+fra);
					return fra.getTotal()>130;
				})
				//Si pedimos un iterador no podemos colocar algo 'al final' del strem
				//.forEach(f -> System.out.println(f))
				.iterator();		
		
		//Cada vez que invoquemos 'it.next()' un nuevo elemento saldrá del stream
		while(it.hasNext()){
			System.out.println("2:"+it.next());
		}		

		//
		//Stream.allMatch(Predicate predicate) : boolean - comprueba si todos los elementos cumplen un predicado
		//Stream.anyMatch(Predicate predicate) : boolean - comprueba si algún elemento cumple un predicado
		//
		System.out.println("=======================================");		
		boolean ok1 =  
			facturas
				.stream()
				.allMatch( fra -> fra.getTotal()>200 );
		System.out.println("Todas las facturas >200€ :"+ok1);
	
		boolean ok2 =  
			facturas
				.stream()
				.anyMatch( fra -> fra.getTotal()>200 );
		System.out.println("Alguna de las facturas >200€: "+ok2);	

		//
		//Máximo/mínimo con un comparador. Devuelve opcional
		//
		System.out.println("=======================================");			
		Comparator<Factura> cf1 = new Comparator<Factura>() {
			public int compare(Factura f1, Factura f2) {
				return f1.getTotal().intValue() - f2.getTotal().intValue();
			}
		};
		
		Comparator<Factura> cf2 = (ff1, ff2) -> ff1.getTotal().intValue() - ff2.getTotal().intValue();
		
		//MAX
		Optional<Factura> fMax = 
			facturas
				.stream()
				//.max(cf2);
				.max((fff1, fff2) -> fff1.getTotal().intValue() - fff2.getTotal().intValue());		
				//.max( this::comparar );
				//.max(cf2::compare);
		if( fMax.isPresent() ){
			System.out.println("Factura máxima:"+ fMax.get().getCodigo() );
		}		
		
		//MIN
		Optional<Factura> fMin = 
			facturas
				.stream()
				.min(cf2);
		if(fMin.isPresent()){
			System.out.println("FMin:"+fMin.get().getCodigo());
		}	
		
		//
		//Distinct
		//
		System.out.println("=======================================");		
		List<Factura> facturas2 = new ArrayList<>();
		facturas2.add(f1);
		facturas2.add(f2);
		facturas2.add(f3);
		facturas2.add(f1);
		facturas2.add(f2);
		facturas2.add(f3);

		facturas2
			.stream()
			.distinct() //usa el equals
			.forEach( fra -> System.out.println(fra));		

		//
		//Skip(int): Se salta cierto número de elementos del stream
		//
		System.out.println("=======================================");		
		facturas
			.stream()
			.filter(f -> f.getTotal()>=175)
			.skip(3) //Skip se puede colocar a cualquer altura del stream
			.forEach(fra -> System.out.println(fra));		
		
		//
		//Stream.map(Function funcion): Para obtener un stream de objetos distintos a los originales
		//
		System.out.println("=======================================");			
		
		ServicioComunicaciones sc = new ServicioComunicaciones();
		//IMPERATIVO	
		/*
		List<Cliente> clientes2 = new ArrayList<>();
		for(Factura f: facturas) {
			Cliente c = f.getCliente();
			if(!clientes2.contains(c)) {
				clientes2.add(c);
			}
		}
		for(Cliente c: clientes2) {			
			sc.enviarCorreoE(c.getNombre(), "OLA KE TAL");
		}
		*/	
		
		//DECLARATIVO, FUNCIONAL
		facturas
			.stream() //de aqui salen facturitas riquitas
			.map(fra -> fra.getCliente()) //a partir de aqui tenemos un stream de clientes
			.distinct() //Este 'distinct' se aplica a los clientes
			.forEach( cli -> sc.enviarCorreoE(cli.getNombre(), "OLA KE TAL, GRAZIAS POR SU KONPRA") );				
		
		/*idem: (para comprobar que map devuelve Stream)
		Stream<Cliente> streamClientes = 
			facturas
				.stream()
				.map(fra -> fra.getCliente());
		streamClientes
			.distinct()
			.forEach(cli -> System.out.println(cli));
		*/
		
		System.out.println("=======================================");				
		List<String> palabras = new ArrayList<String>(){{ // XD
				this.add("uno");
				this.add("dos");
				this.add("tres");
				this.add("cuatro");
				this.add("cinco");
			}};
			
		//No hace falta que los tipos que se reciben y devuelven en el map sean diferentes: Este map recibe un objeto y devuelve otro del mismo tipo
		palabras
			.stream()
			.map( palabra -> palabra.toUpperCase())
			.forEach(palabraMyusculas -> System.out.println(palabraMyusculas));			
		
		//Usando map podemos tambien modificar objetos. 
		System.out.println("=======================================");				
		clientes
			.stream()
			.map( cli -> {
				cli.setDireccion("NUEVA DIRECCION");
				return cli;
			})
			.forEach(cli -> System.out.println(cli));		
	
		//
		System.out.println("=======================================");				
		facturas
			.stream()
			.map( fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
			.forEach( fDTO -> System.out.println(fDTO) );		
		
		//
		//collect: para agregar el resultado
		//		
		System.out.println("=======================================");				
		
		//Necesitamos los dtos del ejemplo anterior en una lista.
		//Sin colectores:
		List<FacturaDTO> facturasDTO = new ArrayList<>();
		facturas
			.stream()
			.map( fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
			.forEach( fDTO -> facturasDTO.add(fDTO) );
		
		//Mejor con collectors
		List<FacturaDTO> facturasDTO2 = 
			facturas
				.stream()
				.map( fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
				.collect(Collectors.toList());	
		System.out.println(facturasDTO2);	
		
		System.out.println("=======================================");				
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
		
		List<Integer> pares = 
			numeros
				.stream()
				.filter( num -> num%2==0 )
				.collect(Collectors.toList());
		
		List<Integer> impares = 
			numeros
				.stream()
				.filter( num -> num%2!=0 )
				.collect(Collectors.toList());		
		
		pares.forEach( num -> System.out.print(num+", "));
		System.out.println();
		impares.forEach( num -> System.out.print(num+", "));
		System.out.println();
		
		//Obteniendo un mapa con collectors.
		//El colector a mapa recibe dos funciones.
		System.out.println("=======================================");		
	
		Map<String, Factura> mapa = 
			facturas
				.stream()
				.collect( Collectors.toMap( f -> f.getCodigo(),
						                    f -> f ));
		
		//Hasta java 7
		//IMPERATIVO
		Set<String> claves = mapa.keySet();
		for( String k: claves){
			//System.out.println(k+":"+mapa.get(k));
		}
		
		//En Java 8 tenemos el metodo forEach en mapas
		//DECLARATIVO
		mapa.forEach((k, v) -> System.out.println(k+":"+v));	
		
		//
		//Agregando con sumatorio, media y SummaryStatistics
		//
		System.out.println("=======================================");				
		
		Double media =  
			facturas
				.stream()
				.collect(Collectors.averagingDouble( fra -> fra.getTotal() )); //Tambien existe averaging Int
		System.out.println("Media del importe de las facturas:"+media);
		
		Integer media2 =  
			numeros
				.stream()
				.collect(Collectors.summingInt( num -> num ) ); //también existe summingDouble
			System.out.println("Suma de los números:"+media2);		
			
		IntSummaryStatistics movida = 
			numeros
				.stream()
				.collect(Collectors.summarizingInt( num -> num ));
		System.out.println(movida);
		
		DoubleSummaryStatistics movida2 = 
			facturas
				.stream()
				.collect(Collectors.summarizingDouble( fra -> fra.getTotal() ));
		System.out.println(movida2);
		
		//
		//Recolector Join (agregación): obtenemos un string a partir del stream
		//
		String txt = 
			numeros
				.stream() //de aqui salen Integers
				.map( num -> num.toString() ) //de aqui salen estrines
				.collect(Collectors.joining(", "));
		System.out.println(txt);		
	
		String codigosFacturas = facturas
			.stream()
			.map( fra -> fra.getCodigo() )
			.collect(Collectors.joining(", ", "FACTURAS: ", "."));
		System.out.println(codigosFacturas);	
		
		//
		//Collectors 'group by' (agregación)
		//
		System.out.println("=======================================");				

		//Agrupando facturas por el cliente
		Map<Cliente, List<Factura>> rs = 
			facturas
				.stream()
				.collect( Collectors.groupingBy( fra -> fra.getCliente() ));		
		rs.forEach( (k, v) -> System.out.println( k+":"+v) );			
				
		//Agrupando facturas por el id del cliente
		Map<Integer, List<Factura>> rs2 = 
			facturas
				.stream()
				.collect( Collectors.groupingBy( fra -> fra.getCliente().getId() ));
		rs2.forEach( (k, v) -> System.out.println( k+":"+v) );
		
		//
		//Flat map
		//
		System.out.println("=======================================");				
		c1.getFacturas().add(new Factura("FAC-100"));
		c1.getFacturas().add(new Factura("FAC-101"));
		c2.getFacturas().add(new Factura("FAC-102"));
		c2.getFacturas().add(new Factura("FAC-103"));
		c2.getFacturas().add(new Factura("FAC-104"));
		c3.getFacturas().add(new Factura("FAC-105"));
		c3.getFacturas().add(new Factura("FAC-106"));
		c3.getFacturas().add(new Factura("FAC-107"));
		c3.getFacturas().add(new Factura("FAC-108"));
		List<Cliente> clientes2 = new ArrayList<>();
		clientes2.add(c1); 
		clientes2.add(c2);
		clientes2.add(c3);		
		
		//Queremos las facturas a partir de esa lista de clientes
		//Sin flat map: NO QUEREMOS UNA LISTA DE LISTAS!!!
		List<List<Factura>> facturitasRiquitas_MAL =
			clientes2
				.stream() //De aqui salen clientes
				.map( cli -> cli.getFacturas() ) //De aqui sale un stream de listas de facturas
				.collect(Collectors.toList()); //Aqui llegan listas de facturas
		
		List<Factura> facturitasRiquitas_MEJOR_PERO_MAL = new ArrayList<>();		
		clientes2
			.stream() //De aqui salen clientes
			.map( cli -> cli.getFacturas() ) //De aqui sale una lista de facturas
			.forEach( listaFacturas -> {
				for(Factura f: listaFacturas) {
					facturitasRiquitas_MEJOR_PERO_MAL.add(f);
				}
			});
				
		//
		//BIEN con flat map:
		//Flatmap: Recibe un objeto y devuelve un stream hecho a partir de una colección

		List<Factura> facturitas22 = 
				clientes2
					.stream() //un stream de clientes
					.flatMap( cli -> cli.getFacturas().stream() ) 
					.collect(Collectors.toList());		
		facturitas22.forEach( System.out::println );
		
		//
		//Reduce(BinaryOperator) : Resume una colección en un único valor que de algún modo la representa 
		//
		System.out.println("=======================================");
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"P1",10d,1d,40d));
		personas.add(new Persona(2,"P2",20d,1.2,50d));
		personas.add(new Persona(3,"P3",30d,1.4,60d));
		personas.add(new Persona(4,"P4",40d,1.6,70d));
		personas.add(new Persona(5,"P5",50d,1.8,80d));
		personas.add(new Persona(6,"P6",60d,2d,90d));
		
		//AtomicInteger es como un Integer pero:
		//-mutable
		//-thread safe
		AtomicInteger contador = new AtomicInteger(1);
		
		Optional<Persona> pMediaOp = 
			personas
				.stream()
				.reduce( (acumulador, persona) -> { //El primer parámetro es el ACUMULADOR
					                                //El segundo parámetro es cada uno de los elementos del stream
												    //En la primera llamada acumulador es la primera persona y persona es la segunda
					if(contador.get() == 1) {
						acumulador = new Persona(acumulador);
						acumulador.setId(0);
						acumulador.setNombre("Persona media");
					}

					double totEdad   = acumulador.getEdad()*contador.intValue()+persona.getEdad();
					double totAltura = acumulador.getAltura()*contador.intValue()+persona.getAltura();
					double totPeso   = acumulador.getPeso()*contador.intValue()+persona.getPeso();
					contador.incrementAndGet();
					acumulador.setEdad(totEdad/contador.intValue());
					acumulador.setAltura(totAltura/contador.intValue());
					acumulador.setPeso(totPeso/contador.intValue());
							
					return acumulador;
				});
		
		//Seguimos con lo cutre:
		if( pMediaOp.isPresent()) {
			System.out.println("Acumulador: "+pMediaOp.get());
		}

		//Otro ejemplo, pero lograríamos el mismo resultado con 'max' 
		Optional<Factura> optF3 = 
			facturas
				.stream()
				.reduce( ( acumulador, factura) -> {
						System.out.println(acumulador.getId()+","+factura.getId());
						if(acumulador.getTotal() > factura.getTotal()){
							return acumulador;
						}
						return factura;														
					});
		System.out.println(optF3.get()); //La factura con mayor importe
										 //El resultado es el mismo que si hubieramos usado 'max'		
		
		//
		//Ordenación
		//
		System.out.println("=======================================");		
		palabras = new ArrayList<>();
		palabras.add("ddd2222");
		palabras.add("aaa2");
		palabras.add("bbb133");
		palabras.add("aaa1");
		palabras.add("bbb312678");
		palabras.add("ccc");
		palabras.add("bbb255");
		palabras.add("ddd1");
		
		List<String> palabrasOrdenadas = palabras
		    .stream()
		    //.filter( s -> s.startsWith("aaa"))		    
		    //.sorted() //Utiliza el compareTo de los objetos recibidos
		    .sorted( (p1, p2) -> p1.length()-p2.length() ) //Utiliza un Comparator
		    .collect(Collectors.toList());
		
		palabrasOrdenadas.forEach(p -> System.out.println(p));		
		
		//
		// Peek(Consumer): Nos permite echar un vistazo al elemento que pasa por un punto del stream
		//
		System.out.println("======================================");
		Stream
			.of("uno", "dos", "tres", "cuatro", "cinco")
			.peek( System.out::println )
			.map( s -> s.toUpperCase() )
			.peek( System.out::println )
			.map( s -> s+s )
			.peek( System.out::println )
			.map( s -> "-"+s+"-" )
			.forEach( System.out::println );
		
		//            //
		// Multi hilo //
		//            //
		System.out.println("======================================");
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());    // 7

		/*
		Arrays.asList("a1", "a2", "b1", "c1", "c2")
		    .parallelStream()
		    .filter(s -> true)
		    .map(s -> s.toUpperCase())
		    .forEach(s -> System.out.format(s+" "));
		*/
		
		Arrays.asList("a1", "a2", "b1", "c1", "c2")
			.parallelStream()
			.filter(s -> {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.forEach(s -> {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName());
			});			

		
		//////////////////////////////
		//                          //
		// El peligro de los stream //
		//                          //
		//////////////////////////////
		
		
		
		
		//Metodos colocados al comienzo del stream
		//No hay
		
		//Metodos 'en el medio'
		//filter   : stream con los elementos que han pasado el filtro
		//distinct : stream con elementos no repetidos
		//skip     : stream 
		//map      : un 'nuevo' stream con elementos modificados
		//flatMap  : stream
		//sorted   : stream con elementos ordenados
		//peek     : stream
		
		//Metodos colocados al final del stream
		//count    : long
		//forEach  : void
		//iterator : Iterator
		//allMatch : boolean
		//anyMatch : boolean
		//max      : Optional<T>
		//min      : Optional<T>
		//collect  : Depende del agregador utilizado
		//Reduce   : Depende de la función que se utilize
		
	}

}

//Ejemplo de un comparador
class ComparadorFacturas implements Comparator<Factura>{
	
	@Override
	public int compare(Factura f1, Factura f2) {
		return f1.getTotal().intValue()-f2.getTotal().intValue();
	}
	
}

class ServicioComunicaciones {
	public void enviarCorreoE(String direccion, String mensaje) {
		System.out.println("Enviando el mensaje "+mensaje+" a "+direccion);
	}
}




