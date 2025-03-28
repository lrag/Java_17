package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pruebas {
	
	public static void main(String[] args) throws IOException {
		
		//Hasta java 9 los recursos auto cerrables han de declararse en el try
		try ( 
				FileWriter fw2 = new FileWriter("texto2.txt");
				BufferedWriter bw = new BufferedWriter(fw2)
			){
			
			bw.write("Toma ya!\n");
			
		} catch(IOException e){
			e.printStackTrace();
		}		
		
		//A partir de Java9 tambien pueden declararse antes 
		//Han de ser finales o efectivamente finales
		FileWriter fw2 = new FileWriter("texto2.txt");  
		BufferedWriter bw = new BufferedWriter(fw2);
		try ( fw2; bw ){			
			bw.write("En fin...\n");			
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}
