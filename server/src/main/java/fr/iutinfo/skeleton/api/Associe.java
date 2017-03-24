package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.AssocieDto;

public class Associe {
	String foc,nom,adresse,ville,type,statut,diplome,mail;
	int annexp,heuresSemaine,telephone;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Associe(){
		
	}
	
	public Associe(String FoC,String nom,String adresse,String ville,String type,String statut,String diplome,String mail,int telephone,int annexp,int heuresSemaine){
		this.nom = nom;
		this.foc = FoC;
		this.adresse = adresse;
		this.ville = ville;
		this.type = type;
		this.statut = statut;
		this.diplome = diplome;
		this.annexp = annexp;
		this.heuresSemaine = heuresSemaine;
		this.mail = mail;
		this.telephone = telephone;
	}

	public String getFoc() {
		return foc;
	}

	public void setFoc(String foc) {
		foc = foc;
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
    public AssocieDto convertToDto() {
        AssocieDto dto = new AssocieDto();
        dto.setFoc(this.getFoc());
        dto.setNom(this.getNom());
        dto.setAdresse(this.getAdresse());
        dto.setVille(this.getVille());
        dto.setType(this.getType());
        dto.setStatut(this.getStatut());
        dto.setDiplome(this.getDiplome());
        dto.setAnnexp(this.getAnnexp());
        dto.setHeuresSemaine(this.getHeuresSemaine());
        dto.setMail(this.getMail());
        dto.setTelephone(this.getTelephone());
        return dto;
    }
    public void initFromDto(AssocieDto dto) {
        this.setNom(dto.getNom());
        this.setFoc(dto.getFoc());
        this.setAdresse(dto.getAdresse());
        this.setVille(dto.getVille());
        this.setType(dto.getType());
        this.setStatut(dto.getStatut());
        this.setDiplome(dto.getDiplome());
        this.setAnnexp(dto.getAnnexp());
        this.setHeuresSemaine(dto.getHeuresSemaine());
        this.setMail(dto.getMail());
        this.setTelephone(dto.getTelephone());
    } 
}