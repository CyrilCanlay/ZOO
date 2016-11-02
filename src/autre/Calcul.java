package autre;

public class Calcul {

	final static char alphabet_grec[] = { 'α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ', 'μ', 'ν', 'ξ', 'ο',
			'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω' };

	public static int nombre_aleatoire_borne(int minimum, int maximum) {
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static char recuperer_alphabet_grec(int index) {
		return alphabet_grec[index];
	}
}
