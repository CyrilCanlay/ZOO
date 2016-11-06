package autre;

import java.util.ArrayList;

import animaux.Aigle;
import animaux.Baleine;
import animaux.Loup;
import animaux.Ours;
import animaux.Pingouin;
import animaux.PoissonRouge;
import animaux.Requin;
import animaux.Tigre;
import animaux_abstrait.Animal;
import enclos.Aquarium;
import enclos.Enclos;
import enclos.EnclosStandard;
import enclos.Voliere;
import hierarchie.Colonie_loups;

public class Zoo {

	final static int MAX_ACTIONS = 20;
	final static int POURCENTAGE_CHANCE_SALIR = 25;
	final static int POURCENTAGE_CHANCE_MALADIE = 10;
	final static int POURCENTAGE_CHANCE_DORMIR = 50;

	final static String MOIS[] = { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre",
			"Octobre", "Novembre", "Decembre" };

	private String nom;
	private Employe employe;
	private int maximal_enclos;
	private ArrayList<Enclos> enclos_existants = new ArrayList<>();

	private Colonie_loups colonie_de_loups_du_zoo;
	static private int mois_courrant;

	public Colonie_loups recuperer_colonie_de_loups_du_zoo() {
		return colonie_de_loups_du_zoo;
	}

	public void changer_colonie_de_loups_du_zoo(Colonie_loups colonie_de_loups_du_zoo) {
		this.colonie_de_loups_du_zoo = colonie_de_loups_du_zoo;
	}

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
				int chance_dormir = Autre.nombre_aleatoire_borne(0, 100);
				Animal animal_en_question = enclos_existants.get(i).recuperer_animaux_present().get(j);
				if (chance_dormir <= POURCENTAGE_CHANCE_DORMIR) {
					animal_en_question.changer_sommeil(true);
				} else {
					animal_en_question.changer_sommeil(false);
				}
				int chance_malade = Autre.nombre_aleatoire_borne(0, 100);
				if (chance_malade <= POURCENTAGE_CHANCE_MALADIE) {
					animal_en_question.changer_sante(1);
				}
				if (chance_malade <= POURCENTAGE_CHANCE_MALADIE) {
					if (animal_en_question.recuperer_sante() == 1) {
						animal_en_question.mourrir();
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
			int chance_salir = Autre.nombre_aleatoire_borne(0, 100);
			if (chance_salir <= POURCENTAGE_CHANCE_SALIR) {
				enclos_en_question.salir();
			}
		}
	}

	public void controller_employe() {
		while (true) {
			int actions_restantes = MAX_ACTIONS;
			while (actions_restantes > 0) {

				System.out.println("\n");
				System.out.println("Nombre d actions restantes : " + actions_restantes);
				System.out.println("Choisisez l action que vous voulez effectuee : ");
				System.out.println();
				System.out.println("Menu Autre");
				System.out.println("0 =	 quitter");
				System.out.println("1 = afficher zoo");
				System.out.println("2 = examiner un enclos");
				System.out.println("6 = attendre un mois");
				System.out.println("7 = attendre une annee");
				System.out.println("8 = examiner la colonie de loups");
				System.out.println("9 = ecouter hurlement loups");

				System.out.println();
				System.out.println("Menu Actions");
				System.out.println("3 = nettoyer un enclos");
				System.out.println("4 = nourrir un enclos");
				System.out.println("5 = transferer animal");
				System.out.println("10 = creer nouvel enclos");
				System.out.println("11 = ajouter nouvel animal");

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
					Enclos enclos_temp_netoyage = selectionner_enclos_par_nom_au_clavier();
					if (enclos_temp_netoyage.verification_nettoyage()) {
						employe.nettoyer_enclos(selectionner_enclos_par_nom_au_clavier());
						actions_restantes--;
					}
					break;

				case 4:
					afficher_noms_enclos();
					System.out.println("Veuillez entrer le nom de l enclos que vous voulez nourrir : ");
					Enclos enclos_temp = selectionner_enclos_par_nom_au_clavier();
					if (enclos_temp.verification_nourrir()) {
						employe.nourrir_animaux_enclos(enclos_temp);
						actions_restantes--;
					}
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
					break;

				case 7:
					for (int i = 0; i < MOIS.length; i++) {
						passer_un_mois();
					}
					actions_restantes = MAX_ACTIONS;
					break;

				case 8:
					colonie_de_loups_du_zoo.afficher_tout_les_loups_de_la_colonie();
					break;

				case 9:
					colonie_de_loups_du_zoo.generer_hurlements_aleatoires();
					break;

				case 10:
					System.out.println("1 pour un enclos standard");
					System.out.println("2 pour un aquarium");
					System.out.println("3 pour une voliere");
					int choix_type_enclos = Autre.lire_clavier.nextInt();

					String nom_enclos = null;
					boolean nom_deja_existant = true;
					while (nom_deja_existant) {
						System.out.println("nom enclos ?");
						nom_enclos = Autre.lire_clavier.next();
						for (Enclos enclos : enclos_existants) {
							if (enclos.recuperer_nom().equals(nom_enclos)) {
								nom_deja_existant = true;
							} else {
								nom_deja_existant = false;
							}
						}
					}

					System.out.println("superficie ?");
					int superficie = Autre.lire_clavier.nextInt();

					System.out.println("nombre_maximum_animaux ?");
					int nombre_maximum_animaux = Autre.lire_clavier.nextInt();

					if (choix_type_enclos == 1) {
						ajouter_enclos(new EnclosStandard(nom_enclos, superficie, nombre_maximum_animaux));
					}
					if (choix_type_enclos == 2) {
						ajouter_enclos(new Aquarium(nom_enclos, superficie, nombre_maximum_animaux));
					}
					if (choix_type_enclos == 3) {
						ajouter_enclos(new Voliere(nom, superficie, nombre_maximum_animaux));
					}
					break;

				case 11:
					assisant_ajout_animal();
					break;

				default:
					System.out.println("-----");
					break;
				}
			}
			passer_un_mois();
		}
	}

	public void assisant_ajout_animal() {
		System.out.println("choix 0 => Aigle");
		System.out.println("choix 1 => Baleine");
		System.out.println("choix 2 => Ours");
		System.out.println("choix 3 => Pingouin");
		System.out.println("choix 4 => PoissonRouge");
		System.out.println("choix 5 => Requin");
		System.out.println("choix 6 => Tigre");
		int choix = Autre.lire_clavier.nextInt();
		System.out.println("Choisir nom animal : ");
		String nom_animal = Autre.lire_clavier.next();

		System.out.println("est ce une femelle ? (repondre 0 ou 1)");
		boolean femelle = Autre.lire_clavier.hasNext();

		System.out.println("Choisir poids : ");
		int poids = Autre.lire_clavier.nextInt();

		System.out.println("Choisir taille : ");
		int taille = Autre.lire_clavier.nextInt();

		System.out.println("Choisir age : ");
		int age = Autre.lire_clavier.nextInt();

		Zoo zoo_de_l_animal = this;
		System.out.println("Choisir l enclos");

		Animal futur_animal = null;

		if (choix == 0) {
			futur_animal = new Aigle(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 1) {
			futur_animal = new Baleine(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 2) {
			futur_animal = new Ours(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 3) {
			futur_animal = new Pingouin(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 4) {
			futur_animal = new PoissonRouge(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 5) {
			futur_animal = new Requin(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}
		if (choix == 6) {
			futur_animal = new Tigre(nom_animal, femelle, poids, taille, age, zoo_de_l_animal, null);
		}

		afficher_noms_enclos_disponible_pour_animal(futur_animal);
		selectionner_enclos_par_nom_au_clavier().ajouter_animaux_securise(futur_animal);
	}

	public void passer_un_mois() {
		if (mois_courrant == 11) {
			passer_une_annee();
		} else {
			modifier_aleatoirement_etat_enclos();
			modifier_aleatoirement_etat_animaux();
			colonie_de_loups_du_zoo.determiner_nouvelle_meute();
			mois_courrant++;
			System.out.println("Nous sommes maintenant en " + MOIS[mois_courrant]);
		}
	}

	public void passer_une_annee() {
		mois_courrant = 0;
		System.out.println("Une annee viens de se passer");
		System.out.println("Nous sommes maintenant en " + MOIS[mois_courrant]);
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
