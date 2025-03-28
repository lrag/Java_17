import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class PruebasBase64 {

	public static void main(String[] args) throws Exception{

		//Codificando de forma binaria: cada bit es un byte
		//Codificando de forma decimal: cada byte son tres dígitos 
		//Codificando de forma hexadecimal: cada byte son dos caracteres
		//Base64: Cada tres bytes son cuatro caracteres. 1,33
		
		//Encode 
		String txtB64 = null;
		try {
			txtB64 = Base64.getEncoder().encodeToString("La tumba sin nombre junto a la de Stanton".getBytes("utf-8"));
			System.out.println(txtB64); 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
				
		//Decode
		try {
			byte[] bytes = Base64.getDecoder().decode(txtB64);
			System.out.println(new String(bytes, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 	
		
				
		//Encode para URL
		try {
			String basicEncoded = Base64.getEncoder().encodeToString("clientes?abcd".getBytes("utf-8"));
			System.out.println("Alfabeto básico  : " + basicEncoded);

			String urlEncoded = Base64.getUrlEncoder().encodeToString("clientes?abcd".getBytes("utf-8"));
			System.out.println("Alfabeto para url: " + urlEncoded);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		//Encode para MIME
		try {
			String texto = "Lorem fistrum sexuarl al ataquerl no puedor va usté muy cargadoo apetecan te va a hasé pupitaa amatomaa. Apetecan llevame al sircoo tiene musho peligro caballo blanco caballo negroorl ahorarr pecador a wan. Ahorarr tiene musho peligro quietooor quietooor ese pedazo de pecador diodeno diodenoo. Tiene musho peligro diodeno pupita a peich pupita. Se calle ustée tiene musho peligro está la cosa muy malar la caidita. Va usté muy cargadoo a wan papaar papaar la caidita a wan amatomaa diodeno. A gramenawer la caidita mamaar sexuarl. Caballo blanco caballo negroorl a gramenawer va usté muy cargadoo por la gloria de mi madre diodeno a wan de la pradera ese que llega te voy a borrar el cerito condemor.";
			byte[] toEncode = texto.getBytes("utf-8");
			String mimeEncoded = Base64.getMimeEncoder().encodeToString(toEncode);
			System.out.println(mimeEncoded);

			String texto2 = new String(Base64.getMimeDecoder().decode(mimeEncoded.getBytes()), "utf-8");
			System.out.println(texto2);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
		//Wrapping de streams
		String txt = "El hacendado Trelawney, el doctor Livesey y los demás caballeros me pidieron que escribiera todos los pormenores que yo conociera de la Isla del Tesoro y que lo hiciera de cabo a rabo, sin omitir otra cosa que la localización de la isla, y eso porque en ella todavía hay una parte del tesoro sin desenterrar. Así pues, cojo la pluma en este año de gracia de 1700 y pico y me remonto con la memoria al tiempo en que mi padre regentaba la posada del 'Almirante Benbow', cuando el viejo marino de piel atezada, con la cicatriz de un sable en el rostro, tomó por primera vez asiento en nuestra casa, bajo nuestro propio techo.";
		
		//Escribiendo
		try (OutputStream os = Base64
								.getEncoder()
								.wrap(new BufferedOutputStream(new FileOutputStream("datos-base64.txt")))) {
			os.write(txt.getBytes("utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Leyendo
		try (InputStream is = Base64.getDecoder().wrap(new FileInputStream("datos-base64.txt"))) {
			int len;
			byte[] bytes = new byte[100];
			while ((len = is.read(bytes)) != -1) {
				System.out.print(new String(bytes, 0, len, "utf-8"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
