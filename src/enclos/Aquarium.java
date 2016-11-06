package enclos;

public class Aquarium extends Enclos {

	public Aquarium(String nom, int superficie, int nombre_maximum_animaux) {
		super(nom, superficie, nombre_maximum_animaux);
	}

	int profondeur_bassin;
	boolean salinite_eau; // 1 = bien salee et 0 = mal salee

	@Override
	public void entretenir() {
		if (recuperer_degree_proprete() < 2 && recuperer_animaux_present().size() == 0) {
			changer_degree_proprete(2);
		}
		if (salinite_eau == false) {
			salinite_eau = true; // <( °u°)
		}
	}
}
