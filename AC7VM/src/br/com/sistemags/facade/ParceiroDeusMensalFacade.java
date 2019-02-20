package br.com.sistemags.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.sistemags.dao.ParceiroDeusMensalDao;
import br.com.sistemags.model.Parceirodeusmensal;

public class ParceiroDeusMensalFacade {
	
	private ParceiroDeusMensalDao parceiroDeusMensalDao;
	
	public Parceirodeusmensal salvar(Parceirodeusmensal Parceirodeusmensal) {
		parceiroDeusMensalDao = new ParceiroDeusMensalDao();
		try {
			return parceiroDeusMensalDao.salvar(Parceirodeusmensal);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Parceirodeusmensal consultar(String sql) {
		parceiroDeusMensalDao = new ParceiroDeusMensalDao();
		try {
			return parceiroDeusMensalDao.consultar(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Parceirodeusmensal> lista(String sql){
		parceiroDeusMensalDao = new ParceiroDeusMensalDao();
		try {
			return parceiroDeusMensalDao.lista(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void excluir(int idParceirodeusmensal) {
		parceiroDeusMensalDao = new ParceiroDeusMensalDao();
		try {
			parceiroDeusMensalDao.excluir(idParceirodeusmensal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
