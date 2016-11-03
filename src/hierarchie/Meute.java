package hierarchie;

import java.util.ArrayList;

import animaux.Loup;

public class Meute {
	Couple_alpha couple_meute;
	ArrayList<Loup> loups = new ArrayList<Loup>();
	String cri_de_la_meute;

	public void afficher_caracteristiques() {
		couple_meute.afficher_caracteristiques();
		afficher_caracteristiques_loup_meute();
	}

	public void afficher_caracteristiques_loup_meute() {
		for (int i = 0; i < loups.size(); i++) {
			System.out.println(loups.get(i).toString());
		}
	}

	public void creer_nouvelle_hierarchie_meute() {
		constituer_couple_alpha();
	}

	public void constituer_couple_alpha() {
		Loup potenciel_loup_alpha_femelle = null;
		Loup potenciel_loup_alpha_male = null;

		for (int i = 0; i < loups.size(); i++) {
			if (loups.get(i).est_une_femelle()) {
				if (potenciel_loup_alpha_femelle.equals(null)) {
					potenciel_loup_alpha_femelle = loups.get(i);
				}
				if (potenciel_loup_alpha_femelle.recuperer_force() < loups.get(i).recuperer_force()) {
					potenciel_loup_alpha_femelle = loups.get(i);
				}
			} else {
				if (potenciel_loup_alpha_male.equals(null)) {
					potenciel_loup_alpha_male = loups.get(i);
				}
				if (potenciel_loup_alpha_male.recuperer_force() < loups.get(i).recuperer_force()) {
					potenciel_loup_alpha_male = loups.get(i);
				}
			}
		}

		couple_meute.changer_loup_femelle(potenciel_loup_alpha_femelle);
		couple_meute.changer_loup_femelle(potenciel_loup_alpha_male);
	}

	public void reproduction_loups() {

	}

	public void decroitre_rangs_loups_naturellement() {

	}

	public void declarer_loups_omega() {

	}

	public void ajouter_loup_meute(Loup loup_a_ajouter) {
		loups.add(loup_a_ajouter);
	}

	public void enlvever_loup_meute(Loup loup_a_enlever) {
		loups.remove(loup_a_enlever);
	}

	public void enlvever_loup_meute(int i) {
		loups.remove(i);
	}

	public String recuperer_cri_de_meute() {
		return cri_de_la_meute;
	}

	public ArrayList<Loup> recuperer_loups_meute() {
		return loups;

	}

}
