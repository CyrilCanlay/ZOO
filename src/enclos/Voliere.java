package enclos;

import animaux_abstrait.Animal;

public class Voliere extends Enclos {

	int hauteur;

	@Override
	public void ajouter_animaux(Animal futur_prisonier) {
		boolean est_accepte = false;

		for (int i = 0; i < futur_prisonier.getClass().getInterfaces().length; i++) {
			if (futur_prisonier.getClass().getInterfaces()[i].toString()
					.equals("interface animaux_interfaces.Volant")) {
				animaux_present.add(futur_prisonier);
				est_accepte = true;
			}
		}

		if (!est_accepte) {
			System.out.println("Cet animal ne peut pas aller dans la voliere");

		}
	}

	@Override
	public void entretenir() {
		if (this.degree_proprete < 2 && animaux_present.size() == 0) {
			degree_proprete = 2;
		}
	}

}
