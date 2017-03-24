package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.TissuDto;

public class Tissu  {
	String nom;
	double longueur,largeur,phousse,pmetre;
	String type;
	String luminosite;
	int resistance;
	
	public double getPhousse() {
		return phousse;
	}

	public void setPhousse(double phousse) {
		this.phousse = phousse;
	}

	public double getPmetre() {
		return pmetre;
	}

	public void setPmetre(double pmetre) {
		this.pmetre = pmetre;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public Tissu() {
		// TODO Auto-generated constructor stub
	}
	
	public Tissu(String nom,double longueur,double largeur,String type,String luminosite,double phousse,double pmetre,int resistance){
		this.nom = nom;
		this.longueur = longueur;
		this.largeur = largeur;
		this.type = type;
		this.luminosite = luminosite;
		this.phousse = phousse;
		this.pmetre = pmetre;
		this.resistance = resistance;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLuminosite() {
		return luminosite;
	}

	public void setLuminosite(String luminosite) {
		this.luminosite = luminosite;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


    public TissuDto convertToDto() {
        TissuDto dto = new TissuDto();
        dto.setNom(this.getNom());
        dto.setLongueur(this.getLongueur());
        dto.setLargeur(this.getLargeur());
        dto.setType(this.getType());
        dto.setLuminosite(this.getLuminosite());
        dto.setPhousse(this.getPhousse());
        dto.setPmetre(this.getPmetre());
        dto.setResistance(this.getResistance());
        return dto;
    }
    public void initFromDto(TissuDto dto) {
        this.setNom(dto.getNom());
        this.setLargeur(dto.getLargeur());
        this.setLongueur(dto.getLongueur());
        this.setType(dto.getType());
        this.setLuminosite(dto.getLuminosite());
        this.setPhousse(dto.getPhousse());
        this.setPmetre(dto.getPmetre());
        this.setResistance(dto.getResistance());
    }
}