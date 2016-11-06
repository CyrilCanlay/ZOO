package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Zoo;
import enclos.Enclos;

public class Tigre extends Mammifere implements Terrestre {

	public Tigre(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		// TODO
	}

	@Override
	public void mettre_bas() {
		// TODO

	}

	@Override
	public void emettre_un_son() {
		System.out.println("râle");
	}

}
