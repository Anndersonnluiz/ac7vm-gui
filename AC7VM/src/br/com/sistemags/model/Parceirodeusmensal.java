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
@Table(name = "parceirodeusmensal")
public class Parceirodeusmensal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idparceirodeusmensal")
	private Integer idparceirodeusmensal;
	@Column(name = "subequipe_idsubequipe")
	private int subequipe_idsubequipe;
	@Column(name = "valormeta")
	private float valormeta;
	@Column(name = "valoralcancado")
	private float valoralcancado;
	@Column(name = "mes")
	private int mes;
	@Column(name = "ano")
	private int ano;
	@Column(name = "valorsemana")
	private float valorsemana;
	
	
	
	public Parceirodeusmensal() {
		// TODO Auto-generated constructor stub
	}



	public Integer getIdparceirodeusmensal() {
		return idparceirodeusmensal;
	}



	public void setIdparceirodeusmensal(Integer idparceirodeusmensal) {
		this.idparceirodeusmensal = idparceirodeusmensal;
	}



	public int getSubequipe_idsubequipe() {
		return subequipe_idsubequipe;
	}



	public void setSubequipe_idsubequipe(int subequipe_idsubequipe) {
		this.subequipe_idsubequipe = subequipe_idsubequipe;
	}



	public float getValormeta() {
		return valormeta;
	}



	public void setValormeta(float valormeta) {
		this.valormeta = valormeta;
	}



	public float getValoralcancado() {
		return valoralcancado;
	}



	public void setValoralcancado(float valoralcancado) {
		this.valoralcancado = valoralcancado;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
	public float getValorsemana() {
		return valorsemana;
	}



	public void setValorsemana(float valorsemana) {
		this.valorsemana = valorsemana;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idparceirodeusmensal != null ? idparceirodeusmensal.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Parceirodeusmensal)) {
			return false;
		}
		Parceirodeusmensal other = (Parceirodeusmensal) object;
		if ((this.idparceirodeusmensal == null && other.idparceirodeusmensal != null)
				|| (this.idparceirodeusmensal != null && !this.idparceirodeusmensal.equals(other.idparceirodeusmensal))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Parceirodeusmensal[ idparceirodeusmensal=" + idparceirodeusmensal + " ]";
	}

}
