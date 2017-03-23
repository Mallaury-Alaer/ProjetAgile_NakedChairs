package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TissuDto {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);

    private String nom;
    private double longueur,largeur;
	private String type;
	private String luminosite;
    
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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

}