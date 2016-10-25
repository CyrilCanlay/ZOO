package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Marin;
import animaux_interfaces.Terrestre;
import animaux_interfaces.Volant;

public class Pingouin extends Autre implements Marin, Terrestre, Volant {

	@Override
	public void pondre() {

	}

}
