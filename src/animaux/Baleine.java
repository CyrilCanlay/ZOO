package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Marin;

public class Baleine extends Mammifere implements Marin {

	@Override
	public void mettre_bas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emettre_un_son() {
		System.out.println("chante");

	}

}
