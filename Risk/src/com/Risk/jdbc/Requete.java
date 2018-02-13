package com.Risk.jdbc;
 import java.sql.*;
 import java.util.*;

import com.Risk.domain.*;
 
public class Requete {
	
	static Connection conn;
	static Statement state;
	static ResultSet result;
	

	
	private List<Mission> ListeMission;
	private List<Continent> ListeContinent;
	private List<Territoire> ListeTerritoire;
	private static List<Player> ListePlayer;
	
	
	public void getTerritoire()
	{
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM territoire");
			while (result.next()) {
				getListeTerritoire().add((Territoire) result);
				System.out.println("Récupération des Territoires faite !");
				result.close();
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getContinent()
	{
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM continent");
			while (result.next()) {
				getListeContinent().add((Continent) result);
				System.out.println("Récupération des Continents faite !");
				result.close();
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getMission()
	{
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM mission");
			while (result.next()) {
				getListeMission().add((Mission) result);
				System.out.println("Récupération des Missions faite !");
				result.close();
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Player> getPlayer()
	{
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM player");
			while (result.next()) {
				getListePlayer().add((Player) result);
				System.out.println("Récupération des Missions faite !");
				result.close();
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ListePlayer;
		
	}
	
	public static void newPlayer(String unNom)
	{
		try {
			state = conn.createStatement();
			int nb = state.executeUpdate("INSERT INTO `riskbdd`.`player` (`p_nom`) VALUES ("+unNom+");");
			if( nb !=0) {System.out.println("Récupération des Missions faite !");}
			result.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Mission> getListeMission() {
		return ListeMission;
	}

	public void setListeMission(List<Mission> listeMission) {
		ListeMission = listeMission;
	}

	public List<Continent> getListeContinent() {
		return ListeContinent;
	}

	public void setListeContinent(List<Continent> listeContinent) {
		ListeContinent = listeContinent;
	}

	public List<Territoire> getListeTerritoire() {
		return ListeTerritoire;
	}

	public void setListeTerritoire(List<Territoire> listeTerritoire) {
		ListeTerritoire = listeTerritoire;
	}

	public static List<Player> getListePlayer() {
		return ListePlayer;
	}

	public void setListePlayer(List<Player> listePlayer) {
		ListePlayer = listePlayer;
	}
	
	

}
