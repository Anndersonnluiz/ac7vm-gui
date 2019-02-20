package br.com.sistemags.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.sistemags.facade.ParceiroDeusAnualFacade;
import br.com.sistemags.facade.ParceiroDeusMensalFacade;
import br.com.sistemags.model.Parceirodeusanual;
import br.com.sistemags.model.Parceirodeusmensal;


@Named
@ViewScoped
public class ParceiroDeusMensalMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> lista;
	private Parceirodeusmensal parceirodeusmensal;
	private Parceirodeusanual parceirodeusanual;
	private List<Parceirodeusmensal> listaParceiro;
	private List<Parceirodeusanual> listaParceiroAnual;
	
	
	@PostConstruct
	public void init() {
		parceirodeusmensal = new Parceirodeusmensal();
		parceirodeusanual = new Parceirodeusanual();
		gerarListaParceiro();
	}


	public List<String> getLista() {
		return lista;
	}


	public Parceirodeusmensal getParceirodeusmensal() {
		return parceirodeusmensal;
	}


	public void setParceirodeusmensal(Parceirodeusmensal parceirodeusmensal) {
		this.parceirodeusmensal = parceirodeusmensal;
	}


	public List<Parceirodeusmensal> getListaParceiro() {
		return listaParceiro;
	}


	public void setListaParceiro(List<Parceirodeusmensal> listaParceiro) {
		this.listaParceiro = listaParceiro;
	}


	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
	
	public Parceirodeusanual getParceirodeusanual() {
		return parceirodeusanual;
	}


	public void setParceirodeusanual(Parceirodeusanual parceirodeusanual) {
		this.parceirodeusanual = parceirodeusanual;
	}


	public List<Parceirodeusanual> getListaParceiroAnual() {
		return listaParceiroAnual;
	}


	public void setListaParceiroAnual(List<Parceirodeusanual> listaParceiroAnual) {
		this.listaParceiroAnual = listaParceiroAnual;
	}


	public void salvar() {
		ParceiroDeusMensalFacade parceiroDeusMensalFacade = new ParceiroDeusMensalFacade();
		parceirodeusmensal.setSubequipe_idsubequipe(1);
		parceirodeusmensal.setValoralcancado(0.0f);
		parceirodeusmensal = parceiroDeusMensalFacade.salvar(parceirodeusmensal);
		if (listaParceiro == null) {
			listaParceiro = new ArrayList<>();
		}
		listaParceiro.add(parceirodeusmensal);
		parceirodeusmensal = new Parceirodeusmensal();
	}
	
	
	public void salvarAnual() {
		ParceiroDeusAnualFacade parceiroDeusAnualFacade = new ParceiroDeusAnualFacade();
		parceirodeusanual.setSubequipe_idsubequipe(1);
		parceirodeusanual.setValoralcancado(0.0f);
		parceirodeusanual = parceiroDeusAnualFacade.salvar(parceirodeusanual);
		if (listaParceiroAnual == null) {
			listaParceiroAnual = new ArrayList<>();
		}
		listaParceiroAnual.add(parceirodeusanual);
		parceirodeusanual = new Parceirodeusanual();
	}
	
	
	public void editar(Parceirodeusmensal parceirodeusmensal) {
		listaParceiro.remove(parceirodeusmensal);
		this.parceirodeusmensal = parceirodeusmensal;
	}
	

	public void editarAnual(Parceirodeusanual parceirodeusanual) {
		listaParceiroAnual.remove(parceirodeusanual);
		this.parceirodeusanual = parceirodeusanual;
	}
	
	
	public void gerarListaParceiro() {
		ParceiroDeusMensalFacade parceiroDeusMensalFacade = new ParceiroDeusMensalFacade();
		listaParceiro = parceiroDeusMensalFacade.lista("SELECT p FROM Parceirodeusmensal p");
		if (listaParceiro == null) {
			listaParceiro = new ArrayList<Parceirodeusmensal>();
		}
		
		
		ParceiroDeusAnualFacade parceiroDeusAnualFacade = new ParceiroDeusAnualFacade();
		listaParceiroAnual = parceiroDeusAnualFacade.lista("SELECT p FROM Parceirodeusanual p");
		if (listaParceiroAnual == null) {
			listaParceiroAnual = new ArrayList<Parceirodeusanual>();
		}
	}
	
	
	


}
