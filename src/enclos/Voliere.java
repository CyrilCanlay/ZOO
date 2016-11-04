package enclos;

public class Voliere extends Enclos {

	public Voliere(String nom, int superficie, int nombre_maximum_animaux) {
		super(nom, superficie, nombre_maximum_animaux);
		// TODO Auto-generated constructor stub
	}

	int hauteur;

	@Override
	public void entretenir() {
		if (this.degree_proprete < 2 && animaux_present.size() == 0) {
			degree_proprete = 2;
		}
	}

}
