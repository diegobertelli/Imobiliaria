package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import modelo.Imovel;
import dao.ImovelDao;

@ManagedBean
@ViewScoped
public class PesquisaImovelController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Imovel imovel;

	private String numEscritura;

	private ImovelDao imovelDao;

	private List<Imovel> imovels;

	public PesquisaImovelController() {
		
	}
	
	/** METODOS **/
	
	@PostConstruct
	public void init() {
		this.imovel = new Imovel();
		this.imovelDao = new ImovelDao();
		buscarListaImovels();
	}
	
	public void excluirImovel() {
		this.imovelDao.remove(this.imovel);
		buscarListaImovels();
		this.numEscritura = null;
	}
	
	public void removerImovel(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codImovel");
		this.imovelDao.remove(this.imovelDao.find(id));
	}

	public void buscarImovel(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codImovel");
		this.imovel = this.imovelDao.find(id);
	}

	public void buscarListaImovels() {
		try {
			this.imovels = this.imovelDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPorNumeroEscritura(AjaxBehaviorEvent event) {
		try {
			this.imovels = new ArrayList<Imovel>();
			this.imovels.add(this.imovelDao.buscarPorNumeroEscritura(this.numEscritura));
			this.numEscritura = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** GET E SET **/
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String getNome() {
		return numEscritura;
	}

	public void setNome(String nome) {
		this.numEscritura = nome;
	}

	public ImovelDao getImovelDao() {
		return imovelDao;
	}

	public void setImovelDao(ImovelDao imovelDao) {
		this.imovelDao = imovelDao;
	}

	public List<Imovel> getImovels() {
		return imovels;
	}

	public void setImovels(List<Imovel> imovels) {
		this.imovels = imovels;
	}

	public String getNumEscritura() {
		return numEscritura;
	}

	public void setNumEscritura(String numEscritura) {
		this.numEscritura = numEscritura;
	}
	
}
