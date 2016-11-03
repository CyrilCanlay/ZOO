package autre;

import java.util.Collection;

import animaux.Aigle;
import animaux.Baleine;
import animaux.Pingouin;
import animaux.PoissonRouge;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;

public class Main {
	public static void main(String[] args) {

		Zoo zoo = new Zoo();
		zoo.setMaximal_enclos(10);

		Employe papa_franku = new Employe("George Miller", false, 25);

		Aigle maxime = new Aigle("maxime", false, 20, 1000, 2, null, null);
		Baleine bob = new Baleine("bob", false, 3000, 30000, 5, null, null);
		PoissonRouge cyril = new PoissonRouge("cyril", false, 3, 200, 4, null, null);
		Pingouin xXx_pingu_xXx = new Pingouin("xXx_pingu_xXx", true, 50, 5000, 6, null, null);

		Aquarium ocean = new Aquarium();
		Voliere ciel = new Voliere();
		EnclosStandard terre = new EnclosStandard();

		ocean.ajouter_animaux(bob);
		ocean.ajouter_animaux(cyril);

		ciel.ajouter_animaux(maxime);

		papa_franku.transferer_animal(ocean, ciel, xXx_pingu_xXx);
		papa_franku.transferer_animal(ocean, ciel, bob);

		zoo.ajouter_enclos(ocean);

		zoo.afficher_nombre_animaux();
		ocean.afficher_caracteristiques_animaux_contenu();

	}
}
