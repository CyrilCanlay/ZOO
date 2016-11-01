package autre;

public class Calcul {
	public static int nombre_aleatoire_borne(int minimum, int maximum) {
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}
}
