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

	public Enclos(String nom, int superficie, int nombre_maximum_animaux) {
		this.nom = nom;
		this.superficie = superficie;
		this.nombre_maximum_animaux = nombre_maximum_animaux;
		this.degree_proprete = 2;
	}

	public ArrayList<Animal> recuperer_animaux_present() {
		return animaux_present;
	}

	public void afficher_caracteristiques_animaux_contenu() {
		for (int i = 0; i < animaux_present.size(); i++) {
			System.out.println(animaux_present.get(i).toString());
		}
	}

	public void ajouter_animaux(Animal futur_prisonier) {

		// recuperation informations animal
		Class<?>[] mobilites = futur_prisonier.getClass().getInterfaces();
		String espece = futur_prisonier.getClass().getName();
		Class<?>[] mobilites_enclos = this.getClass().getInterfaces();

		if (animaux_present.size() != 0)
			for (int i = 0; i < animaux_present.size(); i++) {
				System.out.println(animaux_present.get(i).getClass().getName() + " --- " + espece);
				if (animaux_present.get(i).getClass().getName().equals(espece)) {
					animaux_present.add(futur_prisonier);
					nombre_animaux_present++;
					return;
				}
			}
		else {
			for (int j = 0; j < mobilites.length; j++) {
				for (int i = 0; i < mobilites_enclos.length; i++) {
					System.out.println("TEST");
					System.out.println(mobilites[i] + "--- " + (mobilites_enclos[j]));
					if (mobilites[i].equals(mobilites_enclos[j])) {
						animaux_present.add(futur_prisonier);
						nombre_animaux_present++;
						return;
					}
				}
			}
		}
		System.out.println("DEBUG : " + mobilites);
		System.out.println("DEBUG : " + espece);
		System.out.println("DEBUG : " + mobilites_enclos);

		System.out.println(futur_prisonier.recuperer_nom() + " ne peut pas aller dans " + nom);
	}

	public void enlever_animaux(Animal o) {
		animaux_present.remove(o);
		nombre_animaux_present--;
	}

	public void enlever_animaux(int i) {
		animaux_present.remove(i);
		nombre_animaux_present--;
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
