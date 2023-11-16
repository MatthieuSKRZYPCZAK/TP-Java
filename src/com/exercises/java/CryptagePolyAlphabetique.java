package com.exercises.java;

import java.util.Scanner;

/**
 * @author Matthieu SKR.
 * @date 15 Novembre 2023
 */
public class CryptagePolyAlphabetique {

	public static void main(String[] args) {
		
		String key = "";
		String word = "";
		int choix = 0;

		Scanner scan = new Scanner(System.in);
		
		System.out.println("*********************************************************");
        System.out.println("*                                                       *");
        System.out.println("*                                                       *");
        System.out.println("*   ██████╗██████╗ ██╗   ██╗██████╗ ████████╗ ██████╗   *");
        System.out.println("*  ██╔════╝██╔══██╗╚██╗ ██╔╝██╔══██╗╚══██╔══╝██╔═══██╗  *");
        System.out.println("*  ██║     ██████╔╝ ╚████╔╝ ██████╔╝   ██║   ██║   ██║  *");
        System.out.println("*  ██║     ██╔══██╗  ╚██╔╝  ██╔═══╝    ██║   ██║   ██║  *");
        System.out.println("*  ╚██████╗██║  ██║   ██║   ██║        ██║   ╚██████╔╝  *");
        System.out.println("*   ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚═╝        ╚═╝    ╚═════╝   *");
        System.out.println("*                                                       *");
        System.out.println("*              Cryptage Poly Alphabétique               *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");

        
        while(true) {
        	System.out.println("Veuillez faire un choix :");
    	    System.out.println("1 - Crypter");
    	    System.out.println("2 - Décrypter");
    	    if(scan.hasNextInt()){
    	    	choix = scan.nextInt();
    	    	if(choix == 1 || choix == 2) {
    	    		break;
    	    	}
    	    } else {
    	    	scan.next();	
    	    }
    	    System.out.println("Choix invalide. Veuillez réessayer.");
        }
  
	    
		while(true) {
			System.out.println("Veuillez saisir un mot :");
			scan.nextLine();
			word = scan.nextLine();
			if(word.matches("[a-zA-Z]+")) {  // expression régulière : doit contenir uniquement les lettres de l'alphabet
				break;
			} else {
				System.out.println("La saisie doit contenir uniquement des lettres de l'alphabet. Veuillez réessayer");
			}
		}

		while(true) {
			System.out.println("Veuillez saisir une clé (8 caractères maximum :");
			key = scan.nextLine();
			
			if(key.length() <= 8) {
				break;
			}else {
				System.out.println("La clé saisie est trop longue, Veuillez réessayer");
			}
		}
		
		if(choix == 1) {
			crypter(word, key);
		}else {
			decrypter(word, key);
		}

		scan.close();
	}
	
	/**
	 * Méthode qui décrypte le mot crypté
	 * @param word
	 * @param key
	 */
	public static void decrypter(String word, String key) {
		
		char[][] cryptageTab = creationTab();		
		String decrypted = "";
		char[] keyTab = key.toCharArray();
		char[] wordTab = word.toCharArray();
		
		for(int index = 0; index < wordTab.length; index++) {
	        int indexKey = index % keyTab.length;
	        char keyChar = keyTab[indexKey];
	        char encryptedChar = wordTab[index];
	        
	        int row = positionAlphabet(keyChar) - 1;
	        
	        // Trouver l'index de encryptedChar dans la ligne de la clé
	        int col = -1;
	        for (int i = 0; i < 26; i++) {
	            if (cryptageTab[row][i] == encryptedChar) {
	                col = i;
	                break;
	            }
	        }
	        
	        // Utiliser l'index pour obtenir la lettre déchiffrée
	        if (col != -1) {
	            decrypted += (char) ('A' + col);
	        } else {
	            decrypted += '?'; // En cas d'erreur, ajoute un caractère de placeholder
	        }
	    }
		
		System.out.println("Votre mot crypté : " + word);
		System.out.println("Voici le décryptage : " + decrypted);
		
	}
	
	
	/**
	 * Création du tableau 2D
	 * @return le tableau 2D
	 */
	public static char[][] creationTab(){
		char[][] cryptageTab = new char[26][26];		
		// Remplissage du tableau 
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				cryptageTab[i][j] = (char) ('A' + (i + j) % 26);
			}
		}
		return cryptageTab;
	}
	
	/**
	 * Méthode qui crypte un mot et l'affiche
	 * @param word
	 * @param key
	 */
	public static void crypter(String word, String key) {
		
		char[][] cryptageTab = creationTab();
		
		String crypto = "";
		char[] keyTab = key.toCharArray();
		char[] wordTab = word.toCharArray();
		
		
		for(int index = 0; index < wordTab.length; index++) {
			int indexKey = index % keyTab.length;
			int j = positionAlphabet(wordTab[index])- 1;
			int i = positionAlphabet(keyTab[indexKey])- 1;
			
			crypto = crypto + cryptageTab[j][i];
		}
		
		System.out.println("Votre mot sans cryptage : " + word);
		System.out.println("Votre mot crypté : " + crypto);
	}
	
	
	/**
	 * Renvoie la position de le lettre dans l'alphabet
	 * @param lettre
	 * @return Position de la lettre dans l'alphabet
	 */
	public static int positionAlphabet(char lettre) {
		int position;
		
		if(Character.isUpperCase(lettre)) {
			position = lettre - 'A' + 1;
		} else if (Character.isLowerCase(lettre)) {
			position = lettre - 'a' + 1;
		} else {
			position = -1;
		}		
		return position;
	}

}
