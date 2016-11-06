package enclos;

import hierarchie.Meute;

public class EnclosStandard extends Enclos {

	public EnclosStandard(String nom, int superficie, int nombre_maximum_animaux) {
		super(nom, superficie, nombre_maximum_animaux);
	}

	Meute meute_de_l_enclos;

	public Meute recuperer_meute_de_l_enclos() {
		return meute_de_l_enclos;
	}

	@Override
	public void entretenir() {
		if (recuperer_degree_proprete() < 2 && recuperer_animaux_present().size() == 0) {
			changer_degree_proprete(2);
		}
	}

	public void changer_meute_de_l_enclos(Meute meute_de_l_enclos) {
		this.meute_de_l_enclos = meute_de_l_enclos;
	}

}
