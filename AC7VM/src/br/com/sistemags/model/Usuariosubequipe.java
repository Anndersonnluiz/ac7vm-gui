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
@Table(name = "usuariosubequipe")
public class Usuariosubequipe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idusuariosubequipe")
	private Integer idusuariosubequipe;
	@Column(name = "subequipe_idsubequipe")
	private int equipe_idequipe;
	@Column(name = "usuario_idusuario")
	private int usuario_idusuario;
	
	
	public Usuariosubequipe() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdusuariosubequipe() {
		return idusuariosubequipe;
	}


	public void setIdusuariosubequipe(Integer idusuariosubequipe) {
		this.idusuariosubequipe = idusuariosubequipe;
	}


	public int getEquipe_idequipe() {
		return equipe_idequipe;
	}


	public void setEquipe_idequipe(int equipe_idequipe) {
		this.equipe_idequipe = equipe_idequipe;
	}


	public int getUsuario_idusuario() {
		return usuario_idusuario;
	}


	public void setUsuario_idusuario(int usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idusuariosubequipe != null ? idusuariosubequipe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Usuariosubequipe)) {
			return false;
		}
		Usuariosubequipe other = (Usuariosubequipe) object;
		if ((this.idusuariosubequipe == null && other.idusuariosubequipe != null)
				|| (this.idusuariosubequipe != null && !this.idusuariosubequipe.equals(other.idusuariosubequipe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Usuariosubequipe[ idusuariosubequipe=" + idusuariosubequipe + " ]";
	}

}
