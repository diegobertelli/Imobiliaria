package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import modelo.Imovel;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.Venda;
import dao.ImovelDao;
import dao.PessoaDao;
import dao.PessoaFisicaDao;
import dao.PessoaJuridicaDao;
import dao.VendaDao;
import enums.Financeiras;

@ManagedBean
@ViewScoped
public class CadastroVendaController implements Serializable{

	private static final long serialVersionUID = -7479783618441789983L;

	private Venda venda;
	
	private VendaDao vendaDao;
	
	private String valor;
	
	private List<Financeiras> financeiras;
	
	public CadastroVendaController() {

	}
	
	/** METODOS **/
	
	@PostConstruct
	public void init(){
		this.vendaDao = new VendaDao();
		verificaParametro();
	}
	
	private void verificaParametro() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("venda");  
		if(id == null || id.isEmpty()){
			this.venda = new Venda();
		}else{
			this.venda = vendaDao.find(Long.valueOf(id));
		}
	}
	
	public String novoVenda() {

		this.vendaDao.create(this.venda);
		return "cadastroVenda";
	}

	public String salvarVenda() {
		
		this.vendaDao.edit(this.venda);
		
		this.venda = new Venda();
		
		return "cadastroVenda";
	}
	
	public void buscarPorValor(AjaxBehaviorEvent event) {
		try {
			if(this.valor.length() <= 11){
				try {
					this.venda.setCliente(new PessoaFisicaDao().buscarPorCPF(this.valor)); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				try {
					this.venda.setCliente(new PessoaJuridicaDao().buscarPorCNPJ(this.valor)); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.valor = null;
	}
	
	public void buscarPorNumEsc(AjaxBehaviorEvent event) {

		try {
			this.venda.setImovel(new ImovelDao().buscarPorNumeroEscritura(this.valor)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.valor = null;
	}
	
	/** GET E SET **/ 
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public VendaDao getVendaDao() {
		return vendaDao;
	}

	public void setVendaDao(VendaDao vendaDao) {
		this.vendaDao = vendaDao;
	}

	public List<Financeiras> getFinanceiras() {
		return Arrays.asList(Financeiras.values());
	}

	public void setFinanceiras(List<Financeiras> financeiras) {
		this.financeiras = financeiras;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
