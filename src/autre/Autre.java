package autre;

import java.util.Scanner;

public class Autre {

	public final static Scanner lire_clavier = new Scanner(System.in);

	final static String alphabet_grec[] = { "alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta",
			"iota", "kappa", "lambda", "mu", "nu", "xi", "omicron", "pi", "rho", "sigma", "tau", "upsilon", "phi",
			"khi", "psi", "omega" };

	public static int nombre_aleatoire_borne(int minimum, int maximum) {
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static String recuperer_alphabet_grec(int index) {
		return alphabet_grec[index];
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
