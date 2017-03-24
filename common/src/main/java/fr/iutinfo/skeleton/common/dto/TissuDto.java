package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TissuDto {
    final static Logger logger = LoggerFactory.getLogger(TissuDto.class);

    private String nom;
    private double longueur,largeur,phousse,pmetre;
	private String type;
	private String luminosite;
	private int resistance;
    
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