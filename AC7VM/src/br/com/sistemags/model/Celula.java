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
@Table(name = "celula")
public class Celula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcelula")
	private Integer idcelula;
	@Column(name = "subequipe_idsubequipe")
	private int subequipe_idsubequipe;
	@Column(name = "diasemana")
	private String diasemana;
	@Column(name = "horario")
	private String horario;
	
	
	public Celula() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdcelula() {
		return idcelula;
	}


	public void setIdcelula(Integer idcelula) {
		this.idcelula = idcelula;
	}


	public int getSubequipe_idsubequipe() {
		return subequipe_idsubequipe;
	}


	public void setSubequipe_idsubequipe(int subequipe_idsubequipe) {
		this.subequipe_idsubequipe = subequipe_idsubequipe;
	}


	public String getDiasemana() {
		return diasemana;
	}


	public void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcelula != null ? idcelula.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Celula)) {
			return false;
		}
		Celula other = (Celula) object;
		if ((this.idcelula == null && other.idcelula != null)
				|| (this.idcelula != null && !this.idcelula.equals(other.idcelula))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Celula[ idcelula=" + idcelula + " ]";
	}

}
