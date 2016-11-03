package autre;

import animaux_abstrait.Animal;
import enclos.Enclos;

public class Employe {
	String nom;
	boolean femme;
	int âge;

	public Employe(String nom, boolean femme, int âge) {
		this.nom = nom;
		this.femme = femme;
		this.âge = âge;
	}

	public void examiner_enclos(Enclos enclos_en_question) {
		enclos_en_question.afficher_caracteristiques_animaux_contenu();
	}

	public void nettoyer_enclos(Enclos enclos_en_question) {
		enclos_en_question.entretenir();
	}

	public void nourrir_animaux_enclos(Enclos enclos_en_question) {
		enclos_en_question.nourrir_animaux();
	}

	public void transferer_animal(Enclos enclos_originel, Enclos enclos_ultime, Animal pov_bete) {
		if (enclos_ultime.ajouter_animaux_securise(pov_bete) == true) {
			enclos_ultime.ajouter_animaux_securise(pov_bete);
			enclos_originel.enlever_animaux(pov_bete);
		} else {
			System.out.println("ça se fait pas gros !");
		}
	}

	@Override
	public String toString() {
		return "Employe [\nnom=" + nom + ", \nfemme=" + femme + ", \nâge=" + âge + "]";
	}

}
