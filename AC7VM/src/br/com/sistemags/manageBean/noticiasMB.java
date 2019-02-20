package br.com.sistemags.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemags.facade.ParceiroDeusAnualFacade;
import br.com.sistemags.facade.ParceiroDeusMensalFacade;
import br.com.sistemags.model.Parceirodeusanual;
import br.com.sistemags.model.Parceirodeusmensal;
import br.com.sistemags.model.Usuario;
import br.com.sistemags.util.Formatacao;
import br.com.sistemags.util.UsuarioLogadoMB;

@Named
@ViewScoped
public class noticiasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioLogadoMB usuarioLogadoMB;
	private Usuario usuario;
	private List<String> lista;
	private Parceirodeusmensal parceirodeusmensal;
	private List<Parceirodeusmensal> listaParceiro;
	private float valorSubMeta = 0.0f;
	private float valorSubAlcancado = 0.0f;
	private float valorSubAnoMeta = 0.0f;
	private float valorSubAnoAlcancado = 0.0f;
	private int ano;
	private String mes;
	private List<Parceirodeusanual> listaParceiroAnual;
	private String corMetaSub = "";
	private String corMetaSubAnual = "";
	
	
	@PostConstruct
	public void init() {
//		FacesContext fc = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
//		usuario = (Usuario) session.getAttribute("usuario");
		lista = new ArrayList<>();
		lista.add("EM BREVE..");
		ano = Formatacao.getAnoData(new Date());
		mes = Formatacao.getMes();
		gerarDadosParceiro();
	}


	public List<String> getLista() {
		return lista;
	}


	


	public void setLista(List<String> lista) {
		this.lista = lista;
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


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	public float getValorSubMeta() {
		return valorSubMeta;
	}


	public void setValorSubMeta(float valorSubMeta) {
		this.valorSubMeta = valorSubMeta;
	}


	public float getValorSubAlcancado() {
		return valorSubAlcancado;
	}


	public void setValorSubAlcancado(float valorSubAlcancado) {
		this.valorSubAlcancado = valorSubAlcancado;
	}


	public float getValorSubAnoMeta() {
		return valorSubAnoMeta;
	}


	public void setValorSubAnoMeta(float valorSubAnoMeta) {
		this.valorSubAnoMeta = valorSubAnoMeta;
	}


	public float getValorSubAnoAlcancado() {
		return valorSubAnoAlcancado;
	}


	public void setValorSubAnoAlcancado(float valorSubAnoAlcancado) {
		this.valorSubAnoAlcancado = valorSubAnoAlcancado;
	}


	public List<Parceirodeusanual> getListaParceiroAnual() {
		return listaParceiroAnual;
	}


	public void setListaParceiroAnual(List<Parceirodeusanual> listaParceiroAnual) {
		this.listaParceiroAnual = listaParceiroAnual;
	}


	public String getCorMetaSub() {
		return corMetaSub;
	}


	public void setCorMetaSub(String corMetaSub) {
		this.corMetaSub = corMetaSub;
	}


	public String getCorMetaSubAnual() {
		return corMetaSubAnual;
	}


	public void setCorMetaSubAnual(String corMetaSubAnual) {
		this.corMetaSubAnual = corMetaSubAnual;
	}


	public void gerarDadosParceiro() {
		ParceiroDeusMensalFacade parceiroDeusMensalFacade = new ParceiroDeusMensalFacade();
		int mes = Formatacao.getMesData(new Date())+ 1;
		listaParceiro = parceiroDeusMensalFacade.lista("SELECT p FROM Parceirodeusmensal p WHERE p.subequipe_idsubequipe=" + usuarioLogadoMB.getUsuario().getIdsubequipe()
				+ " and p.mes=" + mes + " and p.ano=" + ano);
		if (listaParceiro == null) {
			listaParceiro = new ArrayList<Parceirodeusmensal>();
		} 
		valorSubAlcancado = 0.0f;
		valorSubMeta = 0.0f;
		for (int i = 0; i < listaParceiro.size(); i++) {
			valorSubMeta = valorSubMeta + listaParceiro.get(i).getValormeta();
			valorSubAlcancado = valorSubAlcancado + listaParceiro.get(i).getValoralcancado();
		}
		if (valorSubMeta > valorSubAlcancado) {
			corMetaSub = "alert alert-danger";
		}else {
			corMetaSub = "alert alert-success";
		}
		ParceiroDeusAnualFacade parceiroDeusAnualFacade = new ParceiroDeusAnualFacade();
		listaParceiroAnual = parceiroDeusAnualFacade.lista("SELECT p FROM Parceirodeusanual p WHERE p.subequipe_idsubequipe=" + usuarioLogadoMB.getUsuario().getIdsubequipe() + " and p.ano=" + ano);
		if (listaParceiroAnual == null) {
			listaParceiroAnual = new ArrayList<Parceirodeusanual>();
		}
		valorSubAnoAlcancado = 0.0f;
		valorSubAnoMeta = 0.0f;
		for (int i = 0; i < listaParceiroAnual.size(); i++) {
			valorSubAnoMeta = valorSubAnoMeta + listaParceiroAnual.get(i).getValormeta();
			valorSubAnoAlcancado = valorSubAnoAlcancado + listaParceiroAnual.get(i).getValoralcancado();
		}
		if (valorSubAnoMeta > valorSubAnoAlcancado) {
			corMetaSubAnual = "alert alert-danger";
		}else {
			corMetaSubAnual = "alert alert-success";
		}
	}
	
	
	
	
	

	
	
}
