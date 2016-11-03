package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Marin;
import animaux_interfaces.Terrestre;
import animaux_interfaces.Volant;
import autre.Zoo;
import enclos.Enclos;

public class Pingouin extends Autre implements Marin, Terrestre, Volant {

	public Pingouin(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pondre() {

	}

	@Override
	public void emettre_un_son() {
		System.out.println("jabote");
	}

}
