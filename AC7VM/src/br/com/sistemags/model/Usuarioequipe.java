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
@Table(name = "usuarioequipe")
public class Usuarioequipe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idusuarioequipe")
	private Integer idusuarioequipe;
	@Column(name = "equipe_idequipe")
	private int equipe_idequipe;
	@Column(name = "usuario_idusuario")
	private int usuario_idusuario;
	
	
	public Usuarioequipe() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdusuarioequipe() {
		return idusuarioequipe;
	}


	public void setIdusuarioequipe(Integer idusuarioequipe) {
		this.idusuarioequipe = idusuarioequipe;
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
		hash += (idusuarioequipe != null ? idusuarioequipe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Usuarioequipe)) {
			return false;
		}
		Usuarioequipe other = (Usuarioequipe) object;
		if ((this.idusuarioequipe == null && other.idusuarioequipe != null)
				|| (this.idusuarioequipe != null && !this.idusuarioequipe.equals(other.idusuarioequipe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Usuarioequipe[ idusuarioequipe=" + idusuarioequipe + " ]";
	}

}
