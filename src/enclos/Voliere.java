package enclos;

import animaux_abstrait.Animal;

public class Voliere extends Enclos {

	int hauteur;



	@Override
	public void entretenir() {
		if (this.degree_proprete < 2 && animaux_present.size() == 0) {
			degree_proprete = 2;
		}
	}

}
