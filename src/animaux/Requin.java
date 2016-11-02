package animaux;

import animaux_abstrait.Autre;
import animaux_interfaces.Marin;

public class Requin extends Autre implements Marin {

	@Override
	public void pondre() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emettre_un_son() {
		System.out.println("...");

	}

}
