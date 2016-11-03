package autre;

import animaux.Aigle;
import animaux.Baleine;
import animaux.Pingouin;
import animaux.PoissonRouge;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;

public class Main {
	public static void main(String[] args) {

		Employe papa_franku = new Employe("George Miller", false, 25);

		Zoo zoo = new Zoo("zoo", papa_franku, 10);
		zoo.setMaximal_enclos(10);

		Aigle maxime = new Aigle("maxime", false, 20, 1000, 2, zoo, null);
		Baleine bob = new Baleine("bob", false, 3000, 30000, 5, zoo, null);
		PoissonRouge cyril = new PoissonRouge("cyril", false, 3, 200, 4, zoo, null);
		Baleine bobette = new Baleine("bobette", true, 3000, 30000, 6, zoo, null);
		Pingouin xXx_pingu_xXx = new Pingouin("xXx_pingu_xXx", true, 50, 5000, 6, zoo, null);

		Aquarium ocean = new Aquarium("ocean", 500, 100);
		Aquarium lac = new Aquarium("lac", 50, 10);
		Voliere ciel = new Voliere("ciel", 500, 100);
		EnclosStandard terre = new EnclosStandard("terre", 500, 100);

		ocean.ajouter_animaux_securise(bob);
		ocean.ajouter_animaux_securise(cyril);
		ocean.ajouter_animaux_securise(bobette);

		ciel.ajouter_animaux_securise(maxime);

		zoo.ajouter_enclos(ocean);

		zoo.controller_enploye();

	}
}
