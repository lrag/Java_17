import java.util.Optional;
import java.util.function.Consumer;

import com.curso.modelo.entidad.Direccion;
import com.curso.modelo.entidad.Director;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.repositorio.PeliculaRepositorio;

public class Pruebas {

	public static void main(String[] args) {
		
		PeliculaRepositorio peliculaRepo = new PeliculaRepositorio();
		
		Pelicula p1 = peliculaRepo.buscar(3);
		System.out.println(p1.getTitulo());
		
		Pelicula p2 = peliculaRepo.buscar(20_000);
		//System.out.println(p2.getTitulo());
		if( p2 != null ) {
			System.out.println(p2.getTitulo());		
		}
				
		//Con optional como mínimo avisamos al que invoca al método de que puede recibir un null
		Optional<Pelicula> p3 = peliculaRepo.buscarOptional(3);
		//Podemos preguntar directamente si hay algo dentro del optional, pero es muy cutre
		if(p3.isPresent()){
			System.out.println(p3.get().getTitulo());
		}
		
		Optional<Pelicula> p4 = peliculaRepo.buscarOptional(20_000);
		if(p4.isPresent()){
			System.out.println(p4.get().getTitulo());
		} 
		
		//Aun teniendo un optional podemos hacerlo fallar:
		Pelicula p4bis = peliculaRepo.buscarOptional(20000).get();
		//System.out.println(p4bis.getTitulo());
		
		//
		//isPresent. Si anidamos los 'isPresent' es una chapuza
		//		
		Optional<Pelicula> pOp = peliculaRepo.buscarOptional(1);
		if( pOp.isPresent() ){
			Optional<Director> dOp = pOp.get().getDirector();
			if( dOp.isPresent() ){
				Optional<Direccion> dirOp = dOp.get().getDireccion();
				if(dirOp.isPresent()){
					System.out.println(dirOp.get().getCiudad());
				}
			}
		}
		
		//Imperativo
		if( pOp.isPresent() ){
			System.out.println(pOp.get().getTitulo());
		}		
		
		//
		//ifPresent. 
		//
		System.out.println("========================");
		//Declarativo - funcional 
		pOp.ifPresent( p -> System.out.println(p.getTitulo()) );

		//
		//flatMap y map
		//
		System.out.println("========================");
		Optional<String> ciudadOp = peliculaRepo.buscarOptional(1) //Devuelve Op<Pelicula>
			.flatMap( pelicula -> pelicula.getDirector() ) 
			.flatMap( director -> director.getDireccion() )
			.map( direccion -> direccion.getCiudad() );
		
		if( ciudadOp.isPresent() ){
			System.out.println(ciudadOp.get());
		}
		
		//
		//Or: Proporciona un optional alternativo
		//
		System.out.println("========================");		
		Optional<Pelicula> op = peliculaRepo.buscarOptional(10_000)
			.or(() -> Optional.of(new Pelicula(null,"NO HAY PELICULA")) );
		
		System.out.println(op.get());
	
		
		//
		//OrElse: Entrega un valor por defecto, que ya tenemos preparado, si el opcional esta vacio
		//
		
		System.out.println("========================");
		String ciudad = peliculaRepo.buscarOptional(1)
			.flatMap( p -> p.getDirector() )
			.flatMap( d -> d.getDireccion() )
			.map( dir -> dir.getCiudad() )
			//.orElse("No hay");
			.orElse(ExperimentosConGaseosa.getValor()); //Cuidado con esto
		
		System.out.println(ciudad);

		System.out.println("========================");
		//La diferencia entre orElse y or es que or nospermite que el valor sustituto se genere 
		//con un c�digo que proporcionamos
		Optional<String> ciudadBis = peliculaRepo.buscarOptional(1)
			.flatMap( p -> p.getDirector() )
			.flatMap( d -> d.getDireccion() )
			.map( dir -> dir.getCiudad() )
			.or(() -> {			
				ExperimentosConGaseosa.getValor();
				return Optional.of("No hay");
			});

		//
		//Filter
		//
		String ciudad2 = peliculaRepo.buscarOptional(1)
				.flatMap( p -> p.getDirector() )
				.flatMap( d -> d.getDireccion() )
				.map( dir -> dir.getCiudad() )
				.filter( c -> c.equals("Santa Pola" ))
				.orElse("No es Santa Pola");
		System.out.println(ciudad2);
		
		//
		//OrElseThrow
		//
		System.out.println("========================");
		try {
			System.out.println(buscarDireccion(10));
		} catch (Exception e) {
			//404
			System.out.println(e.getMessage());
		}
		
	}

	public static String buscarDireccion(Integer id) throws Exception {
		PeliculaRepositorio gp = new PeliculaRepositorio();
		Optional<Pelicula> peliculaOp = gp.buscarOptional(id);	
		
		return peliculaOp
			.flatMap( p -> p.getDirector() )
			.flatMap( d -> d.getDireccion() )
			.map( dir -> dir.getCiudad() )
			.orElseThrow( () -> new Exception("No existe"));		
	}
	
}

class ExperimentosConGaseosa {
	
	public static String getValor() {
		System.out.println("CALCULANDO EL VALOR POR DEFECTO");
		return "NO HAY";
	}
	
}













