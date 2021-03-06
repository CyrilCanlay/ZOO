package animaux_abstrait;

import autre.Zoo;
import enclos.Enclos;

public abstract class Mammifere extends Animal {

	public Mammifere(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
	}

	public abstract void mettre_bas();
}
