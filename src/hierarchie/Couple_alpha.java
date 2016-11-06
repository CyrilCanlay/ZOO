package hierarchie;

import animaux.Loup;
import autre.Autre;

public class Couple_alpha {
	Loup loup_male;
	Loup loup_femelle;

	public Couple_alpha(Loup loup_male, Loup loup_femelle) {
		this.loup_male = loup_male;
		this.loup_femelle = loup_femelle;
	}

	public void afficher_caracteristiques() {
		System.out.println("Couple [loup_male=" + loup_male + ", loup_femelle=" + loup_femelle + "]");
	}

	public void realiser_une_reproduction() {
		if (loup_male.recuperer_zoo_de_l_animal().recuperer_mois_courrant() == 0
				|| loup_male.recuperer_zoo_de_l_animal().recuperer_mois_courrant() == 1
				|| loup_male.recuperer_zoo_de_l_animal().recuperer_mois_courrant() == 2
				|| loup_male.recuperer_zoo_de_l_animal().recuperer_mois_courrant() == 11) {
			int nombre_enfants = Autre.nombre_aleatoire_borne(1, 7);
			for (int i = 1; i < nombre_enfants; i++) {
				loup_femelle.mettre_bas();
			}
		}
		System.out.println("ce n est pas la bonne saison");
	}

	public void changer_loup_male(Loup loup_male) {
		this.loup_male = loup_male;
	}

	public void changer_loup_femelle(Loup loup_femelle) {
		this.loup_femelle = loup_femelle;
	}

}
