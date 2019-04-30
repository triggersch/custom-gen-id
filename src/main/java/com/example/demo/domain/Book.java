package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(
	        name = "assigned-sequence",
	        strategy = "com.example.demo.config.StringSequenceIdentifier",
	        parameters = {
	            @org.hibernate.annotations.Parameter(
	                name = "sequence_name", value = "hibernate_sequence"),
	            @org.hibernate.annotations.Parameter(
	                name = "sequence_prefix", value = "CTC_"),
	        }
	    )
	    @GeneratedValue(
	        generator = "assigned-sequence",
	        strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private String id;
	
	@Column(name = "NOM", nullable = false)
	private String nom;
	

	public Book(String nom) {
		this.nom = nom;
	}

	public Book() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	 
}
