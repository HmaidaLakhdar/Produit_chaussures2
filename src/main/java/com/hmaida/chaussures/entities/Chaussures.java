package com.hmaida.chaussures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chaussures {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idChaussures;
	private String nomChaussures;
	private Double prixChaussures;
	private Date dateCreation;
	
	
	
	public Chaussures() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Chaussures(String nomChaussures, Double prixChaussures, Date dateCreation) {
		super();
		this.nomChaussures = nomChaussures;
		this.prixChaussures = prixChaussures;
		this.dateCreation = dateCreation;
	}
	
	
	public Long getIdChaussures() {
		return idChaussures;
	}
	public void setIdChaussures(Long idChaussures) {
		this.idChaussures = idChaussures;
	}
	public String getNomChaussures() {
		return nomChaussures;
	}
	public void setNomChaussures(String nomChaussures) {
		this.nomChaussures = nomChaussures;
	}
	public Double getPrixChaussures() {
		return prixChaussures;
	}
	public void setPrixChaussures(Double prixChaussures) {
		this.prixChaussures = prixChaussures;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	@Override
	public String toString() {
		return "Chaussures [idChaussures=" + idChaussures + ", nomChaussures=" + nomChaussures + ", prixChaussures="
				+ prixChaussures + ", dateCreation=" + dateCreation + "]";
	}
	
	

}
