package autre;
import animaux.Aigle;
import animaux.Baleine;
import animaux.Pingouin;
import animaux.PoissonRouge;
import enclos.Aquarium;

public class Main {
	public static void main(String[] args) {

		Aigle maxime = new Aigle();
		Baleine bob = new Baleine();
		PoissonRouge cyril = new PoissonRouge();
		Pingouin xXx_pingu_xXx = new Pingouin();

		Aquarium ocean = new Aquarium();

		ocean.ajouter_animaux(bob);
		ocean.ajouter_animaux(maxime);
		ocean.ajouter_animaux(cyril);

		ocean.afficher_caracteristiques_animaux_contenu();

		Zoo zoo = new Zoo();
		zoo.setMaximal_enclos(100);
		zoo.ajouter_enclos(ocean);
		zoo.afficher_nombre_animaux();
	}
}
