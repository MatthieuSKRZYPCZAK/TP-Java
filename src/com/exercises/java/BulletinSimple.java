package com.exercises.java;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * @author Matthieu SKR.
 * @date 13 Novembre 2023
 */
public class BulletinSimple {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00"); // format decimal, 2 chiffres après la virgule
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir votre Nom :");
		String nom = scan.nextLine();

		System.out.println("Saisir votre Prénom :");
		String prenom = scan.nextLine();

		String nameStatut = "";
		while (true) {
			System.out.println("Saisir votre statut :");
			System.out.println("1 = Cadre, 2 = Agent de maitrise, 3 = Employé de bureau");
			int statut = scan.next().charAt(0);
			switch (statut) {
			case '1':
				nameStatut = "Cadre";
				break;
			case '2':
				nameStatut = "Agent de maitrise";
				break;
			case '3':
				nameStatut = "Employé de bureau";
				break;
			default:
				System.out.println("Ce statut n'existe pas !");
				continue;
			}
			break;
		}

		System.out.println("Saisir le nombre d'heures effectuées :");
		int nbHeures = scan.nextInt();

		System.out.println("Saisir le nombre d'enfants :");
		int nbEnfants = scan.nextInt();

		System.out.println("Saisir le taux horaire :");
		float tauxHoraire = scan.nextInt();

		double salaireBrut = salaireDeBase(nbHeures, tauxHoraire);

		double totalCotisations = (salaireBrut * 26.91) / 100;
		int prime = primeEnfants(nbEnfants);
		double salaire = salaireNet(salaireBrut, totalCotisations, prime);


		System.out.println("******************************************");
		System.out.println("BULLETIN DE PAIE");
		System.out.println("******************************************");
		System.out.println("Nom : " + nom);
		System.out.println("Prénom : " + prenom);
		System.out.println("Statut : " + nameStatut);
		System.out.println("Nombre d'heures : " + nbHeures);
		System.out.println("Taux horaire: " + tauxHoraire);
		System.out.println("Nombre d'enfants : " + nbEnfants);
		System.out.println("Votre salaire brut est de : " + df.format(salaireBrut) + " €");
		System.out.println("Total des primes : " + df.format(prime) + " €");
		System.out.println("Votre salaire Net est de : " + df.format(salaire) + " €");
		System.out.println("******************************************");
		System.out.println("COTISATIONS SOCIALES");
		System.out.println("******************************************");
		System.out.println("LIBELLE      | TAUX  |  MONTANT");
		System.out.println("-------------|-------|----------|");
		System.out.println("CRDS / CSG   | 3.49% | " + df.format(salaireBrut * 0.0349));
		System.out.println("CSG          | 6.15% | " + df.format(salaireBrut * 0.0615));
		System.out.println("Ass. Maladie | 0.95% | " + df.format(salaireBrut * 0.0095));
		System.out.println("Ass. Vieil.  | 8.44% | " + df.format(salaireBrut * 0.0844));
		System.out.println("Ass. Chômage | 3.05% | " + df.format(salaireBrut * 0.0305));
		System.out.println("IRCEM        | 3.81% | " + df.format(salaireBrut * 0.0381));
		System.out.println("Cot. AGFF    | 1.02% | " + df.format(salaireBrut * 0.0102));
		System.out.println("Total des cotisations : " + df.format(totalCotisations) + " €");

		scan.close();
	}

	/**
	 * Calcul du salaire Brut en fonction du nombres d'heures et du taux horaire
	 * 
	 * @param nbHeures
	 * @param tauxHoraire
	 * @return Salaire Brut
	 */
	private static double salaireDeBase(int nbHeures, float tauxHoraire) {
		if (nbHeures < 169)
			return (nbHeures * tauxHoraire);
		else if (nbHeures < 180)
			return (169 * tauxHoraire) + ((nbHeures - 169) * tauxHoraire * 1.5f);
		else
			return (169 * tauxHoraire) + (11 * tauxHoraire * 1.5f) + ((nbHeures - 180) * tauxHoraire * 1.6f);
	}

	/**
	 * Calcul Prime enfants
	 * 
	 * @param nbEnfants
	 * @return Montant de la prime
	 */
	private static int primeEnfants(int nbEnfants) {
		switch (nbEnfants) {
		case 0:
			return 0;
		case 1:
			return 20;
		case 2:
			return 50;
		default:
			return (70 + (nbEnfants - 2) * 20);
		}
	}

	/**
	 * Calcul du salaire NET
	 * 
	 * @param salaireBrut
	 * @param totalCotisations
	 * @param prime
	 * @return Salaire NET
	 */
	private static double salaireNet(double salaireBrut, double totalCotisations, int prime) {
		return (salaireBrut - totalCotisations + (float)prime);
	}

}
