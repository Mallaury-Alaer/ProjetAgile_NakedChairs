package fr.iutinfo.skeleton.common.dto;

public class PanierDto {
	String dossier,formeDossier,accoudoir,assise,tissu,utilisateur,valide;
	double hauteur,largeur,circonference,profondeurAssise,largeurAssise,diametre,prix;
	int id=0;
	public String getDossier() {
		return dossier;
	}
	public void setDossier(String dossier) {
		this.dossier = dossier;
	}
	public String getFormeDossier() {
		return formeDossier;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}
	public void setFormeDossier(String formeDossier) {
		this.formeDossier = formeDossier;
	}
	public String getAccoudoir() {
		return accoudoir;
	}
	public void setAccoudoir(String accoudoir) {
		this.accoudoir = accoudoir;
	}
	public String getAssise() {
		return assise;
	}
	public void setAssise(String assise) {
		this.assise = assise;
	}
	public String getTissu() {
		return tissu;
	}
	public void setTissu(String tissu) {
		this.tissu = tissu;
	}
	public String getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public double getCirconference() {
		return circonference;
	}
	public void setCirconference(double circonference) {
		this.circonference = circonference;
	}
	public double getProfondeurAssise() {
		return profondeurAssise;
	}
	public void setProfondeurAssise(double profondeurAssise) {
		this.profondeurAssise = profondeurAssise;
	}
	public double getLargeurAssise() {
		return largeurAssise;
	}
	public void setLargeurAssise(double largeurAssise) {
		this.largeurAssise = largeurAssise;
	}
	public double getDiametre() {
		return diametre;
	}
	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
