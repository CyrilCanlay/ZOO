package autre;

import java.util.ArrayList;

import animaux_abstrait.Animal;
import enclos.Enclos;
import enclos.EnclosStandard;
import hierarchie.Colonie_loups;

public class Zoo {
	private String nom;
	private Employe employe;
	private int maximal_enclos;
	private ArrayList<Enclos> enclos_existants = new ArrayList<>();

	private Colonie_loups colonie_de_loups_du_zoo;

	public ArrayList<Enclos> recuperer_enclos_existants() {
		return enclos_existants;
	}

	@Override
	public String toString() {
		return "Zoo [\n nom=" + nom + ", \n employe=" + employe + ", \n maximal_enclos=" + maximal_enclos
				+ ", \n enclos_existants=" + recuperer_enclos_existants().size() + "]";
	}

	public void afficher_zoo_complet() {
		System.out.println();
		System.out.println("----- Affichage Zoo -----");
		System.out.println();
		System.out.println(this.toString());

		for (Enclos enclos : enclos_existants) {
			System.out.println(enclos.toString());
			for (Animal animaux : enclos.recuperer_animaux_present()) {
				System.out.println(animaux.toString());
			}
		}
	}

	public ArrayList<Object> recuperer_appartenaces_animal(Animal animal_recherche) {
		ArrayList<Object> informations = new ArrayList<Object>();
		// 0 = Zoo
		// 1 = Enclos
		// 2 = Meute

		for (int i = 0; i < enclos_existants.size(); i++) {
			for (int j = 0; j < enclos_existants.get(i).recuperer_nombre_animaux_present(); j++) {
				if (enclos_existants.get(i).recuperer_animaux_present().get(j).equals(animal_recherche)) {

					informations.add(this);
					informations.add(enclos_existants.get(i));

					if (enclos_existants.get(i).getClass().equals("class enclos.EnclosStandard")) {
						EnclosStandard standard = (EnclosStandard) enclos_existants.get(i);
						informations.add(standard.recuperer_meute_de_l_enclos());
					}
				}
			}
		}
		return informations;

	}

	public void afficher_nombre_animaux() {
		int result = 0;
		for (int i = 0; i < enclos_existants.size(); i++) {
			result = result + enclos_existants.get(i).recuperer_nombre_animaux_present();
		}
		System.out.println("Le nombre d'animaux du zoo " + this.nom + " est de : " + (result + 1));
	}

	public void ajouter_enclos(Enclos e) {
		if (enclos_existants.size() < maximal_enclos) {
			enclos_existants.add(e);
		}
	}

	public void setMaximal_enclos(int maximal_enclos) {
		this.maximal_enclos = maximal_enclos;
	}

	public void modifier_aleatoirement_etat_animaux() {
		for (int i = 0; i < enclos_existants.size(); i++) {
			for (int j = 0; j < enclos_existants.get(i).recuperer_nombre_animaux_present(); j++) {
				int chance_dormir = Calcul.nombre_aleatoire_borne(1, 2);
				Animal animal_en_question = enclos_existants.get(i).recuperer_animaux_present().get(j);
				if (chance_dormir == 2) {
					animal_en_question.changer_sommeil(true);
				} else {
					animal_en_question.changer_sommeil(false);
				}
				int chance_malade = Calcul.nombre_aleatoire_borne(1, 10);
				if (chance_malade == 1) {
					animal_en_question.changer_sante(1);
				}
				if (chance_malade == 2) {
					if (animal_en_question.recuperer_sante() == 1) {
						animal_en_question.changer_sante(0);
					}
				} else {
					if (animal_en_question.recuperer_sante() == 1) {
						animal_en_question.etre_soigne();
					}
				}

			}
		}
	}

	public void modifier_aleatoirement_etat_enclos() {
		for (int i = 0; i < enclos_existants.size(); i++) {
			Enclos enclos_en_question = enclos_existants.get(i);
			int chance_salir = Calcul.nombre_aleatoire_borne(1, 4);
			if (chance_salir == 1) {
				enclos_en_question.salir();
			}
		}
	}

	public void controller_enploye() {

		while (true) {
			System.out.println("0 = quitter" + "\n" + "1 = afficher zoo");
			int choix = Calcul.lire_clavier.nextInt();

			switch (choix) {

			case 0:
				Thread.currentThread().interrupt();
				return;

			case 1:
				afficher_zoo_complet();
				break;

			default:
				System.out.println("Mauvais choix réessayer.");

			}
		}
	}

	public Zoo(String nom, Employe employe, int maximal_enclos) {
		this.nom = nom;
		this.employe = employe;
		this.maximal_enclos = maximal_enclos;
	}

}
