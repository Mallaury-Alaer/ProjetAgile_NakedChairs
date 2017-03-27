package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.PanierDto;

public class Panier {
	
	String dossier,formeDossier,accoudoir,assise,tissu,utilisateur;
	double hauteur,largeur,circonference,profondeurAssise,largeurAssise,diametre,prix;
	
	
	public Panier(){
		
	}
	
	public Panier(String dossier, String formeDossier, String accoudoir, String assise, String tissu,
			String utilisateur, double hauteur, double largeur, double circonference, double profondeurAssise,
			double largeurAssise, double diametre, double prix) {
		this.dossier = dossier;
		this.formeDossier = formeDossier;
		this.accoudoir = accoudoir;
		this.assise = assise;
		this.tissu = tissu;
		this.utilisateur = utilisateur;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.circonference = circonference;
		this.profondeurAssise = profondeurAssise;
		this.largeurAssise = largeurAssise;
		this.diametre = diametre;
		this.prix = prix;
	}
	public String getDossier() {
		return dossier;
	}
	public void setDossier(String dossier) {
		this.dossier = dossier;
	}
	public String getFormeDossier() {
		return formeDossier;
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
	   public PanierDto convertToDto() {
	        PanierDto dto = new PanierDto();
	        dto.setDossier(this.getDossier());
	        dto.setFormeDossier(this.getFormeDossier());
	        dto.setAccoudoir(this.getAccoudoir());
	        dto.setAssise(this.getAssise());
	        dto.setTissu(this.getTissu());
	        dto.setUtilisateur(this.getUtilisateur());
	        dto.setHauteur(this.getHauteur());
	        dto.setLargeur(this.getLargeur());
	        dto.setCirconference(this.getCirconference());
	        dto.setProfondeurAssise(this.getProfondeurAssise());
	        dto.setLargeurAssise(this.getLargeurAssise());
	        dto.setDiametre(this.getDiametre());
	        dto.setPrix(this.getPrix());
	        return dto;
	    }
	    public void initFromDto(PanierDto dto) {
	        this.setDossier(dto.getDossier());
	        this.setFormeDossier(dto.getFormeDossier());
	        this.setAccoudoir(dto.getAccoudoir());
	        this.setAssise(dto.getAssise());
	        this.setTissu(dto.getTissu());
	        this.setUtilisateur(dto.getUtilisateur());
	        this.setHauteur(dto.getHauteur());
	        this.setLargeur(dto.getLargeur());
	        this.setCirconference(dto.getCirconference());
	        this.setProfondeurAssise(dto.getProfondeurAssise());
	        this.setLargeurAssise(dto.getLargeurAssise());
	        this.setDiametre(dto.getDiametre());
	        this.setPrix(dto.getPrix());
	    } 

}
