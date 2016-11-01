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

	public void afficher_ses_caractéristiques() {
		toString();
	}

}
