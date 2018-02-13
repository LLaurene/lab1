package com.Risk.domain;

import java.util.List;

public class Continent {
	private int C_Id;
	private String C_Nom;
	private int C_NbRenfort;
	private List<String> ListeTerritoire;
	
	
	
	public Continent() {}
	public Continent(int unId, String unNom, int desRenforts) {
		setC_Id(unId);
		setC_Nom(unNom);
		setC_NbRenfort(desRenforts);
	}
	
	
	
	
	private int getC_Id() {
		return C_Id;
	}
	private void setC_Id(int c_Id) {
		C_Id = c_Id;
	}
	private String getC_Nom() {
		return C_Nom;
	}
	private void setC_Nom(String c_Nom) {
		C_Nom = c_Nom;
	}
	private int getC_NbRenfort() {
		return C_NbRenfort;
	}
	private void setC_NbRenfort(int c_NbRenfort) {
		C_NbRenfort = c_NbRenfort;
	}
	private List<String> getListeTerritoire() {
		return ListeTerritoire;
	}
	private void setListeTerritoire(List<String> listeTerritoire) {
		ListeTerritoire = listeTerritoire;
	}
}
