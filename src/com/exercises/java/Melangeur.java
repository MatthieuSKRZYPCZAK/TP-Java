package com.exercises.java;


import java.util.Random;
import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 15 Novembre 2023
 */
public class Melangeur {
	

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String resultat = "";
		
		System.out.println("Veuillez saisir une phrase :");
		String phrase = scan.nextLine();
		
		// Séparation des mots
		String[] mots = phrase.split(" ");

		for(int i = 0; i < mots.length; i++) {
			if(mots[i].length() > 3) {
				
				// Je récupère la première lettre
				char premiereLettre = mots[i].charAt(0);
				
				// Je récupère la dernière lettre
				char derniereLettre = mots[i].charAt(mots[i].length() - 1);
				
				// Je récupère toutes les lettres sans les extrémités et je les mets dans un tableau
				char[] mot = mots[i].substring(1, mots[i].length() - 1 ).toCharArray();
				
				
				// Mélange les lettres du tableau mot
				Random random = new Random();
				for (int indice = mot.length - 1; indice > 0; indice--) {  // -1 car l'index commence à 0 
					int index = random.nextInt(indice + 1);                // et -1 de la longueur max
					
					char temporaire = mot[index];                         // stock le caractère mot[index] dans temporaire
					mot[index] = mot[indice];							  // mélange les positions (index / indice)
					mot[indice] = temporaire;							  // stock le caractère dans son emplacement aléatoire
				}
				String nouveauMot = premiereLettre + new String(mot) + derniereLettre;
				resultat += nouveauMot + " ";     // concatène à la variable le mot modifié de la phrase

			} else {
				resultat += mots[i] + " ";        // concatène à la variable le mot inférieur à 3 lettres
			}
		}
		System.out.println(resultat);
		scan.close();
	}
}

