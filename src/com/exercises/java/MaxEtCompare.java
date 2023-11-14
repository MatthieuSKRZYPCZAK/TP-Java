package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 14 Novembre 2023
 */
public class MaxEtCompare {

	public static void main(String[] args) {

		System.out.println("***********************************");
		System.out.println("********  MAX et COMPARE  *********");
		System.out.println("***********************************");

		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez saisir un premier chiffre : ");
		int number1 = scan.nextInt();

		System.out.println("Veuillez saisir un second chiffre : ");
		int number2 = scan.nextInt();

		int maxNumber = maxValeur(number1, number2);
		System.out.println("La plus grande valeur saisie est : " + maxNumber);

		int compareNumber = compareValeur(number1, number2);

		if (compareNumber == 0) {
			System.out.println("les 2 valeurs sont égales");
		} else if (compareNumber > 0) {
			System.out.println("La premiere valeur est la plus grande");
		} else {
			System.out.println("La seconde valeur est la plus grande");
		}
		scan.close();
	}

	/**
	 * Compare 2 valeurs et retourne la plus grandes
	 * 
	 * @param number1
	 * @param number2
	 * @return valeur max
	 */
	public static int maxValeur(int number1, int number2) {
		if (number1 > number2) {
			return number1;
		} else if (number2 > number1) {
			return number2;
		} else {
			return number1;
		}
	}

	/**
	 * Compare 2 valeurs et retourne le résultat de la comparaison
	 * 
	 * @param number1
	 * @param number2
	 * @return 0 si les valeurs sont égale 1 si la première valeur est la plus
	 *         grande -1 si la seconde valeur est la plus grande
	 */
	public static int compareValeur(int number1, int number2) {
		if (number1 == number2) {
			return 0;
		} else if (number1 > number2) {
			return 1;
		} else
			return -1;
	}

}
