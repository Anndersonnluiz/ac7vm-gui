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
@Table(name = "grupoacesso")
public class Grupoacesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idgrupoacesso")
	private Integer idgrupoacesso;
	@Column(name = "descricao")
	private boolean descricao;
	@Column(name = "idacesso")
	private Integer idacesso;
	
	
	public Grupoacesso() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdgrupoacesso() {
		return idgrupoacesso;
	}


	public void setIdgrupoacesso(Integer idgrupoacesso) {
		this.idgrupoacesso = idgrupoacesso;
	}


	public boolean isDescricao() {
		return descricao;
	}


	public void setDescricao(boolean descricao) {
		this.descricao = descricao;
	}


	public Integer getIdacesso() {
		return idacesso;
	}


	public void setIdacesso(Integer idacesso) {
		this.idacesso = idacesso;
	}
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idacesso != null ? idacesso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Grupoacesso)) {
			return false;
		}
		Grupoacesso other = (Grupoacesso) object;
		if ((this.idgrupoacesso == null && other.idgrupoacesso != null)
				|| (this.idgrupoacesso != null && !this.idgrupoacesso.equals(other.idgrupoacesso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Grupoacesso[ idgrupoacesso=" + idgrupoacesso + " ]";
	}

}
