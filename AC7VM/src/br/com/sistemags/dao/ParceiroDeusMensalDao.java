package br.com.sistemags.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemags.model.Parceirodeusmensal;
import br.com.sistemags.util.ConectionFactory;

public class ParceiroDeusMensalDao {
	
	public Parceirodeusmensal salvar(Parceirodeusmensal parceirodeusmensal) throws SQLException{
		EntityManager manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		parceirodeusmensal = manager.merge(parceirodeusmensal);
        tx.commit();
        manager.close();
        return parceirodeusmensal; 
    } 
	
	public Parceirodeusmensal consultar(String sql)  throws SQLException  {
		EntityManager manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql); 
		Parceirodeusmensal parceirodeusmensal = null; 
        if (q.getResultList().size() > 0) {
        	parceirodeusmensal =  (Parceirodeusmensal) q.getResultList().get(0);
        } 
        manager.close();
        return parceirodeusmensal;
    }
	
	public List<Parceirodeusmensal> lista(String sql) throws SQLException {
		EntityManager manager = ConectionFactory.getConnection();
        Query q = manager.createQuery(sql);
        List<Parceirodeusmensal> lista = q.getResultList();
        manager.close();
        return lista; 
    }
	
	public void excluir(int idparceiro) throws SQLException{
    	EntityManager manager;
        manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Parceirodeusmensal parceirodeusmensal = manager.find(Parceirodeusmensal.class, idparceiro);
        manager.remove(parceirodeusmensal);
        tx.commit();
        manager.close();
    }

}
