package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.TissuDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Tissu  {
	String nom;
	double longueur;
	double largeur;
	
	public Tissu() {
		// TODO Auto-generated constructor stub
	}
	
	public Tissu(String nom,double longueur,double largeur){
		this.nom = nom;
		this.longueur = longueur;
		this.largeur = largeur;
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
        return dto;
    }
    public void initFromDto(TissuDto dto) {
        this.setNom(dto.getNom());
        this.setLargeur(dto.getLargeur());
        this.setLongueur(dto.getLongueur());
    }
}