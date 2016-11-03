package hierarchie;

import java.util.ArrayList;

public class Colonie_loups {
	ArrayList<Meute> meutes_de_la_colonie;

	public void afficher_tout_les_loups_de_la_colonie() {
		for (Meute meute : meutes_de_la_colonie) {
			meute.afficher_caracteristiques_loup_meute();
		}
	}
}
