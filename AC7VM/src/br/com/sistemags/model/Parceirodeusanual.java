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
@Table(name = "parceirodeusanual")
public class Parceirodeusanual implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idparceirodeusanual")
	private Integer idparceirodeusanual;
	@Column(name = "subequipe_idsubequipe")
	private int subequipe_idsubequipe;
	@Column(name = "valormeta")
	private float valormeta;
	@Column(name = "valoralcancado")
	private float valoralcancado;
	@Column(name = "ano")
	private int ano;
	@Column(name = "valormensal")
	private float valormensal;
	
	
	
	public Parceirodeusanual() {
		// TODO Auto-generated constructor stub
	}



	public Integer getIdparceirodeusanual() {
		return idparceirodeusanual;
	}



	public void setIdparceirodeusanual(Integer idparceirodeusanual) {
		this.idparceirodeusanual = idparceirodeusanual;
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



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public float getValormensal() {
		return valormensal;
	}



	public void setValormensal(float valormensal) {
		this.valormensal = valormensal;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idparceirodeusanual != null ? idparceirodeusanual.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Parceirodeusanual)) {
			return false;
		}
		Parceirodeusanual other = (Parceirodeusanual) object;
		if ((this.idparceirodeusanual == null && other.idparceirodeusanual != null)
				|| (this.idparceirodeusanual != null && !this.idparceirodeusanual.equals(other.idparceirodeusanual))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Parceirodeusanual[ idparceirodeusanual=" + idparceirodeusanual + " ]";
	}


}
