package autre;

import animaux_abstrait.Animal;
import enclos.Enclos;

public class Employe {

	private final static int AGE_MAXIMUM = 90;
	private String nom;
	private boolean femme;
	private int age;

	public Employe(String nom, boolean femme, int age) {
		this.nom = nom;
		this.femme = femme;
		this.age = age;
	}

	public void examiner_enclos(Enclos enclos_en_question) {
		enclos_en_question.afficher_caracteristiques_animaux_contenu();
	}

	public void nettoyer_enclos(Enclos enclos_en_question) {
		if (enclos_en_question.recuperer_nombre_animaux_vivant() == 0) {
			enclos_en_question.entretenir();
			System.out.println("Nettoyage accompli !");
			enclos_en_question.enlever_corps();
			System.out.println("Corps enleves !");
		} else {
			System.out.println("Nettoyage impossible, il reste encore "
					+ enclos_en_question.recuperer_nombre_animaux_vivant() + " animaux present dans la cage.");
		}
	}

	public void nourrir_animaux_enclos(Enclos enclos_en_question) {
		enclos_en_question.nourrir_animaux();
	}

	public void transferer_animal(Enclos enclos_originel, Enclos enclos_ultime, Animal pov_bete) {
		if (enclos_ultime.verification_transfert_animaux(pov_bete) == true) {
			enclos_ultime.ajouter_animaux_securise(pov_bete);
			enclos_originel.enlever_animaux(pov_bete);
		} else {
			System.out.println("ca se fait pas gros !");
		}
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", femme=" + femme + ", age=" + age + "]";
	}

	public void viellir() {
		age++;
		if (age > AGE_MAXIMUM) {
			// TODO
		}
	}

}
