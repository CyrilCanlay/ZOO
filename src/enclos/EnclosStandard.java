package enclos;

import animaux_abstrait.Animal;
import hierarchie.Meute;

public class EnclosStandard extends Enclos {

	Meute meute_de_l_enclos;

	public Meute recuperer_meute_de_l_enclos() {
		return meute_de_l_enclos;
	}

	@Override
	public void entretenir() {
		if (this.degree_proprete < 2 && animaux_present.size() == 0) {
			degree_proprete = 2;
		}
	}

}
