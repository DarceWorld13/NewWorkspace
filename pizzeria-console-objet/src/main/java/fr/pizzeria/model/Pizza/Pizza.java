package fr.pizzeria.model.Pizza;

public class Pizza {
	
	
	//attributs 
	protected int id;
	protected String code;
	protected String libelle;
	protected double prix;
	protected Categorie categorie;

	private static int count=0;
	
	//constructeur
	public Pizza(String code, String libelle, double prix, Categorie categorie) {
		super();
		this.id=count;
		count++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

		//constructeur
		/**
		 * @param id
		 * @param code
		 * @param libelle
		 * @param prix
		 */
		public Pizza(int id, String code, String libelle, double prix, Categorie categorie) {
			super();
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.prix = prix;
			this.categorie = categorie;
		}
		
		public String toString(){
			return "id = " + id + " code = " + code + " libelle = " + libelle + " prix = " + prix;
		}
		
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Pizza.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
	

	
	
	
	
	
	
	

}
