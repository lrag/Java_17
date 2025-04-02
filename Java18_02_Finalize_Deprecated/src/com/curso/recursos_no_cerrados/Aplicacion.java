package com.curso.recursos_no_cerrados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {

		/*
		//Por los viejos tiempos...
		try {
			//h2 es una base de datos pequeña tipo derby o sqlite
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		*/	
		System.out.println("=======================================");
		System.out.println("Iniciando test 'recursos no cerrados'...");
		Thread.sleep(10_000);
		System.out.println("Creando conexiones...");		
				
		DAO dao = new DAO();
		for(int a=0; a<50_000; a++) {
			dao.insertar();
		}
		
		System.out.println("=======================================");
		Thread.sleep(160_000);
		System.out.println("FIN");
				
	}
	
}
