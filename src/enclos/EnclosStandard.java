package enclos;

import animaux_abstrait.Animal;
import hierarchie.Meute;

public class EnclosStandard extends Enclos {

	Meute meute_de_l_enclos;

	public Meute recuperer_meute_de_l_enclos() {
		return meute_de_l_enclos;
	}

	@Override
	public void ajouter_animaux(Animal futur_prisonier) {
		boolean est_accepte = false;

		for (int i = 0; i < futur_prisonier.getClass().getInterfaces().length; i++) {
			if (futur_prisonier.getClass().getInterfaces()[i].toString()
					.equals("interface animaux_interfaces.Terrestre")) {
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
