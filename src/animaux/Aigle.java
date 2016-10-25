package animaux;
import animaux_abstrait.Autre;
import animaux_interfaces.Terrestre;
import animaux_interfaces.Volant;

public class Aigle extends Autre implements Terrestre, Volant {

	@Override
	public void pondre() {
		if (estUneFemelle()) {
			System.out.println("c'est pâques voila un oeuf");
		}
	}
}
