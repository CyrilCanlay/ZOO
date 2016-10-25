import java.util.ArrayList;

import enclos.Enclos;

public class Zoo {
	String nom;
	Employe employe;
	int maximal_enclos;
	ArrayList<Enclos> enclos_existants = new ArrayList<>();

	public void afficher_nombre_animaux() {
		int result = 0;
		for (int i = 0; i < enclos_existants.size(); i++) {
			result = result + enclos_existants.get(i).recuperer_nombre_animaux_present();
		}
		System.out.println(result);
	}

	public void ajouter_enclos(Enclos e) {
		if (enclos_existants.size() < maximal_enclos) {
			enclos_existants.add(e);
		}
	}

	public void setMaximal_enclos(int maximal_enclos) {
		this.maximal_enclos = maximal_enclos;
	}
}
