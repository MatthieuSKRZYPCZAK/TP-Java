package com.exercises.java;

import java.util.Random;

/**
 * @author Matthieu SKR.
 * @date 16 Novembre 2023
 */
public class GestionDesVilles {

	public static void main(String[] args) {

		String[] cities = { "Lille", "Lens", "Amiens", "Rouen", "Caen", "Rennes", "Nantes", "Niort", "Bordeaux",
				"Bayonne" };

		displayTab(cities);

		displayTabStartingWithA(cities);
		
		displayTabWithRandomNumber(cities);

	}

	// Affiche le contenu d'un tableau
	private static void displayTab(String[] array) {
		System.out.println("******* Contenu du tableau *******");
		for (String element : array) {
			System.out.println(element);
		}
	}

	// Affiche le contenu d'un tableau dont le nom commence par la lettre A
	private static void displayTabStartingWithA(String[] array) {
		System.out.println("******* Contenu du tableau commençant par la lettre A *******");
		for (String element : array) {
			char firstLetter = element.charAt(0);
			if (firstLetter == 'A') {
				System.out.println(element);
			}
		}
	}
	
	// Affiche le contenu d'un tableau avec un numéro aléatoire en fin de nom
	private static void displayTabWithRandomNumber(String[] array) {
		Random random = new Random();
		System.out.println("******* Contenu du tableau avec un numéro aléatoire en fin de nom *******");
		for (String element : array) {
			System.out.println(element + random.nextInt(99));
		}
	}

}
