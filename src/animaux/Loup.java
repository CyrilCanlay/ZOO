package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Meute;

public class Loup extends Mammifere implements Terrestre {

	int force;
	int domination;
	int rang; // 1 a 26 (1 est le plus élévé)
	int niveau;
	int impetuosite;
	Meute meute;

	@Override
	public void mettre_bas() {

	}

	@Override
	public String toString() {
		return "Loup [force=" + force + ", domination=" + domination + ", rang=" + rang + ", niveau=" + niveau
				+ ", impetuosite=" + impetuosite + ", meute=" + meute + "]";
	}

	@Override
	public void emettre_un_son() {
		System.out.println("hurle");
	}

	public boolean entendre_hurlement() {
		if (recuperer_sante() == 2 && recuperer_sommeil() == false) {
			return true;
		}
		return false;
	}

	public void se_separer_de_sa_meute() {

	}

	public void vieillir() {
		if (recuperer_age() > 18) {
			changer_sante(0);
		}
		changer_age(recuperer_age() + 1);
	}

	public void dominer(Loup adversaire) {
		if (impetuosite >= adversaire.impetuosite && adversaire.rang != 1 && !adversaire.est_une_femelle()) {
			if (force > adversaire.force || adversaire.rang == 24) {
				System.out.println("Victoire");
				int rang_temporaire = rang;
				rang = adversaire.rang;
				adversaire.rang = rang_temporaire;
				domination = domination + 1;
				adversaire.domination = adversaire.domination - 1;
			}
			System.out.println("Defaite");
		} else {
			System.out.println("Domination impossible");
		}
	}
}
