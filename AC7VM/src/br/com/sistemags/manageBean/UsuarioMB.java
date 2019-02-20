package br.com.sistemags.manageBean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistemags.facade.UsuarioFacade;
import br.com.sistemags.model.Usuario;
import br.com.sistemags.util.Criptografia;

@Named
@ViewScoped
public class UsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	private String senha;
	private boolean desabilitarSenha;
	
	
	
	@PostConstruct
	public void init() {
		if (usuario == null || usuario.getIdusuario() == null) {
			usuario = new Usuario();
		}
		gerarListaUsuario();
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}



	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	public boolean isDesabilitarSenha() {
		return desabilitarSenha;
	}



	public void setDesabilitarSenha(boolean desabilitarSenha) {
		this.desabilitarSenha = desabilitarSenha;
	}



	public void gerarListaUsuario() {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		listaUsuario = usuarioFacade.lista("SELECT u FROM Usuario u");
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
		}
	}
	
	
	public void salvar() {
		desabilitarSenha = false;
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		if (usuario.getIdusuario() == null) {
			usuario.setGrupoacesso_idgrupoacesso(1);
			try {
				senha = Criptografia.encript(senha);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			usuario.setSenha(senha);
		}
		usuario = usuarioFacade.salvar(usuario);
		senha = "";
		listaUsuario.add(usuario);
		usuario = new Usuario();
	}
	
	
	public void editar(Usuario usuario) {
		this.usuario = usuario;
		listaUsuario.remove(usuario);
		desabilitarSenha = true;
	}

}
