package enclos;

import java.util.ArrayList;

import animaux_abstrait.Animal;

public abstract class Enclos {
	private String nom;
	private int superficie;
	private int nombre_maximum_animaux;
	private int nombre_animaux_present;
	private ArrayList<Animal> animaux_present = new ArrayList<Animal>();
	private int degree_proprete; // 0 mauvais / 1 correct / 2 bon

	public int recuperer_degree_proprete() {
		return degree_proprete;
	}

	public void changer_degree_proprete(int degree_proprete) {
		this.degree_proprete = degree_proprete;
	}

	public Enclos(String nom, int superficie, int nombre_maximum_animaux) {
		this.nom = nom;
		this.superficie = superficie;
		this.nombre_maximum_animaux = nombre_maximum_animaux;
		this.degree_proprete = 2;
	}

	public String recuperer_nom() {
		return nom;
	}

	public ArrayList<Animal> recuperer_animaux_present() {
		return animaux_present;
	}

	public void afficher_caracteristiques_animaux_contenu() {
		for (int i = 0; i < animaux_present.size(); i++) {
			System.out.println(animaux_present.get(i).toString());
		}
		if (animaux_present.size() == 0) {
			System.out.println(this.nom + " est vide");
		}
	}

	public void ajouter_animaux_securise(Animal futur_prisonier) {
		if (verification_transfert_animaux(futur_prisonier))
			ajouter_animaux(futur_prisonier);
		else {
			System.out.println(futur_prisonier.recuperer_nom() + " n as pas pu etre rajouter :(");
		}
	}

	public boolean verification_transfert_animaux(Animal futur_prisonier) {
		if (nombre_animaux_present >= nombre_maximum_animaux) {
			System.out.println(
					"ERREUR : il y a deja " + nombre_animaux_present + " pour un maximum de " + nombre_maximum_animaux);
		}

		// recuperation informations animal
		Class<?>[] mobilites = futur_prisonier.getClass().getInterfaces();
		String espece = futur_prisonier.getClass().getName().toString();

		// recuperation informations enclos
		String type_enclos = this.getClass().getName();

		String terre = EnclosStandard.class.getName();
		String eau = Aquarium.class.getName();
		String air = Voliere.class.getName();

		// verfications

		if (animaux_present.size() != 0) {
			if (animaux_present.get(0).getClass().getName().toString().equals(espece)) {
				return true;
			}
			System.out.println(
					futur_prisonier.recuperer_nom() + " n'est pas de la meme espece que les animaux dans " + nom);
			return false;

		} else {
			for (int j = 0; j < mobilites.length; j++) {
				if (mobilites[j].toString().equals("interface animaux_interfaces.Terrestre")
						&& type_enclos.equals(terre)) {
					return true;
				}
				if (mobilites[j].toString().equals("interface animaux_interfaces.Marin") && type_enclos.equals(eau)) {
					return true;

				}
				if (mobilites[j].toString().equals("interface animaux_interfaces.Volant") && type_enclos.equals(air)) {
					return true;

				}
			}
			System.out.println(futur_prisonier.recuperer_nom() + " ne peut pas physiquement survivre dans " + nom);
			return false;
		}
	}

	public void ajouter_animaux(Animal o) {
		animaux_present.add(o);
		nombre_animaux_present++;
		o.changer_enclos_de_l_animal(this);
		System.out.println("L'animal " + o.recuperer_nom() + " a bien ete rajouter dans l'enclos " + this.nom);
	}

	public void enlever_animaux(Animal o) {
		animaux_present.remove(o);
		nombre_animaux_present--;
		System.out.println("L'animal " + o.recuperer_nom() + "a bien été enlever dans l'enclos " + this.nom);

	}

	public void enlever_animaux(int i) {
		String nom_temp = animaux_present.get(i).recuperer_nom();
		animaux_present.remove(i);
		nombre_animaux_present--;
		System.out.println("L'animal " + nom_temp + "a bien été enlever dans l'enclos " + this.nom);
	}

	public boolean verification_nourrir() {
		for (Animal animal : animaux_present) {
			if (animal.recuperer_faim() == true)
				return true;
		}
		return false;
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

	public int recuperer_nombre_animaux_vivant() {
		int compteur = 0;
		for (Animal animal : animaux_present) {
			if (animal.recuperer_sante() != 0)
				compteur++;
		}
		return compteur;
	}

	public abstract void entretenir();

	public void enlever_corps() {
		for (Animal animal : animaux_present) {
			if (animal.recuperer_sante() == 0)
				enlever_animaux(animal);
		}
	}

	public void salir() {
		if (degree_proprete > 0)
			degree_proprete = degree_proprete - 1;
	}

	@Override
	public String toString() {
		String message_proprete = null;
		if (degree_proprete == 2)
			message_proprete = "propre";
		if (degree_proprete == 1)
			message_proprete = "moyen";
		if (degree_proprete == 0)
			message_proprete = "sale";
		return "Enclos [nom=" + nom + ", superficie=" + superficie + ", nombre_maximum_animaux="
				+ nombre_maximum_animaux + ", nombre_animaux_present=" + nombre_animaux_present + ", degree_proprete="
				+ message_proprete + "]";
	}

	public boolean verification_nettoyage() {
		if (degree_proprete < 2)
			return true;
		return false;
	}

}
