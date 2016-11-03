package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Marin;
import autre.Zoo;
import enclos.Enclos;

public class Baleine extends Mammifere implements Marin {

	public Baleine(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mettre_bas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emettre_un_son() {
		System.out.println("chante");

	}

}
