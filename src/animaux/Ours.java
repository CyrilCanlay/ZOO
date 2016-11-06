package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Zoo;
import enclos.Enclos;

public class Ours extends Mammifere implements Terrestre {
	final static int AGE_MAXIMUM = 20;

	public Ours(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		selectionner_age_maximum(AGE_MAXIMUM);

	}

	@Override
	public void mettre_bas() {
		// TODO
	}

	@Override
	public void emettre_un_son() {
		System.out.println("gronde, grogne, hurle ou grommelle");
	}

}
