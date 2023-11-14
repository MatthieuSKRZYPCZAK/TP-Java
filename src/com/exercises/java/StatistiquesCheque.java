package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 13 Novembre 2023
 */
public class StatistiquesCheque {
	public static void main(String[] args) {

		int nbCheque = 0;
		double montantCheque = 0;
		double moyenneCheque = 0;

		double montantChequeSup = 0;
		double montantChequeInf = 0;

		int chequeInf = 0;
		int chequeSup = 0;

		double maxCheque = 0;
		double minCheque = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir le numéro du chèque : (saisir 0 pour sortir)");
		long numeroCheque = scan.nextLong();

		while (numeroCheque != 0) {
			System.out.println("Quel est le montant du cheque n° " + numeroCheque + " ?");
			double saisieCheque = scan.nextDouble();

			nbCheque++;
			montantCheque += saisieCheque;
			moyenneCheque = montantCheque / nbCheque;

			// Chèque inférieur à 200€
			if (saisieCheque < 200) {
				chequeInf++;
				montantChequeInf += saisieCheque;
			}
			// Chèque supérieur ou égale à 200€
			if (saisieCheque >= 200) {
				chequeSup++;
				montantChequeSup += saisieCheque;
			}
			// Chèque le plus petit
			if (minCheque == 0 || saisieCheque < minCheque) {
				minCheque = saisieCheque;
			}
			if (maxCheque == 0 || saisieCheque > maxCheque) {
				maxCheque = saisieCheque;
			}

			System.out.println("Saisir le numéro du chèque : (saisir 0 pour sortir)");
			numeroCheque = scan.nextLong();

		}

		if (nbCheque > 0) {
			System.out.println("******** CHEQUE ***********");
			System.out.println("Le nombre de chèque introduit est de " + nbCheque + " cheque(s)");
			System.out.println("Le montant total est de " + montantCheque + " €");
			System.out.println("La moyenne des montants est de " + moyenneCheque + " €");
			System.out.println("***************************");
			System.out.println("Le nombre de chèque supérieur ou égale à 200€ est de " + chequeSup + " cheque(s)");
			System.out
					.println("Le montant total  de chèque supérieur ou égale à 200€ est de " + montantChequeSup + " €");
			System.out.println("***************************");
			System.out.println("Le nombre de chèque inférieur à 200€ est de " + chequeInf + " cheque(s)");
			System.out.println("Le montant total  de cheque inférieur à 200€ est de " + montantChequeInf + " €");
			System.out.println("Le montant du chèque le plus haut est de " + maxCheque + " €");
			System.out.println("Le montant du chèque le plus bas est de " + minCheque + " €");
		} else {
			System.out.println("Aucun chèque n'a été établi !");
		}
		scan.close();
	}
}
