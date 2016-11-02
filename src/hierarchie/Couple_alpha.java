package hierarchie;

import animaux.Loup;

public class Couple_alpha {
	Loup loup_male;
	Loup loup_femelle;

	public void afficher_caracteristiques() {
		System.out.println("Couple [loup_male=" + loup_male + ", loup_femelle=" + loup_femelle + "]");
	}

	public void realiser_une_reproduction() {
		// TODO entre decembre et mars 1 a 7 enfants
	}

	public void changer_loup_male(Loup loup_male) {
		this.loup_male = loup_male;
	}

	public void changer_loup_femelle(Loup loup_femelle) {
		this.loup_femelle = loup_femelle;
	}

}
