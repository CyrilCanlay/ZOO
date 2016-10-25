
import animaux_abstrait.Animal;
import enclos.Enclos;

public class Employe {
	String nom;
	boolean sexe;
	int âge;

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
		if (enclos_originel.getClass().equals(enclos_ultime.getClass())) {
			enclos_originel.enlever_animaux(pov_bete);
			enclos_ultime.ajouter_animaux(pov_bete);
		} else {
			System.out.println("ça se fait pas gros !");
		}
	}
}
