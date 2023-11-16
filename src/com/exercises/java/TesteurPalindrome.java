package com.exercises.java;

import java.util.Scanner;
import java.text.Normalizer;

/**
 * @author Matthieu SKR.
 * @date 16 Novembre 2023
 */
public class TesteurPalindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Testeur de Palindrome, votre phrase est il un palindrome ?");
		System.out.println("Saisir une phrase :");
		String palindrome = scan.nextLine();
		System.out.println("Vous avez saisie la phrase :" + palindrome);
		
		
		// supprime les espaces
		String[] palindromeTab = palindrome.split(" ");
		String palindromeSplit = "";		
		for(String mot : palindromeTab ) {
			palindromeSplit += mot.toLowerCase();
		}
		
		// Retire les accents
		String palindromeSansAccents = Normalizer.normalize(palindromeSplit, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

		// inverse l'ordre du string
		String inversePalindromeSplit = new StringBuilder(palindromeSansAccents).reverse().toString();
		
		
		// Compare la phrase avec la phrase inversée
		if(palindromeSansAccents.equals(inversePalindromeSplit)) {
			System.out.println("La phrase est un palindrome");
		} else {
			System.out.println("La phrase n'est pas un palindrome");
		}
		scan.close();
	}
}
