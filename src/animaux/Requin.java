package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Marin;
import autre.Zoo;
import enclos.Enclos;

public class Requin extends Autre implements Marin {
	final static int AGE_MAXIMUM = 30;

	public Requin(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		selectionner_age_maximum(AGE_MAXIMUM);
	}

	@Override
	public void pondre() {
		// TODO Auto-generated method stub
	}

	@Override
	public void emettre_un_son() {
		System.out.println("...");
	}
}