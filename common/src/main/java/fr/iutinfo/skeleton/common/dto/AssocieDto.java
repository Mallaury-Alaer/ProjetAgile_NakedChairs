package fr.iutinfo.skeleton.common.dto;

public class AssocieDto {
	private String foc,nom,adresse,ville,type,statut,diplome,mail;
	private int annexp,heuresSemaine,telephone,valide;
	public String getFoc() {
		return foc;
	}
	public int getValide() {
		return valide;
	}
	public void setValide(int valide) {
		this.valide = valide;
	}
	public void setFoc(String foc) {
		this.foc = foc;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAnnexp() {
		return annexp;
	}
	public void setAnnexp(int annexp) {
		this.annexp = annexp;
	}
	public int getHeuresSemaine() {
		return heuresSemaine;
	}
	public void setHeuresSemaine(int heuresSemaine) {
		this.heuresSemaine = heuresSemaine;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
}
