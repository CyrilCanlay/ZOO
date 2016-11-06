package autre;

import java.util.ArrayList;

import animaux_abstrait.Animal;
import enclos.Enclos;
import enclos.EnclosStandard;
import hierarchie.Colonie_loups;

public class Zoo {

	final static int MAX_ACTIONS = 20;

	final static String MOIS[] = { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre",
			"Octobre", "Novembre", "Decembre" };

	private String nom;
	private Employe employe;
	private int maximal_enclos;
	private ArrayList<Enclos> enclos_existants = new ArrayList<>();

	private Colonie_loups colonie_de_loups_du_zoo;
	static private int mois_courrant;

	public static int recuperer_mois_courrant() {
		return mois_courrant;
	}

	public static void changer_mois_courrant(int mois_courrant) {
		Zoo.mois_courrant = mois_courrant;
	}

	public ArrayList<Enclos> recuperer_enclos_existants() {
		return enclos_existants;
	}

	@Override
	public String toString() {

		return "Zoo [nom=" + nom + ", employe=" + employe + ", maximal_enclos=" + maximal_enclos
				+ ", colonie_de_loups_du_zoo=" + colonie_de_loups_du_zoo + ", mois=" + MOIS[mois_courrant] + "]";
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
				int chance_dormir = Autre.nombre_aleatoire_borne(1, 2);
				Animal animal_en_question = enclos_existants.get(i).recuperer_animaux_present().get(j);
				if (chance_dormir == 2) {
					animal_en_question.changer_sommeil(true);
				} else {
					animal_en_question.changer_sommeil(false);
				}
				int chance_malade = Autre.nombre_aleatoire_borne(1, 10);
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
			int chance_salir = Autre.nombre_aleatoire_borne(1, 4);
			if (chance_salir == 1) {
				enclos_en_question.salir();
			}
		}
	}

	public void controller_employe() {
		while (true) {
			int actions_restantes = MAX_ACTIONS;
			while (actions_restantes > 0) {

				System.out.println("Nombre d actions restantes : " + actions_restantes);
				System.out.println("Choisisez l action que vous voulez effectue : ");
				System.out.println();
				System.out.println("Menu Autre");
				System.out.println("0 = quitter");
				System.out.println("1 = afficher zoo");
				System.out.println("2 = examiner un enclos");
				System.out.println("6 = attendre un mois");
				System.out.println("7 = attendre une annee");
				System.out.println();
				System.out.println("Menu Actions");
				System.out.println("3 = nettoyer un enclos");
				System.out.println("4 = nourrir un enclos");
				System.out.println("5 = transferer animal");

				System.out.println();

				int choix = Autre.lire_clavier.nextInt();

				switch (choix) {

				case 0:
					Thread.currentThread().interrupt();
					return;

				case 1:
					afficher_zoo_complet();
					break;

				case 2:
					afficher_noms_enclos();
					System.out.println("Veuillez entrer le nom de l enclos que vous voulez examiner : ");
					employe.examiner_enclos(selectionner_enclos_par_nom_au_clavier());
					break;

				case 3:
					afficher_noms_enclos();
					System.out.println("Veuillez entrer le nom de l enclos que vous voulez nettoyer : ");
					employe.nettoyer_enclos(selectionner_enclos_par_nom_au_clavier());
					actions_restantes--;
					break;

				case 4:
					afficher_noms_enclos();
					System.out.println("Veuillez entrer le nom de l enclos que vous voulez nourrir : ");
					employe.nourrir_animaux_enclos(selectionner_enclos_par_nom_au_clavier());
					actions_restantes--;
					break;

				case 5:
					afficher_noms_animaux();
					System.out.println("Veuillez entrer le nom de l animal qui etre transferer : ");
					Animal pov_bete = selectionner_animal_par_nom_au_clavier();
					afficher_noms_enclos_disponible_pour_animal(pov_bete);
					System.out.println("Veuillez entrer le nom de l enclos qui va recevoir l'animal : ");
					Enclos enclos_destinataire = selectionner_enclos_par_nom_au_clavier();
					employe.transferer_animal(pov_bete.recuperer_enclos_de_l_animal(), enclos_destinataire, pov_bete);
					actions_restantes--;
					break;

				case 6:
					passer_un_mois();
					actions_restantes = MAX_ACTIONS;

				case 7:
					passer_une_annee();
					actions_restantes = MAX_ACTIONS;

				default:
					System.out.println("-----");
					break;
				}
			}
			passer_un_mois();
		}
	}

	public void passer_un_mois() {
		modifier_aleatoirement_etat_enclos();
		modifier_aleatoirement_etat_animaux();
		mois_courrant++;
		if (mois_courrant == 11) {
			mois_courrant = 0;
			passer_une_annee();
		}
	}

	public void passer_une_annee() {
		for (int i = 0; i < MOIS.length; i++) {
			modifier_aleatoirement_etat_enclos();
			modifier_aleatoirement_etat_animaux();
		}
		faire_viellir_le_zoo();
	}

	public void faire_viellir_le_zoo() {
		this.employe.viellir();
		for (Enclos enclos : enclos_existants) {
			for (Animal animal : enclos.recuperer_animaux_present()) {
				animal.vieillir();
			}
		}
	}

	public Enclos selectionner_enclos_par_nom_au_clavier() {
		Enclos enclos_en_question = null;
		while (null == enclos_en_question) {
			String nom_rechercher = Autre.lire_clavier.next();
			enclos_en_question = rechercher_enclos_par_nom(nom_rechercher);
		}
		return enclos_en_question;

	}

	public Animal selectionner_animal_par_nom_au_clavier() {
		String nom_rechercher = Autre.lire_clavier.next();
		Animal animal_en_question = rechercher_animal_par_nom(nom_rechercher);
		return animal_en_question;
	}

	public void afficher_noms_enclos() {
		System.out.println("Liste des enclos disponibles : ");
		for (Enclos enclos : this.enclos_existants) {
			System.out.println(enclos.recuperer_nom());
		}
	}

	private void afficher_noms_enclos_disponible_pour_animal(Animal animal) {
		System.out.println("Liste des enclos disponibles : ");
		for (Enclos enclos : this.enclos_existants) {
			if (enclos.verification_transfert_animaux(animal)) {
				System.out.println(enclos.recuperer_nom());
			}
		}
	}

	public void afficher_noms_animaux() {
		System.out.println("Liste des animaux du zoo : ");
		for (Enclos enclos : this.enclos_existants) {
			for (Animal animal : enclos.recuperer_animaux_present()) {
				System.out.println(animal.recuperer_nom());
			}
		}
	}

	public Enclos rechercher_enclos_par_nom(String nom_rechercher) {
		for (Enclos enclos : this.enclos_existants) {
			if (enclos.recuperer_nom().equals(nom_rechercher)) {
				return enclos;
			}
		}
		System.out.println("ERREUR : Enclos " + nom_rechercher + " n existe pas, reesayez !");
		return null;
	}

	public Animal rechercher_animal_par_nom(String nom_rechercher) {
		for (Enclos enclos : this.enclos_existants) {
			for (Animal animal : enclos.recuperer_animaux_present())
				if (animal.recuperer_nom().equals(nom_rechercher)) {
					return animal;
				}
		}
		System.out.println("ERREUR : L animal " + nom_rechercher + "  n existe pas, reesayez ! ");
		return null;
	}

	public Zoo(String nom, Employe employe, int maximal_enclos) {
		this.nom = nom;
		this.employe = employe;
		this.maximal_enclos = maximal_enclos;
	}

}
