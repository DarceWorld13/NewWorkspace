package fr.pizzeria.model.Pizza;

public class Pizzahome extends Pizza {

	
	public Pizzahome(int id, String code, String libelle, double prix, Categorie categorie) {
		super(code, libelle, prix, categorie);

	}

	public String toString(){
		
		return "id = " + id + " code = " + code + " libelle = " + libelle;
	}
	
	
	
	
	
}
