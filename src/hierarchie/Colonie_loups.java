package hierarchie;

import java.util.ArrayList;

import animaux.Loup;
import autre.Autre;
import enclos.EnclosStandard;

public class Colonie_loups {

	final static int POURCENTAGE_CHANCE_HURLEMENT = 25;

	ArrayList<Meute> meutes_de_la_colonie;

	public void afficher_tout_les_loups_de_la_colonie() {
		for (Meute meute : meutes_de_la_colonie) {
			meute.afficher_caracteristiques_loup_meute();
		}
	}

	public void determiner_nouvelle_meute() {
		for (Meute meute : meutes_de_la_colonie) {
			if (meute.recuperer_nombre_loups() == 2) {
				Loup potenciel_alpha_1 = meute.recuperer_loups_meute().get(0);
				Loup potenciel_alpha_2 = meute.recuperer_loups_meute().get(1);
				EnclosStandard potenciel_enclos_futur_meute = (EnclosStandard) potenciel_alpha_1
						.recuperer_enclos_de_l_animal();
				if (potenciel_enclos_futur_meute.recuperer_meute_de_l_enclos().equals(null)) {
					if (!potenciel_alpha_1.est_une_femelle() && potenciel_alpha_2.est_une_femelle()) {
						creee_nouvelle_meute(potenciel_alpha_1, potenciel_alpha_2, potenciel_enclos_futur_meute);
					}
					if (potenciel_alpha_1.est_une_femelle() && !potenciel_alpha_2.est_une_femelle()) {
						creee_nouvelle_meute(potenciel_alpha_1, potenciel_alpha_2, potenciel_enclos_futur_meute);
					}
				}
			}
		}
	}

	private void creee_nouvelle_meute(Loup futur_alpha_1, Loup futur_alpha_2,
			EnclosStandard potenciel_enclos_futur_meute) {
		Couple_alpha nouveau_couple = new Couple_alpha(null, null);
		if (futur_alpha_1.est_une_femelle()) {
			nouveau_couple.changer_loup_femelle(futur_alpha_1);
			nouveau_couple.changer_loup_male(futur_alpha_2);
		} else {
			nouveau_couple.changer_loup_femelle(futur_alpha_2);
			nouveau_couple.changer_loup_male(futur_alpha_1);
		}

		String cri = futur_alpha_1.recuperer_nom().toString() + futur_alpha_2.recuperer_nom().toString();
		Meute nouvelle_meute = new Meute(nouveau_couple, new ArrayList<Loup>(), cri);
		potenciel_enclos_futur_meute.changer_meute_de_l_enclos(nouvelle_meute);
		futur_alpha_1.changer_rang(1);
		futur_alpha_1.changer_meute(nouvelle_meute);
		futur_alpha_2.changer_rang(1);
		futur_alpha_2.changer_meute(nouvelle_meute);

	}

	public void determiner_saison_des_amours_et_reproduction() {
		// TODO
	}

	public void evoluer_naturellement_hierarchie_meutes() {
		// TODO
	}

	public void generer_hurlements_aleatoires() {
		for (Meute meute : meutes_de_la_colonie) {
			for (Loup loup : meute.recuperer_loups_meute()) {
				int chance = Autre.nombre_aleatoire_borne(POURCENTAGE_CHANCE_HURLEMENT, 100);
				if (chance < POURCENTAGE_CHANCE_HURLEMENT) {
					loup.hurlement_appartenance();
				}
			}
		}

	}
}
