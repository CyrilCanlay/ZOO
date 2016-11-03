package animaux_abstrait;

import java.util.ArrayList;

import autre.Zoo;
import enclos.Enclos;

public abstract class Animal {

	private String nom;

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

	public Animal(String nom, boolean femelle, int poids, int taille, int age, Zoo zoo_de_l_animal,
			Enclos enclos_de_l_animal) {
		this.nom = nom;
		this.nom_espece = this.getClass().toString();
		this.femelle = femelle;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.indicateur_de_faim = false;
		this.indicateur_de_sommeil = false;
		this.indicateur_de_sante = 2;
		this.zoo_de_l_animal = zoo_de_l_animal;
		this.enclos_de_l_animal = enclos_de_l_animal;
	}

	private void actualiser_zoo_enclos_animal(Zoo zoo_du_loup) {
		ArrayList<?> inforamtions_loup = zoo_du_loup.recuperer_appartenaces_animal(this);
		zoo_de_l_animal = (Zoo) inforamtions_loup.get(0);
		enclos_de_l_animal = (Enclos) inforamtions_loup.get(1);
	}

	public void manger() {
		if (this.indicateur_de_sommeil == false) {
			System.out.println(this.nom + " est en train de manger");
			changer_faim(false);
			System.out.println("j'ai fini de manger");
		}
	}

	public boolean recuperer_faim() {
		return indicateur_de_faim;
	}

	public Zoo recuperer_zoo_de_l_animal() {
		return zoo_de_l_animal;
	}

	public Enclos recuperer_enclos_de_l_animal() {
		return enclos_de_l_animal;
	}

	public void changer_enclos_de_l_animal(Enclos futur_enclos) {
		this.enclos_de_l_animal = futur_enclos;
	}

	public void changer_faim(boolean indicateur_de_faim) {
		if (est_pas_mort())
			this.indicateur_de_faim = indicateur_de_faim;
	}

	public void changer_sommeil(boolean indicateur_de_sommeil) {
		if (recuperer_sante() != 0)
			this.indicateur_de_sommeil = indicateur_de_sommeil;
	}

	public void changer_sante(int indicateur_de_sante) {
		if (recuperer_sante() == 0) {
			this.indicateur_de_sante = indicateur_de_sante;
		}
	}

	public void changer_nom(String futur_nom) {
		if (this.nom.equals(null)) {
			this.nom = futur_nom;
		}
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

	@Override
	public String toString() {
		return "Animal [\nnom=" + nom + ", \nnom_espece=" + nom_espece + ", \nfemelle=" + femelle + ", \npoids=" + poids
				+ ", \ntaille=" + taille + ", \nage=" + age + ", \nindicateur_de_faim=" + indicateur_de_faim
				+ ", \nindicateur_de_sommeil=" + indicateur_de_sommeil + ", \nindicateur_de_sante="
				+ indicateur_de_sante + ", \nzoo_de_l_animal=" + zoo_de_l_animal + ", \nenclos_de_l_animal="
				+ enclos_de_l_animal + "]";
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

	public String recuperer_nom() {
		return nom;
	}

	private boolean est_pas_mort() {
		if (recuperer_sante() == 1 || recuperer_sante() == 2)
			return true;
		return false;
	}

	public boolean est_une_femelle() {
		return femelle;
	}
}