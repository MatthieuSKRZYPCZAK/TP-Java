package com.exercises.java;

import java.math.BigInteger;

/**
 * @author Matthieu SKR.
 * @date 14 Novembre 2023
 */
public class EchiquierDeSissa {
	public static void main(String[] args) {
		int cases = 64;
		BigInteger nbRiz = new BigInteger("1");
		BigInteger totalRiz = new BigInteger("1");

		System.out.println("Il y a " + totalRiz + " grain de riz sur la première case ");
		for (int i = 2; i < cases + 1; i++) {
			nbRiz = nbRiz.multiply(BigInteger.valueOf(2));
			System.out.println("Il y a " + nbRiz + " grains de riz sur la case " + i);
			totalRiz = totalRiz.add(nbRiz);
		}

		System.out.println("Le nombre de riz total sur la dernière case de l'échiquier est de " + nbRiz);
		System.out.println("Le nombre de riz total sur l'échiquier est de " + totalRiz);

	}

}
