package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 16 Novembre 2023
 */
public class representationBinaire {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String binaire = "";
		int saisi = -1;    // initialise à -1 pour entrer dans la boucle while
		
		// Demande de saisir un nombre tant que la saisie n'est pas comprise entre 0 et 256
		while(saisi < 0 || saisi > 256) {   
			System.out.println("Saisir un nombre entre 0 et 256");
			saisi = scan.nextInt();
			
		}
		int saisiBin = saisi;
		if (saisiBin ==0) {
			binaire = "0";
		} else {
			while(saisiBin > 0) {
				int reste = saisiBin % 2;
				binaire = reste + binaire;
				saisiBin = saisiBin/2;
			}
		}
		System.out.println("**********************************");
		System.out.println("le binaire de " + saisi + " est :" + binaire);
		System.out.println("**********************************");
		scan.close();
	}

}
