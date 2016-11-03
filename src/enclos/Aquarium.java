package enclos;

import animaux_abstrait.Animal;

public class Aquarium extends Enclos {

	int profondeur_bassin;
	boolean salinite_eau; // 1 = bien salé et 0 = mal salé

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
