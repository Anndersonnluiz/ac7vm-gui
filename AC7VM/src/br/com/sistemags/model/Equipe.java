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
@Table(name = "equipe")
public class Equipe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idequipe")
	private Integer idequipe;
	@Column(name = "descricao")
	private String descricao;
	
	
	public Equipe() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdequipe() {
		return idequipe;
	}


	public void setIdequipe(Integer idequipe) {
		this.idequipe = idequipe;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idequipe != null ? idequipe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Equipe)) {
			return false;
		}
		Equipe other = (Equipe) object;
		if ((this.idequipe == null && other.idequipe != null)
				|| (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Equipe[ idequipe=" + idequipe + " ]";
	}

}
