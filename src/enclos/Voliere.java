package enclos;

public class Voliere extends Enclos {

	int hauteur;

	public Voliere(String nom, int superficie, int nombre_maximum_animaux) {
		super(nom, superficie, nombre_maximum_animaux);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entretenir() {
		if (this.recuperer_degree_proprete() < 2 && this.recuperer_animaux_present().size() == 0) {
			this.changer_degree_proprete(2);
		}
	}

}
