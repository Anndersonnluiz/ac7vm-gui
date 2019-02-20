package br.com.sistemags.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemags.model.Usuario;
import br.com.sistemags.util.ConectionFactory;

public class UsuarioDao {
	
	
	public Usuario salvar(Usuario usuario) throws SQLException{
		EntityManager manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		usuario = manager.merge(usuario);
        tx.commit();
        manager.close();
        return usuario; 
    } 
	
	public Usuario consultar(String sql)  throws SQLException  {
		EntityManager manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql); 
		Usuario usuario = null; 
        if (q.getResultList().size() > 0) {
        	usuario =  (Usuario) q.getResultList().get(0);
        } 
        manager.close();
        return usuario;
    }
	
	public List<Usuario> lista(String sql) throws SQLException {
		EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Usuario> lista = q.getResultList();
        manager.close();
        return lista; 
    }
	
	public void excluir(int idusuario) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Usuario usuario = manager.find(Usuario.class, idusuario);
        manager.remove(usuario);
        tx.commit();
        manager.close();
    }

}
