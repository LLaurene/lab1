package com.Risk.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static List<Continent> ListeContinent = new ArrayList<Continent>();
	static List<Territoire> ListeTerritoire = new ArrayList<Territoire>();
	static List<Mission> ListeMission = new ArrayList<Mission>();
	static List<Integer> ListeDe = new ArrayList<Integer>();

	// DEBUT DU TOUR DE JEU
	// 1- CALCULER LES RENFORTS DISPO
	// 2- PLACER LES RENFORTS
	// 3- ATTAQUER (O/N)
	// 4- SI CONQUIS, TIRE CARTE TERRITOIRE
	// 5- RENFORCEMENT/DEPLACEMENT
	// 6- CHECK SI MISSION REUSSIE
	// FIN DU TOUR DE JEU
	public static void TourDeJeu(Player unP) {
		// 1- CALCULER LES RENFORTS DISPO
		int nbArmee = unP.nbArmeeDispo();
		System.out.println("Voici la liste de vos territoires et armées présentes dessus :");
		unP.afficherTerritoryByPArmee();

		// 2- PLACER LES RENFORTS
		while (nbArmee > 0) {

			System.out.println("Votre nombre de renfort disponible : " + nbArmee);
			System.out.println("Sur quel territoire voulez vous mettre vos renforts ?");
			System.out.println("Merci de mettre sous le format : 'Id du territoire'/'nombre d'armée à mettre'");
			System.out.println("Exemple : pour l'Europe du Nord (mettre 5 armée): 3/5");

			Scanner Saisie = new Scanner(System.in);
			String result = Saisie.nextLine();
			String[] decoupe = result.split("/");
			int idT = Integer.parseInt(decoupe[0]);
			int nbA = Integer.parseInt(decoupe[1]);

			if (nbArmee - nbA >= 0) {
				for (Territoire T : unP.getListeTerritoirePlayer()) {
					if (T.getT_Id() == idT) {
						T.setT_NbArmee(T.getT_NbArmee() + nbA);
						nbArmee = nbArmee - nbA;
					}
				}
			}
			else {
				System.out.println("Vous n'avez pas assez d'armées ! Restantes :" + nbArmee);
			}
		}

		// 3- ATTAQUER (O/N)
		System.out.println("Voulez vous attaquer ? : Y/N");
		Scanner Saisie = new Scanner(System.in);
		char result = Saisie.nextLine().charAt(0);
		if (result == 'Y') {
			attack(unP);
		}





	}

	public static void attack(Player unP) {
		System.out.println("Quel territoire ?");
		Scanner S = new Scanner(System.in);
		int idTDef = Integer.parseInt(S.nextLine());
		System.out.println("En provenance de quel territoire ? ?");
		Scanner S3 = new Scanner(System.in);
		int idTAtt = Integer.parseInt(S.nextLine());
		System.out.println("Avec combien d'armées ? (3 max)");
		Scanner S1 = new Scanner(System.in);
		int nbAtt = Integer.parseInt(S1.nextLine());
		System.out.println("Défenseur, combien d'armées vous engagez ? (2 max)");
		Scanner S2 = new Scanner(System.in);
		int nbDef = Integer.parseInt(S2.nextLine());

		System.out.println("=================================AVANT ATTAQUE=========================================");
		// faire vérification que le joueur 2 a bien le territoire dans sa liste
		System.out.println("Etat des armées avant l'attaque :");
		System.out.println("Armées du défenseur : " + ListeTerritoire.get(idTDef).getT_NbArmee());
		System.out.println("Armées de l'attaquant : " + ListeTerritoire.get(idTAtt).getT_NbArmee());

		Integer[] tabDeAtt = new Integer[nbAtt];
		for (int j = 0; j < nbAtt; j++) {
			tabDeAtt[j] = LanceDe();
		}
		Arrays.sort(tabDeAtt, Collections.reverseOrder());

		Integer[] tabDeDef = new Integer[nbDef];
		for (int j = 0; j < nbDef; j++) {
			tabDeDef[j] = LanceDe();
		}
		Arrays.sort(tabDeDef, Collections.reverseOrder());
		int nbAttaquant = ListeTerritoire.get(idTAtt).getT_NbArmee();
		int nbDefenseur = ListeTerritoire.get(idTDef).getT_NbArmee();

		for (int j = 0; j < nbDef && j < nbAtt; j++) {
			if (tabDeAtt[j] > tabDeDef[j]) {
				System.out.println("Dé de l'attaquant :" + tabDeAtt[j]);
				System.out.println("Dé du défenseur:" + tabDeDef[j]);
				System.out.println("L'attaquant Win !");
				unP.getListeTerritoirePlayer().get(idTAtt).setT_NbArmee(nbDefenseur - 1);
				nbDef = nbDef - 1;
			} else if (tabDeAtt[j] <= tabDeDef[j]) {
				System.out.println("Dé de l'attaquant :" + tabDeAtt[j]);
				System.out.println("Dé du défenseur:" + tabDeDef[j]);
				System.out.println("Le défenseur Win !");
				unP.getListeTerritoirePlayer().get(idTDef).setT_NbArmee(nbAttaquant - 1);
				nbAtt = nbAtt - 1;
			} else {
				System.out.println("Plus de dés disponible, fin de l'attaque");
			}
		}
		System.out.println("=================================APRES ATTAQUE=========================================");
		System.out.println("Etat des armées après l'attaque :");
		System.out.println("Armées du défenseur : " + unP.getListeTerritoirePlayer().get(idTDef).getT_NbArmee());
		System.out.println("Armées de l'attaquant : " + unP.getListeTerritoirePlayer().get(idTAtt).getT_NbArmee());
	}


	public static int LanceDe() { // nombre aléatoire
		Random r = new Random();
		int de = 1 + r.nextInt(6 - 1);
		return de;
	}

	public static void Start() {
		// création des continents et insertion dans la liste

		ListeContinent.add(new Continent(1, "Europe", 5));
		ListeContinent.add(new Continent(2, "Asie", 7));
		ListeContinent.add(new Continent(3, "Amérique du Nord", 5));
		ListeContinent.add(new Continent(4, "Amérique du Sud", 2));
		ListeContinent.add(new Continent(5, "Afrique", 3));
		ListeContinent.add(new Continent(6, "Océanie", 2));

		// création des territoires

		ListeTerritoire.add(new Territoire(1, "Grande-Bretagne", "Tour"));
		ListeTerritoire.add(new Territoire(2, "Islande", "Catapulte"));
		ListeTerritoire.add(new Territoire(3, "Europe du Nord", "Catapulte"));
		ListeTerritoire.add(new Territoire(4, "Scandinavie", "Tour"));
		ListeTerritoire.add(new Territoire(5, "Europe du Sud", "Cavalier"));
		ListeTerritoire.add(new Territoire(6, "Ukraine", "Cavalier"));
		ListeTerritoire.add(new Territoire(7, "Europe occidentale", "Cavalier"));
		ListeTerritoire.add(new Territoire(8, "Afghanistan", "Catapulte"));
		ListeTerritoire.add(new Territoire(9, "Chine", "Tour"));
		ListeTerritoire.add(new Territoire(10, "Inde", "Cavalier"));
		ListeTerritoire.add(new Territoire(11, "Tchita", "Catapulte"));
		ListeTerritoire.add(new Territoire(12, "Japon", "Catapulte"));
		ListeTerritoire.add(new Territoire(13, "Kamtchatka", "Tour"));
		ListeTerritoire.add(new Territoire(14, "Moyen-Orient", "Cavalier"));
		ListeTerritoire.add(new Territoire(15, "Mongolie", "Cavalier"));
		ListeTerritoire.add(new Territoire(16, "Siam", "Tour"));
		ListeTerritoire.add(new Territoire(17, "Sibérie", "Cavalier"));
		ListeTerritoire.add(new Territoire(18, "Oural", "Tour"));
		ListeTerritoire.add(new Territoire(19, "Yakoutie", "Catapulte"));
		ListeTerritoire.add(new Territoire(20, "Alaska", "Cavalier"));
		ListeTerritoire.add(new Territoire(21, "Alberta", "Cavalier"));
		ListeTerritoire.add(new Territoire(22, "Amérique centrale", "Tour"));
		ListeTerritoire.add(new Territoire(23, "États de lEst", "Catapulte"));
		ListeTerritoire.add(new Territoire(24, "Groenland", "Cavalier"));
		ListeTerritoire.add(new Territoire(25, "Territoires du Nord-Ouest", "Catapulte"));
		ListeTerritoire.add(new Territoire(26, "Ontario", "Tour"));
		ListeTerritoire.add(new Territoire(27, "Québec", "Catapulte"));
		ListeTerritoire.add(new Territoire(28, "États de lOuest", "Cavalier"));
		ListeTerritoire.add(new Territoire(29, "Argentine", "Catapulte"));
		ListeTerritoire.add(new Territoire(30, "Brésil", "Tour"));
		ListeTerritoire.add(new Territoire(31, "Pérou", "Cavalier"));
		ListeTerritoire.add(new Territoire(32, "Venezuela", "Cavalier"));
		ListeTerritoire.add(new Territoire(33, "Congo", "Catapulte"));
		ListeTerritoire.add(new Territoire(34, "Afrique de l’Est", "Tour"));
		ListeTerritoire.add(new Territoire(35, "Égypte", "Tour"));
		ListeTerritoire.add(new Territoire(36, "Madagascar", "Cavalier"));
		ListeTerritoire.add(new Territoire(37, "Afrique du Nord", "Cavalier"));
		ListeTerritoire.add(new Territoire(38, "Afrique du Sud", "Catapulte"));
		ListeTerritoire.add(new Territoire(39, "Australie Orientale", "Catapulte"));
		ListeTerritoire.add(new Territoire(40, "Indonésie", "Cavalier"));
		ListeTerritoire.add(new Territoire(41, "Nouvelle-Guinée", "Catapulte"));
		ListeTerritoire.add(new Territoire(42, "Australie Occidentale", "Cavalier"));

		// création des Missions

		ListeMission.add(new Mission("Détruire le joueur 2"));
		ListeMission.add(new Mission("Annexer l'océanie et l'Amérique du Sud"));
		ListeMission.add(new Mission("Avoir 25 territoires"));
		ListeMission.add(new Mission("Annexer l'Europe et avoir 15 territoires"));
		ListeMission.add(new Mission("Détruire le joueur 4 ou Annexer Amerique du Sud et Europe"));
		ListeMission.add(new Mission("Détruire le joueur 3 ou Avoir 25 territoires"));
		ListeMission.add(new Mission("Annexer l'amérique du Nord et du Sud"));
		ListeMission.add(new Mission("Annexer l'Asie et l'Océanie"));
		ListeMission.add(new Mission("Détruire le joueur 1"));
	}

	public static void main(String[] args) {

		Start();

		// Création des players

		Scanner Saisie = new Scanner(System.in);
		System.out.println("Nombre de Joueur ? (2 à 6)");
		int NbPlayer = Integer.parseInt(Saisie.nextLine());

		List<Player> ListePlayer = new ArrayList<Player>();

		for (int i = 1; i <= NbPlayer; i++) {
			Scanner Saisie2 = new Scanner(System.in);
			System.out.println("Nom du Joueur ?");
			String str = Saisie2.nextLine();
			ListePlayer.add(new Player(str));
		}

		// création Liste aléatoire pour la distribution de carte du début

		ArrayList<Integer> ListeNbAlea = new ArrayList<Integer>();
		for (int i = 0; i < 42; i++) {
			ListeNbAlea.add(i);
		}
		Collections.shuffle(ListeNbAlea);

		int NbTerritoryByP = (int) Math.round(42 / NbPlayer);// Nombre de territoire par joueur

		int i = 0;
		for (Player P : ListePlayer) {
			for (int j = 0; (j < NbTerritoryByP); j++) {
				int idT = ListeNbAlea.get(i);
				Territoire T = ListeTerritoire.get(idT);
				T.setT_NbArmee(3);
				P.getListeTerritoirePlayer().add(T);
				T.setT_Occupation(true);
				i++;
			}
		}

		for (Player P : ListePlayer) {
			TourDeJeu(P);
		}

	}

}
