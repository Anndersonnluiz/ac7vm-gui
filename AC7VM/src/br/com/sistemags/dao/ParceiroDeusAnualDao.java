package br.com.sistemags.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemags.model.Parceirodeusanual;
import br.com.sistemags.util.ConectionFactory;

public class ParceiroDeusAnualDao {

	
	public Parceirodeusanual salvar(Parceirodeusanual parceirodeusanual) throws SQLException{
		EntityManager manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		parceirodeusanual = manager.merge(parceirodeusanual);
        tx.commit();
        manager.close();
        return parceirodeusanual; 
    } 
	
	public Parceirodeusanual consultar(String sql)  throws SQLException  {
		EntityManager manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql); 
		Parceirodeusanual parceirodeusanual = null; 
        if (q.getResultList().size() > 0) {
        	parceirodeusanual =  (Parceirodeusanual) q.getResultList().get(0);
        } 
        manager.close();
        return parceirodeusanual;
    }
	
	public List<Parceirodeusanual> lista(String sql) throws SQLException {
		EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Parceirodeusanual> lista = q.getResultList();
        manager.close();
        return lista; 
    }
	
	public void excluir(int idparceiro) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Parceirodeusanual parceirodeusanual = manager.find(Parceirodeusanual.class, idparceiro);
        manager.remove(parceirodeusanual);
        tx.commit();
        manager.close();
    }
}
