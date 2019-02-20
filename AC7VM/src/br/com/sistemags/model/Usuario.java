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
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idusuario")
	private Integer idusuario;
	@Column(name = "nome")
	private String nome;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "login")
	private String login;
	@Column(name = "senha")
	private String senha;
	@Column(name = "grupoacesso_idgrupoacesso")
	private int grupoacesso_idgrupoacesso;
	@Column(name = "idsubequipe")
	private int idsubequipe;
	@Column(name = "idequipe")
	private int idequipe;
	@Column(name = "tipoacesso")
	private String tipoacesso;
	@Column(name = "situacao")
	private String situacao;
	
	
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}




	public Integer getIdusuario() {
		return idusuario;
	}




	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public int getGrupoacesso_idgrupoacesso() {
		return grupoacesso_idgrupoacesso;
	}




	public void setGrupoacesso_idgrupoacesso(int grupoacesso_idgrupoacesso) {
		this.grupoacesso_idgrupoacesso = grupoacesso_idgrupoacesso;
	}




	public int getIdsubequipe() {
		return idsubequipe;
	}




	public void setIdsubequipe(int idsubequipe) {
		this.idsubequipe = idsubequipe;
	}




	public int getIdequipe() {
		return idequipe;
	}




	public void setIdequipe(int idequipe) {
		this.idequipe = idequipe;
	}




	public String getTipoacesso() {
		return tipoacesso;
	}




	public void setTipoacesso(String tipoacesso) {
		this.tipoacesso = tipoacesso;
	}
	
	
	
	public String getSituacao() {
		return situacao;
	}




	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}




	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idusuario != null ? idusuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.idusuario == null && other.idusuario != null)
				|| (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemags.model.Usuario[ idusuario=" + idusuario + " ]";
	}
	

}
