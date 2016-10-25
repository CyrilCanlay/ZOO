package enclos;

import animaux_abstrait.Animal;

public class Aquarium extends Enclos {

	int profondeur_bassin;
	boolean salinite_eau; // 1 = bien salé et 0 = mal salé

	@Override
	public void ajouter_animaux(Animal futur_prisonier) {
		boolean est_accepte = false;
		for (int i = 0; i < futur_prisonier.getClass().getInterfaces().length; i++) {

			if (futur_prisonier.getClass().getInterfaces()[i].toString().equals("interface animaux_interfaces.Marin")) {
				animaux_present.add(futur_prisonier);
				est_accepte = true;
			}
		}

		if (!est_accepte) {
			System.out.println("Cet animal ne peut pas aller dans l'aquarium");

		}
	}

	@Override
	public void entretenir() {
		if (this.degree_proprete < 2 && animaux_present.size() == 0) {
			degree_proprete = 2;
		}
		if (salinite_eau == false) {
			salinite_eau = true; // <( °u°)
		}
	}
}
