package animaux;

import animaux_abstrait.Mammifere;
import animaux_interfaces.Terrestre;

public class Tigre extends Mammifere implements Terrestre {

	@Override
	public void mettre_bas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emettre_un_son() {
		System.out.println("râle");
	}

}
