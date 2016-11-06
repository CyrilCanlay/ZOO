package animaux;

import java.util.ArrayList;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Autre;
import autre.Zoo;
import enclos.Enclos;
import hierarchie.Meute;

public class Loup extends Mammifere implements Terrestre {
	final static int AGE_MAXIMUM = 18;

	final static int TAILLE_MINIMUM_NAISSANCE_LOUP = 250; // milimettres
	final static int TAILLE_MAXIMUM_NAISSANCE_LOUP = 450; // milimettres

	final static int POIDS_MINIMUM_NAISSANCE_LOUP = 400; // grammes
	final static int POIDS_MAXIMUM_NAISSANCE_LOUP = 600; // grammes

	public Loup(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal, int force, int domination, int rang, int niveau, int impetuosite,
			Meute meute_du_loup) {
		super(nom, femelle, poids, taille, age, zoo_de_l_animal, enclos_de_l_animal);
		this.force = force;
		this.domination = domination;
		this.rang = rang;
		this.niveau = niveau;
		this.impetuosite = impetuosite;
		this.meute_du_loup = meute_du_loup;
		selectionner_age_maximum(AGE_MAXIMUM);

	}

	int force;
	int domination;
	int rang;
	// 1 = alpha
	// 2 = beta
	// 3 = gamma
	// 4 = omega
	// 0 = solitaire
	int niveau;
	int impetuosite;

	Meute meute_du_loup;

	public void actualiser_meute_animal(Zoo zoo_du_loup) {
		ArrayList<?> inforamtions_loup = zoo_du_loup.recuperer_appartenaces_animal(this);
		meute_du_loup = (Meute) inforamtions_loup.get(2);
	}

	@Override
	public void mettre_bas() {
		System.out.println("Entrez le nom de l'enfant");
		String nom_naissance = Autre.lire_clavier.next();

		boolean femelle_naissance;
		int random_femelle_naissance = Autre.nombre_aleatoire_borne(0, 1);
		if (random_femelle_naissance == 1) {
			femelle_naissance = true;
		} else {
			femelle_naissance = false;
		}

		int poids_naissance = Autre.nombre_aleatoire_borne(POIDS_MINIMUM_NAISSANCE_LOUP, POIDS_MAXIMUM_NAISSANCE_LOUP);

		int taille_naissance = Autre.nombre_aleatoire_borne(TAILLE_MINIMUM_NAISSANCE_LOUP,
				TAILLE_MAXIMUM_NAISSANCE_LOUP);

		int rang_enfant = 2;
		for (Loup loups_meute : meute_du_loup.recuperer_loups_meute()) {
			if (loups_meute.recuperer_rang() == 2) {
				rang_enfant = 3;
				break;
			}
		}

		this.recuperer_enclos_de_l_animal()
				.ajouter_animaux_securise(new Loup(nom_naissance, femelle_naissance, poids_naissance, taille_naissance,
						0, this.recuperer_zoo_de_l_animal(), this.recuperer_enclos_de_l_animal(), 0, 0, rang_enfant, 0,
						0, this.meute_du_loup));
	}

	@Override
	public String toString() {
		String a = "Animal [nom=" + recuperer_nom() + ", femelle=" + est_une_femelle() + ", poids=" + recuperer_poids()
				+ ", taille=" + recuperer_taille() + ", age=" + recuperer_age() + ", faim=" + recuperer_faim()
				+ ", sommeil=" + recuperer_sommeil() + ", sante=" + recuperer_sante() + "]";
		String b = " Details [force=" + force + ", domination=" + domination + ", rang=" + rang + ", niveau=" + niveau
				+ ", impetuosite=" + impetuosite + ", meute_du_loup=" + meute_du_loup + "]";
		return a + b;
	}

	@Override
	public void emettre_un_son() {
		System.out.println(this + " hurle !");
	}

	public void hurlement_appartenance() {
		System.out.println(this.recuperer_nom() + " fais son cri de meute : " + meute_du_loup.recuperer_cri_de_meute());

		// Reponse de la meute
		ArrayList<Loup> loups_de_la_meute_du_loup = meute_du_loup.recuperer_loups_meute();
		for (int i = 0; i < loups_de_la_meute_du_loup.size(); i++) {
			if (!loups_de_la_meute_du_loup.get(i).equals(this)) {
				loups_de_la_meute_du_loup.get(i).hurlement_meute();
			}
		}

		// Reponse des autres meutes

		// On recupere les enclos du zoo et on enleve l'enclos de this de la
		// selection
		ArrayList<Enclos> enclos_meute_adverses = this.recuperer_zoo_de_l_animal().recuperer_enclos_existants();
		for (int i = 0; i < enclos_meute_adverses.size(); i++) {
			if (enclos_meute_adverses.get(i).equals(this.recuperer_enclos_de_l_animal())) {
				enclos_meute_adverses.remove(i);
			}
		}

		// on fais hurler le cri de meute des autres loups
		for (int i = 0; i < enclos_meute_adverses.size(); i++) {
			for (int j = 0; j < enclos_meute_adverses.get(i).recuperer_nombre_animaux_present(); j++) {
				if (enclos_meute_adverses.get(i).recuperer_animaux_present().get(j).getClass()
						.equals("class animaux.Loup")) {
					Loup loup_adverse_qui_va_repondre = (Loup) enclos_meute_adverses.get(i).recuperer_animaux_present()
							.get(j);
					loup_adverse_qui_va_repondre.hurlement_meute();
				}
			}
		}

	}

	public void hurlement_meute() {
		System.out.println(this + " fais le hurlement de la meute " + meute_du_loup.recuperer_cri_de_meute());
	}

	public void hurlement_domination(Loup destinataire) {
		System.out.println(this + " fais un hurlement dominant envers " + destinataire);
	}

	public void hurlement_soumission(Loup destinataire) {
		System.out.println(this + " fais un hurlement soumis envers " + destinataire);
	}

	public void hurlement_agressivite(Loup destinataire) {
		System.out.println(this + " fais un hurlement aggressif envers " + destinataire);
	}

	public boolean entendre_hurlement() {
		if (recuperer_sante() == 2 && recuperer_sommeil() == false) {
			return true;
		}
		return false;
	}

	public int recuperer_rang_en_dessous() {
		if (this.rang == 4)
			return 4;

		boolean presence_loups_rangs[] = { false, false, false, false, false };
		for (Loup loup : meute_du_loup.recuperer_loups_meute()) {
			presence_loups_rangs[loup.recuperer_rang()] = true;
		}

		for (int i = 1; i < presence_loups_rangs.length; i++) {
			if (presence_loups_rangs[this.rang + i] == true) {
				return this.rang + i;
			}
		}
		System.out.println("Rang en dessous non recuperer");
		return this.rang;

	}

	public void dominer(Loup adversaire) {
		if (adversaire.rang != 1 && !adversaire.est_une_femelle())
			if (impetuosite >= adversaire.impetuosite) {
				if (force > adversaire.force || adversaire.rang == 4) {
					System.out.println("Victoire");

					// Echange les rangs
					int rang_temporaire = rang;
					rang = adversaire.rang;
					adversaire.rang = rang_temporaire;

					// gestion des points de domination
					domination = domination + 1;
					adversaire.domination = adversaire.domination - 1;
					if (adversaire.domination < -5) {

					}
				} else {
					System.out.println("Defaite");
				}
			} else {
				System.out.println("Domination impossible");
			}
	}

	public int recuperer_force() {
		return force;
	}

	public int recuperer_rang() {
		return rang;
	}

	public void changer_rang(int rang) {
		if (0 <= rang && rang <= 4) {
			this.rang = rang;
		} else {
			System.out.println("ERREUR : rang de domination inconnu");
		}
	}

	public void changer_meute(Meute futur_meute) {
		this.meute_du_loup = futur_meute;
	}

	public void devenir_solitaire() {
		rang = 0;
		meute_du_loup = null;
	}
}
