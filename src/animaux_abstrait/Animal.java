package animaux_abstrait;

import autre.Zoo;
import enclos.Enclos;

public abstract class Animal {
	private String nom_espece;
	private boolean femelle; // M = 0 F = 1
	private int poids;
	private int taille;
	private int age;
	private boolean indicateur_de_faim;
	private boolean indicateur_de_sommeil; // 1=dort 0=reveiller
	private int indicateur_de_sante; // 2=ok 1=malade 0=mort

	private Zoo zoo_de_l_animal;
	private Enclos enclos_de_l_animal;

	private void actualiser_zoo_enclos_animal() {

	}

	public void manger() {
		if (this.indicateur_de_sommeil == false) {
			System.out.println("je mange");
			System.out.println("j'ai fini de manger");
		}
	}

	public boolean recuperer_faim() {
		return indicateur_de_faim;
	}

	public void changer_faim(boolean indicateur_de_faim) {
		this.indicateur_de_faim = indicateur_de_faim;
	}

	public void changer_sommeil(boolean indicateur_de_sommeil) {
		this.indicateur_de_sommeil = indicateur_de_sommeil;
	}

	public void changer_sante(int indicateur_de_sante) {
		this.indicateur_de_sante = indicateur_de_sante;
	}

	public void changer_age(int age) {
		this.age = age;
	}

	public abstract void emettre_un_son();

	public void etre_soigne() {

	}

	public void s_endormir() {

	}

	public void se_reveiller() {

	}

	public String toString() {
		return "Animal [nom_espece=" + nom_espece + ", femelle=" + femelle + ", poids=" + poids + ", taille=" + taille
				+ ", age=" + age + ", indicateur_de_faim=" + indicateur_de_faim + ", indicateur_de_sommeil="
				+ indicateur_de_sommeil + ", indicateur_de_sante=" + indicateur_de_sante + "]";
	}

	public boolean est_une_femelle() {
		return femelle;
	}

	public int recuperer_sante() {
		return indicateur_de_sante;
	}

	public boolean recuperer_sommeil() {
		return indicateur_de_sommeil;
	}

	public int recuperer_poids() {
		return this.poids;
	}

	public int recuperer_taille() {
		return this.taille;
	}

	public int recuperer_age() {
		return age;
	}

	public Animal() {
		String result = this.getClass().toString();
		result = result.substring(6).toString();
		this.nom_espece = result;
	}

}