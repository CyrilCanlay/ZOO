package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Marin;

public class PoissonRouge extends Autre implements Marin {

	@Override
	public void pondre() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emettre_un_son() {
		System.out.println("...");

	}

}
