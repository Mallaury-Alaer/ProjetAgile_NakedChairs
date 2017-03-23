package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.TissuDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Tissu  {
	String nom;
	double longueur;
	double largeur;
	String type;
	String luminosite;
	
	public Tissu() {
		// TODO Auto-generated constructor stub
	}
	
	public Tissu(String nom,double longueur,double largeur,String type,String luminosite){
		this.nom = nom;
		this.longueur = longueur;
		this.largeur = largeur;
		this.type = type;
		this.luminosite = luminosite;
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
        return dto;
    }
    public void initFromDto(TissuDto dto) {
        this.setNom(dto.getNom());
        this.setLargeur(dto.getLargeur());
        this.setLongueur(dto.getLongueur());
        this.setType(dto.getType());
        this.setLuminosite(dto.getLuminosite());
    }
}