package br.com.sistemags.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.sistemags.dao.UsuarioDao;
import br.com.sistemags.model.Usuario;

public class UsuarioFacade {
	
	private UsuarioDao usuarioDao;
	
	
	public Usuario salvar(Usuario usuario) {
		usuarioDao = new UsuarioDao();
		try {
			return usuarioDao.salvar(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario consultar(String sql) {
		usuarioDao = new UsuarioDao();
		try {
			return usuarioDao.consultar(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Usuario> lista(String sql){
		usuarioDao = new UsuarioDao();
		try {
			return usuarioDao.lista(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void excluir(int idusuario) {
		usuarioDao = new UsuarioDao();
		try {
			usuarioDao.excluir(idusuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
