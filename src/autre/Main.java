package autre;

import java.util.ArrayList;

import animaux.Aigle;
import animaux.Baleine;
import animaux.Loup;
import animaux.Pingouin;
import animaux.PoissonRouge;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;
import hierarchie.Colonie_loups;
import hierarchie.Couple_alpha;
import hierarchie.Meute;

public class Main {
	public static void main(String[] args) {

		System.out.println("\n");
		System.out.println("Chargement en cours ...");
		System.out.println("\n");

		// Exemple

		// Employe
		Employe papa_franku = new Employe("George Miller", false, 24);

		// Zoo
		Zoo zoo = new Zoo("zoo", papa_franku, 10);

		// Animaux
		Aigle maxime = new Aigle("maxime", false, 20, 1000, 2, zoo, null);

		Baleine bob = new Baleine("bob", false, 3000, 30000, 5, zoo, null);
		Baleine bobette = new Baleine("bobette", true, 3000, 30000, 6, zoo, null);

		Loup a = new Loup("a", false, 0, 0, 10, zoo, null, 10, 0, 1, 0, 0, null);
		Loup b = new Loup("b", true, 0, 0, 10, zoo, null, 9, 0, 1, 0, 0, null);
		Loup c = new Loup("c", false, 0, 0, 10, zoo, null, 8, 0, 2, 0, 0, null);
		Loup d = new Loup("d", true, 0, 0, 10, zoo, null, 7, 0, 2, 0, 0, null);
		Loup e = new Loup("e", false, 0, 0, 10, zoo, null, 6, 0, 2, 0, 0, null);
		Loup f = new Loup("f", true, 0, 0, 10, zoo, null, 5, 0, 3, 0, 0, null);
		Loup g = new Loup("g", false, 0, 0, 10, zoo, null, 4, 0, 3, 0, 0, null);
		Loup h = new Loup("h", true, 0, 0, 10, zoo, null, 3, 0, 3, 0, 0, null);
		Loup i = new Loup("i", false, 0, 0, 10, zoo, null, 2, 0, 4, 0, 0, null);
		Loup o = new Loup("o", true, 0, 0, 10, zoo, null, 0, 0, 4, 0, 0, null);

		Pingouin xXx_pingu_xXx = new Pingouin("xXx_pingu_xXx", true, 50, 5000, 6, zoo, null);

		PoissonRouge cyril = new PoissonRouge("cyril", false, 3, 200, 4, zoo, null);

		// Enclos
		Aquarium ocean = new Aquarium("ocean", 500, 100);
		ocean.changer_degree_proprete(0);
		Aquarium lac = new Aquarium("lac", 50, 10);
		Voliere ciel = new Voliere("ciel", 500, 100);
		EnclosStandard terre = new EnclosStandard("terre", 500, 100);
		EnclosStandard loup_land = new EnclosStandard("loup_land", 1000, 1000);

		// Ajout des animaux dans les enclos

		loup_land.ajouter_animaux_securise(a);
		loup_land.ajouter_animaux_securise(b);
		loup_land.ajouter_animaux_securise(c);
		loup_land.ajouter_animaux_securise(d);
		loup_land.ajouter_animaux_securise(e);
		loup_land.ajouter_animaux_securise(f);
		loup_land.ajouter_animaux_securise(g);
		loup_land.ajouter_animaux_securise(h);
		loup_land.ajouter_animaux_securise(i);
		loup_land.ajouter_animaux_securise(o);

		ocean.ajouter_animaux_securise(bob);
		ocean.ajouter_animaux_securise(cyril);
		ocean.ajouter_animaux_securise(bobette);

		ciel.ajouter_animaux_securise(maxime);

		// Ajout des enclos

		zoo.ajouter_enclos(ocean);
		zoo.ajouter_enclos(terre);
		zoo.ajouter_enclos(ciel);
		zoo.ajouter_enclos(lac);
		zoo.ajouter_enclos(loup_land);

		// ajout des meutes de loups

		ArrayList<Loup> loups = new ArrayList<Loup>();
		loups.add(a);
		loups.add(b);
		loups.add(c);
		loups.add(d);
		loups.add(e);
		loups.add(f);
		loups.add(g);
		loups.add(h);
		loups.add(i);
		loups.add(o);
		String cri_de_la_meute = "HOUHOUHOHUOHUOHU";
		Couple_alpha couple_meute = new Couple_alpha(a, b);
		Meute m = new Meute(couple_meute, loups, cri_de_la_meute);
		Colonie_loups colonie_loups = new Colonie_loups();

		colonie_loups.ajouter_meute(m);
		zoo.changer_colonie_de_loups_du_zoo(colonie_loups);

		System.out.println("\n");
		System.out.println("Chargement terminee !");
		System.out.println("\n");

		// Debut Simulation

		zoo.controller_employe();

	}
}
