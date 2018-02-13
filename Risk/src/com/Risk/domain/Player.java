package com.Risk.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int P_Id;
	private String P_Nom;
	private int P_NbRenfort;
	private int P_NbTerritoire;
	
	private List<Mission> ListeMission;
	private List<Continent> ListeContinent;
	private List<Territoire> ListeTerritoirePlayer;
	
	public Player() {}
	public Player(String unNom) {
		setP_Nom(unNom);
		ListeTerritoirePlayer = new ArrayList<Territoire>();
		ListeContinent = new ArrayList<Continent>();
		ListeMission = new ArrayList<Mission>();
	}
	
	public void afficherTerritoryByP() {
		System.out.println("======================");
		System.out.println("Nom du Joueur : " + getP_Nom());
		for (Territoire T : ListeTerritoirePlayer) {
			System.out.println("Territoires possédés : " + T.getT_Nom());
		}
	}
	
	public void afficherTerritoryByPArmee() {
		System.out.println("======================");
		System.out.println("Nom du Joueur : " + getP_Nom());
		for (Territoire T : ListeTerritoirePlayer) {
			System.out.println(
					"Territoires possédés : " + T.getT_Nom() + " || Id : " + T.getT_Id() + " || Armée présente : "
							+ T.getT_NbArmee());
		}
	}

	public int nbArmeeDispo() {
		int i = 0;
		for (Territoire T : ListeTerritoirePlayer) {
			i++;
		}
		P_NbRenfort = (int) Math.round(i / 3);
		return P_NbRenfort;
	}

	public void placeArmee(int id, int nbArm) {
		for (Territoire T : ListeTerritoirePlayer) {
			T.setT_NbArmee(nbArm);
		}
	}
	
	public int getP_Id() {
		return P_Id;
	}
	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}
	public String getP_Nom() {
		return P_Nom;
	}
	public void setP_Nom(String p_Nom) {
		P_Nom = p_Nom;
	}
	public int getP_NbRenfort() {
		return P_NbRenfort;
	}
	public void setP_NbRenfort(int p_NbRenfort) {
		P_NbRenfort = p_NbRenfort;
	}
	public int getP_NbTerritoire() {
		return P_NbTerritoire;
	}
	public void setP_NbTerritoire(int p_NbTerritoire) {
		P_NbTerritoire = p_NbTerritoire;
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
	public List<Territoire> getListeTerritoirePlayer() {
		return ListeTerritoirePlayer;
	}
	public void setListeTerritoirePlayer(List<Territoire> listeTerritoirePlayer) {
		ListeTerritoirePlayer = listeTerritoirePlayer;
	}
}

