package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Terrestre;
import animaux_interfaces.Volant;
import autre.Zoo;
import enclos.Enclos;

public class Aigle extends Autre implements Terrestre, Volant {

	public Aigle(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
	}

	@Override
	public void pondre() {
		if (est_une_femelle()) {
			System.out.println("c'est paques voila un oeuf");
		}
	}

	@Override
	public void emettre_un_son() {
		System.out.println("glatit");
	}

}
