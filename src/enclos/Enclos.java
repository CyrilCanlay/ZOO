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
	}

	public boolean ajouter_animaux_securise(Animal futur_prisonier) {

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
				ajouter_animaux(futur_prisonier);
				return true;
			}
			System.out.println("ERREUR : " + futur_prisonier.recuperer_nom()
					+ " n'est pas la meme espece que les animaux dans " + nom);
			return false;

		} else {
			for (int j = 0; j < mobilites.length; j++) {
				if (mobilites[j].toString().equals("interface animaux_interfaces.Terrestre")
						&& type_enclos.equals(terre)) {
					ajouter_animaux(futur_prisonier);
					return true;
				}
				if (mobilites[j].toString().equals("interface animaux_interfaces.Marin") && type_enclos.equals(eau)) {
					ajouter_animaux(futur_prisonier);
					return true;

				}
				if (mobilites[j].toString().equals("interface animaux_interfaces.Volant") && type_enclos.equals(air)) {
					ajouter_animaux(futur_prisonier);
					return true;

				}
			}
			System.out.println(
					"ERREUR : " + futur_prisonier.recuperer_nom() + " ne peut pas physiquement survivre dans " + nom);
			return false;
		}

	}

	public void ajouter_animaux(Animal o) {
		animaux_present.add(o);
		nombre_animaux_present++;
		o.changer_enclos_de_l_animal(this);
		System.out.println("L'animal " + o.recuperer_nom() + " a bien été rajouter dans l'enclos " + this.nom);
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

	@Override
	public String toString() {
		return "TODO"; // TODO
	}

}
