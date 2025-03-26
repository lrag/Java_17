import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Pruebas {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws InterruptedException {
		
		//Cuidado que SimpleDateFormat no es Thread Safe
		String fechaStr = "15/11/2017";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f1 = null;
		try {
			f1 = sdf.parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//
		//Instant
		//
		
		//Los constructores de instant (y del resto de clases de java time)
		//son privados
		//Instant i = new Instant();
		
		System.out.println("==============================================");
		Instant i1 = Instant.now();
		Thread.sleep(1);
		Instant i2 = Instant.now();
		
		System.out.println(i1);
		System.out.println(i2);

		System.out.println(i1.toEpochMilli()); //Milisegundos desde el 1/1/1970
		System.out.println(i2.toEpochMilli());
		
		//Los objetos de java.time son inmutables
		System.out.println(i2.isAfter(i1));
		//plus para añadir, minus para restar
		i1.plus(1, ChronoUnit.HOURS);
		System.out.println(i2.isAfter(i1));
		
		i1 = i1.plus(1, ChronoUnit.HOURS);
		System.out.println(i2.isAfter(i1));
		
		//
		//LocalDate
		//
		System.out.println("===========================================");
		LocalDate ld = LocalDate.now();
		System.out.println("LocalDate:"+ld);

		System.out.println("Día del mes:"+ld.getDayOfMonth());
		System.out.println("Día de la semana:"+ld.getDayOfWeek());
		System.out.println("Día del año:"+ld.getDayOfYear());
		System.out.println("Mes:"+ld.getMonthValue());
		System.out.println("Mes:"+ld.getMonth());
		System.out.println("Año:"+ld.getYear());
		
		System.out.println("Días desde el 1/1/1970:"+ld.getLong(ChronoField.EPOCH_DAY));
		//System.out.println("ZAS:"+ld.getLong(ChronoField.SECOND_OF_DAY));
				

		LocalDate ld2 = LocalDate.of(2030, 1, 1);
		System.out.println(ld2);		

		//ld.plus(amountToAdd);
		//ld.minus(amountToSubtract);

		//
		//LocalTime
		//
		System.out.println("===========================================");
		LocalTime lt = LocalTime.now();
		System.out.println("LocalTime:"+lt);
		System.out.println("Hora:"+lt.getHour());
		System.out.println("Minutos:"+lt.getMinute());
		System.out.println("Segundos:"+lt.getSecond());
		System.out.println("Nanosegundos:"+lt.getNano()); //La precision depende del hardware
		System.out.println("Segundo del día:"+lt.toSecondOfDay());
		System.out.println("+ 50 minutos:"+lt.plusMinutes(50));
		System.out.println("Inmutable:"+lt);
		//System.out.println("ZAS:"+lt.getLong(ChronoField.DAY_OF_MONTH));
		
		//
		//LocalDateTime
		//
		System.out.println("===========================================");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("LocalDateTime:"+ldt);		
		
		//
		//Formatters: son thread safe!
		//
		System.out.println("===========================================");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld3 = LocalDate.parse("10/10/2025", dtf);
		System.out.println(ld3);
		
		String fecha = ld3.format(dtf);
		System.out.println(fecha);	

		//
		//ZonedDateTime
		//
		System.out.println("===========================================");
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);

		ZoneId madrid   = ZoneId.of("Europe/Madrid");
		ZoneId canarias = ZoneId.of("Atlantic/Canary");
		
		ZonedDateTime zdt2 = ZonedDateTime.of(LocalDateTime.now(), madrid);
		ZonedDateTime zdt4 = zdt2.withZoneSameInstant(canarias);
		
		System.out.println("Madrid  :"+zdt2.toLocalTime());
		System.out.println("Canarias:"+zdt4.toLocalTime());		
		
	}	
	
}
















