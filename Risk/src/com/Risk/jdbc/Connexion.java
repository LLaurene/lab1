package com.Risk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connexion {

	public static Connection ConnexionBDD()
	{
		Connection conn = null;
		try {
			//chargement d'un driver MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			
			String url="jdbc:mysql://localhost:3306/RiskBDD";
			String user = "root";
			String passwd = "";
			
			//2 le DriverManager tente d'instancier une connexion vers la base de données en utilisant le driver instantié précédemment
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective!");
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
