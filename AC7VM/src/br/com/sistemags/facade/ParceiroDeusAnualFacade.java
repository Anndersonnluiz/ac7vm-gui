package br.com.sistemags.facade;

import java.sql.SQLException;
import java.util.List;

import br.com.sistemags.dao.ParceiroDeusAnualDao;
import br.com.sistemags.model.Parceirodeusanual;


public class ParceiroDeusAnualFacade {
	
	private ParceiroDeusAnualDao parceiroDeusAnualDao;
	
	public Parceirodeusanual salvar(Parceirodeusanual parceirodeusanual) {
		parceiroDeusAnualDao = new ParceiroDeusAnualDao();
		try {
			return parceiroDeusAnualDao.salvar(parceirodeusanual);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Parceirodeusanual consultar(String sql) {
		parceiroDeusAnualDao = new ParceiroDeusAnualDao();
		try {
			return parceiroDeusAnualDao.consultar(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Parceirodeusanual> lista(String sql){
		parceiroDeusAnualDao = new ParceiroDeusAnualDao();
		try {
			return parceiroDeusAnualDao.lista(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void excluir(int idParceirodeusmensal) {
		parceiroDeusAnualDao = new ParceiroDeusAnualDao();
		try {
			parceiroDeusAnualDao.excluir(idParceirodeusmensal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
