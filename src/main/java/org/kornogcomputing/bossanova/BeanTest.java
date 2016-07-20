package org.kornogcomputing.bossanova;

import java.util.Date;

public class BeanTest {
	private String nom;
	private long id;
	private String prenom;
	private Date date;
	private boolean ready;
	
	
	public BeanTest(String nom, long id, String prenom, Date date) {
		super();
		this.nom = nom;
		this.id = id;
		this.prenom = prenom;
		this.date = date;
	}
	public BeanTest() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	@Override
	public String toString() {
		return "BeanTest [nom=" + nom + ", id=" + id + ", prenom=" + prenom
				+ ", date=" + date + ", ready=" + ready + "]";
	}
	
	
	
}
