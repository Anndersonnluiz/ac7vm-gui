package br.com.sistemags.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subequipe")
public class Subequipe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idsubequipe")
	private Integer idsubequipe;
	@Column(name = "equipe_idequipe")
	private int equipe_idequipe;
	@Column(name = "nome")
	private String nome;
	
	
	
	public Subequipe() {
		// TODO Auto-generated constructor stub
	}



	public Integer getIdsubequipe() {
		return idsubequipe;
	}



	public void setIdsubequipe(Integer idsubequipe) {
		this.idsubequipe = idsubequipe;
	}



	public int getEquipe_idequipe() {
		return equipe_idequipe;
	}



	public void setEquipe_idequipe(int equipe_idequipe) {
		this.equipe_idequipe = equipe_idequipe;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idsubequipe != null ? idsubequipe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Subequipe)) {
			return false;
		}
		Subequipe other = (Subequipe) object;
		if ((this.idsubequipe == null && other.idsubequipe != null)
				|| (this.idsubequipe != null && !this.idsubequipe.equals(other.idsubequipe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Subequipe[ idsubequipe=" + idsubequipe + " ]";
	}

}
