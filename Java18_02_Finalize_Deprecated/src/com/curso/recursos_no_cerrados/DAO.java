package com.curso.recursos_no_cerrados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

////////////////////////
//    EL PEOR DAO     //
//   DE LA HISTORIA   //
// DE LA PROGRAMACIÓN //
////////////////////////

public class DAO {

	public void insertar() {
		
		Connection cx = null;
		try/*(Connection cx = DriverManager.getConnection("jdbc:h2:c:/H2/bbdd","sa",""))*/ {
			cx = DriverManager.getConnection("jdbc:h2:c:/H2/bbdd","sa","");
			Statement st = cx.createStatement();
			String query = "INSERT INTO...";
			//st.executeUpdate(query);	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
}
