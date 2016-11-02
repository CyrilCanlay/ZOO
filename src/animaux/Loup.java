package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;
import autre.Meute;

public class Loup extends Mammifere implements Terrestre {

	int force;
	int domination;
	int rang;
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
}
