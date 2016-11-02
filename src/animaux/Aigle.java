package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Terrestre;
import animaux_interfaces.Volant;

public class Aigle extends Autre implements Terrestre, Volant {

	@Override
	public void pondre() {
		if (est_une_femelle()) {
			System.out.println("c'est pâques voila un oeuf");
		}
	}

	@Override
	public void emettre_un_son() {
		System.out.println("glatit");
	}

}
