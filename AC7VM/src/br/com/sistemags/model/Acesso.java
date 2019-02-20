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
@Table(name = "acesso")
public class Acesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idacesso")
	private Integer idacesso;
	@Column(name = "telainicial")
	private boolean telainicial;
	
	
	
	public Acesso() {
		// TODO Auto-generated constructor stub
	}



	public Integer getIdacesso() {
		return idacesso;
	}



	public void setIdacesso(Integer idacesso) {
		this.idacesso = idacesso;
	}



	public boolean isTelainicial() {
		return telainicial;
	}



	public void setTelainicial(boolean telainicial) {
		this.telainicial = telainicial;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idacesso != null ? idacesso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Acesso)) {
			return false;
		}
		Acesso other = (Acesso) object;
		if ((this.idacesso == null && other.idacesso != null)
				|| (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Acesso[ idacesso=" + idacesso + " ]";
	}
	
	
	

}
