package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 13 Novembre 2023
 */
public class Cuisson {

	public static void main(String[] args) {

		// Type de viande
		int BOEUF = 1;
		int PORC = 2;

		// Cuisson
		int BLEU = 1;
		int APOINT = 2;
		int BIENCUIT = 3;

		int tempsCuisson = 0;
		String choixViande = "";
		String choixCuisson = "";

		Scanner scan = new Scanner(System.in);

		System.out.println("************************************");
		System.out.println("Choisissez votre viande :");
		System.out.println("1 = Boeuf, 2 = Porc");
		int typeViande = scan.nextInt();

		if (typeViande == BOEUF) {
			choixViande = "boeuf";
		} else {
			choixViande = "porc";
		}

		System.out.println("************************************");
		System.out.println("Vous avez choisi : " + choixViande);
		System.out.println("Choisissez la cuisson ? :");
		System.out.println("1 = Bleu, 2 = A point, 3 = Bien cuit");
		int modeCuisson = scan.nextInt();

		if (modeCuisson == BLEU) {
			choixCuisson = "Bleu";
		} else if (modeCuisson == APOINT) {
			choixCuisson = "A point";
		} else if (modeCuisson == BIENCUIT) {
			choixCuisson = "Bien cuit";
		} else {
			System.out.println("Ce choix n'existe pas");
		}

		System.out.println("************************************");
		System.out.println("Pour votre " + choixViande + " vous avez choisi la cuisson : " + choixCuisson);
		System.out.println("Veuillez indiquer le poids en grammes ? :");
		int poids = scan.nextInt();

		if (typeViande == BOEUF) {
			switch (modeCuisson) {
			case 1:
				tempsCuisson = (int) (poids * 10 / 500f * 60);
				break;

			case 2:
				tempsCuisson = (int) (poids * 17 / 500f * 60);
				break;

			case 3:
				tempsCuisson = (int) (poids * 25 / 500f * 60);
				break;

			default:
				System.out.println("Mode de cuisson invalide");
			}
		} else if (typeViande == PORC) {
			switch (modeCuisson) {
			case 1:
				tempsCuisson = (int) (poids * 15 / 400f * 60);
				break;

			case 2:
				tempsCuisson = (int) (poids * 25 / 400f * 60);

				break;

			case 3:
				tempsCuisson = (int) (poids * 40 / 400f * 60);
				break;

			default:
				System.out.println("Mode de cuisson invalide");
			}
		} else
			System.out.println("Type de viande invalide");

		if (tempsCuisson > 0)
		System.out.println("************************************");
		System.out.println("******* L'Empire des Flammes *******");
		System.out.println("************************************");
		System.out.println(
				"Vous avez choisi du " + choixViande + " de " + poids + " grammes, avec une cuisson " + choixCuisson);
		System.out.println("Il vous faut " + tempsCuisson + " secondes de temps de cuisson");

		scan.close();
	}

}
