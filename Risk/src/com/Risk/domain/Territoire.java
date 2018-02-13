package com.Risk.domain;

public class Territoire {

	private int T_Id;
	private String T_Renfort; //icone du type de renfort
	private String T_Nom;
	private boolean T_Occupation;
	private int T_NbArmee;
	
	
	
	public Territoire() {}

	public Territoire(int unId, String unNom, String unRenfort) {
		setT_Id(unId);
		setT_Occupation(false);
		setT_NbArmee(0);
		setT_Renfort(unRenfort);
		setT_Nom(unNom);
	}
	
	

	public int getT_Id() {
		return T_Id;
	}
	public void setT_Id(int t_Id) {
		T_Id = t_Id;
	}
	public String getT_Renfort() {
		return T_Renfort;
	}
	public void setT_Renfort(String t_Renfort) {
		T_Renfort = t_Renfort;
	}
	public String getT_Nom() {
		return T_Nom;
	}
	public void setT_Nom(String t_Nom) {
		T_Nom = t_Nom;
	}
	public boolean isT_Occupation() {
		return T_Occupation;
	}
	public void setT_Occupation(boolean t_Occupation) {
		T_Occupation = t_Occupation;
	}
	public int getT_NbArmee() {
		return T_NbArmee;
	}
	public void setT_NbArmee(int t_NbArmee) {
		T_NbArmee = t_NbArmee;
	}
	
	
}
