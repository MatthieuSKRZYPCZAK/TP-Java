package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 14 Novembre 2023
 */
public class NombresPremiers {

	public static void main(String[] args) {
		{
			/*
			 * Boucle pour afficher les nombres premiers compris en 0 et 1000 for (int
			 * number = 0; number <= 1000; number++) { if (premier(number)) {
			 * System.out.println(number + " est un nombre premier."); } }
			 */

			Scanner scan = new Scanner(System.in);
			System.out.println("Saisir une limite :");
			int limite = scan.nextInt();

			for (int number = 0; number <= limite; number++) {
				if (premier(number)) {
					System.out.println(number + " est un nombre premier.");
				}
			}

			scan.close();

		}
	}

	/**
	 * 
	 * @param number
	 * @return Retourne un booléen
	 */
	public static boolean premier(int number) {

		if (number <= 1) {
			return false;
		}

		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}

		// Vérifie les diviseurs jusqu'à la racine carrée, nombre impairs
		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;

	}

}
