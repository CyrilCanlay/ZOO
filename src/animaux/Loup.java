package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Calcul;
import hierarchie.Meute;

public class Loup extends Mammifere implements Terrestre {

	int force;
	int domination;
	int rang; // 1 a 24 (1 est le plus élévé) (chiffre = lettre grec)
	int niveau;
	int impetuosite;

	Meute meute_du_loup;

	@Override
	public void mettre_bas() {
		// TODO
	}

	@Override
	public String toString() {
		String a = "Animal [nom_espece=" + "Loup" + ", femelle=" + est_une_femelle() + ", poids=" + recuperer_poids()
				+ ", taille=" + recuperer_taille() + ", age=" + recuperer_age() + ", indicateur_de_faim="
				+ recuperer_faim() + ", indicateur_de_sommeil=" + recuperer_sommeil() + ", indicateur_de_sante="
				+ recuperer_sante() + "]";
		String b = "Loup [force=" + force + ", domination=" + domination + ", rang="
				+ Calcul.recuperer_alphabet_grec(rang) + ", niveau=" + niveau + ", impetuosite=" + impetuosite + "]";
		return a + b;
	}

	@Override
	public void emettre_un_son() {
		System.out.println(this + " hurle !");
	}

	public void hurlement_appartenance() {

		System.out.println(this + "fais son cri de meute");
	}

	public void hurlement_meute() {
		System.out.println(this + " fais le hurlement de la meute ");
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

	public void se_separer_de_sa_meute() {
		// TODO
	}

	public void vieillir() {
		if (recuperer_age() > 18) {
			changer_sante(0);
		}
		changer_age(recuperer_age() + 1);
	}

	public void dominer(Loup adversaire) {
		if (adversaire.rang != 1 && !adversaire.est_une_femelle())
			if (impetuosite >= adversaire.impetuosite) {
				if (force > adversaire.force || adversaire.rang == 24) {
					System.out.println("Victoire");

					// Echange les rangs
					int rang_temporaire = rang;
					rang = adversaire.rang;
					adversaire.rang = rang_temporaire;

					// gestion des points de domination
					domination = domination + 1;
					adversaire.domination = adversaire.domination - 1;
					if (adversaire.domination < -5) {
						// TODO
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
}
