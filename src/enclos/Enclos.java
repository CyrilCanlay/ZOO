package enclos;

import java.util.ArrayList;

import animaux_abstrait.Animal;

public abstract class Enclos {
	private String nom;
	private int superficie;
	private int nombre_maximum_animaux;
	private int nombre_animaux_present;
	protected ArrayList<Animal> animaux_present = new ArrayList<Animal>();
	protected int degree_proprete; // 0 mauvais / 1 correct / 2 bon

	public ArrayList<Animal> selectionner_animaux_present() {
		return animaux_present;
	}

	public void afficher_caracteristiques_animaux_contenu() {
		for (int i = 0; i < animaux_present.size(); i++) {
			System.out.println(animaux_present.get(i).toString());
		}
	}

	public abstract void ajouter_animaux(Animal animal);

	public void enlever_animaux(Animal o) {
		animaux_present.remove(o);
	}

	public void enlever_animaux(int i) {
		animaux_present.remove(i);
	}

	public void nourrir_animaux() {
		for (int i = 0; i < animaux_present.size(); i++) {
			if (animaux_present.get(i).recuperer_faim()) {
				animaux_present.get(i).changer_faim(true);
			}
		}
	}

	public int recuperer_nombre_animaux_present() {
		return animaux_present.size();
	}

	public abstract void entretenir();

	public void salir() {
		if (degree_proprete > 0)
			degree_proprete = degree_proprete - 1;
	}

}
