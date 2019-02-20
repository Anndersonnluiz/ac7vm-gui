/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemags.util;
   
import br.com.sistemags.facade.UsuarioFacade;
import br.com.sistemags.model.Usuario;
import br.com.sistemags.util.Criptografia;
import br.com.sistemags.util.Mensagem;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
 


@Named
@SessionScoped
public class UsuarioLogadoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String novaSenha;
	private String senhaAtual;
	private String confirmaNovaSenha;
	private String mensagemOla;
	private boolean financeiro;
	private boolean controle;
	private boolean logar;
	private boolean comercial;
	private boolean franquia;
	private String senha;
	private String login; 
	private List<String> imagens;

	@PostConstruct
	public void init() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmaNovaSenha() {
		return confirmaNovaSenha;
	}

	public void setConfirmaNovaSenha(String confirmaNovaSenha) {
		this.confirmaNovaSenha = confirmaNovaSenha;
	}

	
	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	
	public String getMensagemOla() {
		return mensagemOla;
	}

	public void setMensagemOla(String mensagemOla) {
		this.mensagemOla = mensagemOla;
	}

	

	public boolean isFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(boolean financeiro) {
		this.financeiro = financeiro;
	}

	

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	} 

	public boolean isComercial() {
		return comercial;
	}

	public void setComercial(boolean comercial) {
		this.comercial = comercial;
	}

	public boolean isFranquia() {
		return franquia;
	}

	public void setFranquia(boolean franquia) {
		this.franquia = franquia;
	}
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isLogar() {
		return logar;
	}

	public void setLogar(boolean logar) {
		this.logar = logar;
	}

	public String logar() {
		if (logar) {  
			return "paginainicial";
		} else
			return "";
	}

	public String validarUsuario() throws SQLException { 
		usuario = new Usuario();  
		if ((login == null) && (senha == null)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro", "Acesso Negado."));
		} else {
			String senha = "";
			try {
				senha = Criptografia.encript(this.senha);
				this.senha = "";
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
			} 
			UsuarioFacade usuarioFacade = new UsuarioFacade();
			usuario = usuarioFacade.consultar("SELECT u FROM Usuario u WHERE u.login='" + login + "' and u.senha='"+ senha + "'");
			if (usuario == null) {
				Mensagem.lancarMensagemInfo("Atenção", "Acesso negado");
			} else {
				if (usuario.getSituacao().equalsIgnoreCase("Inativo")) {
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro", "Acesso Negado."));
				} else {

					FacesContext fc = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
					session.setAttribute("usuario", usuario);
					mensagemOlá();
					return "inicial";
				}
			}
		}
		return "";
	}

	public void erroLogin(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensagem, ""));
	}

	public void validarTrocarSenha() {
		if (usuario == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
		} else {
			Map<String, Object> options = new HashMap<String, Object>();
			options.put("contentWidth", 280);
			options.put("closable", false);
			RequestContext.getCurrentInstance().openDialog("cadNovaSenha", options, null);
		}
	}

	public String confirmaNovaSenha() {
		String repetirSenhaAtual = "";
		try {
			repetirSenhaAtual = Criptografia.encript(senhaAtual);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (repetirSenhaAtual.equalsIgnoreCase(usuario.getSenha())) {
			if ((novaSenha.length() > 0) && (confirmaNovaSenha.length() > 0)) {
				if (novaSenha.equalsIgnoreCase(confirmaNovaSenha)) {
					String senha = "";
					try {
						senha = Criptografia.encript(novaSenha);
					} catch (NoSuchAlgorithmException ex) {
						Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
					}
					usuario.setSenha(senha);
					UsuarioFacade usuarioFacade = new UsuarioFacade();
					usuario = usuarioFacade.salvar(usuario);
					senhaAtual = "";
					novaSenha = "";
					confirmaNovaSenha = "";
					RequestContext.getCurrentInstance().closeDialog(usuario);
					return "";
				} else {
					novaSenha = "";
					confirmaNovaSenha = "";
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Acesso Negado."));
			}
		} else {
			Mensagem.lancarMensagemInfo("", "Alteração Negada");
			senhaAtual = "";
			novaSenha = "";
			confirmaNovaSenha = "";
		}
		return "";
	}

	public String cancelarTrocaSenha() {
		novaSenha = "";
		confirmaNovaSenha = "";
		RequestContext.getCurrentInstance().closeDialog(null);
		return "";
	}

	

	public String deslogar() {
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.clear();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "index";
	}

	public void mensagemOlá() throws SQLException {
		mensagemOla = "Olá " + usuario.getNome();
	}

	
	
	

	public boolean mostrarCRM(int idusuario){
		if(idusuario==125){
			return true;
		}else return false;
	}
	
	public void salvarUsuario() {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		usuario = usuarioFacade.salvar(usuario);
		RequestContext.getCurrentInstance().closeDialog("inicial.jsf");
	}
	
	public void retornoDialogData(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	

	 
}
