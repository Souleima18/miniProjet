package com.souleima.biscuits.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Biscuit {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idBiscuit;
private String nomBiscuit;
private Double prixBiscuit;
private String gout;
private Date dateSortir;

public Biscuit() {
	super();
}

public Biscuit(String nomBiscuit, Double prixBiscuit, Date dateSortir, String gout) {
	super();
	this.nomBiscuit = nomBiscuit;
	this.prixBiscuit = prixBiscuit;
	this.gout = gout;
	this.dateSortir = dateSortir;
	
}

public Long getIdBiscuit() {
	return idBiscuit;
}

public void setIdBiscuit(Long idBiscuit) {
	this.idBiscuit = idBiscuit;
}

public String getNomBiscuit() {
	return nomBiscuit;
}

public void setNomBiscuit(String nomBiscuit) {
	this.nomBiscuit = nomBiscuit;
}

public Double getPrixBiscuit() {
	return prixBiscuit;
}

public void setPrixBiscuit(Double prixBiscuit) {
	this.prixBiscuit = prixBiscuit;
}

public String getGout() {
	return gout;
}

public void setGout(String gout) {
	this.gout = gout;
}

public Date getDateSortir() {
	return dateSortir;
}

public void setDateSortir(Date dateSortir) {
	this.dateSortir = dateSortir;
}

@Override
public String toString() {
	return "Biscuit [idBiscuit=" + idBiscuit + ", nomBiscuit=" + nomBiscuit + ", prixBiscuit=" + prixBiscuit + ", gout="
			+ gout + ", dateSortir=" + dateSortir + "]";
}




























}