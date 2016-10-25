package animaux_abstrait;

public abstract class Animal {
	private String nom_espece;
	private boolean femelle; // M = 0 F = 1
	private int poids;
	private int taille;
	private int age;
	private boolean indicateur_de_faim;
	private boolean indicateur_de_sommeil;
	private int indicateur_de_sante;

	public void manger() {
		if (this.indicateur_de_sommeil == false) {
			System.out.println("je mange");
			System.out.println("j'ai fini de manger");
		}
	}

	public boolean isIndicateur_de_faim() {
		return indicateur_de_faim;
	}

	public void setIndicateur_de_faim(boolean indicateur_de_faim) {
		this.indicateur_de_faim = indicateur_de_faim;
	}

	public void emettre_un_son() {

	}

	public void etre_soigne() {

	}

	public void s_endormir() {

	}

	public void se_reveiller() {

	}

	@Override
	public String toString() {
		return "Animal [nom_espece=" + nom_espece + ", femelle=" + femelle + ", poids=" + poids + ", taille=" + taille
				+ ", age=" + age + ", indicateur_de_faim=" + indicateur_de_faim + ", indicateur_de_sommeil="
				+ indicateur_de_sommeil + ", indicateur_de_santé=" + indicateur_de_sante + "]";
	}

	public boolean estUneFemelle() {
		return femelle;
	}

	public Animal() {
		String result = this.getClass().toString();
		result = result.substring(6).toString();
		this.nom_espece = result;
	}

}