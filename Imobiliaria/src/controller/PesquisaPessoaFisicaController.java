package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import modelo.PessoaFisica;
import dao.PessoaFisicaDao;

@ManagedBean
@ViewScoped
public class PesquisaPessoaFisicaController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private PessoaFisica pessoaFisica;
	
	private PessoaFisicaDao pessoaFisicaDao;
	
	private List<PessoaFisica> pessoasFisicas;
	
	private String nome;
	
	public PesquisaPessoaFisicaController() {

	}

	/** METODOS **/
	
	@PostConstruct
	public void init() {
		this.pessoaFisica = new PessoaFisica();
		this.pessoaFisicaDao = new PessoaFisicaDao();
		buscarListaPessoaFisicas();
	}
	
	public void excluirPessoaFisica() {
		this.pessoaFisicaDao.remove(this.pessoaFisica);
		buscarListaPessoaFisicas();
		this.nome = null;
	}
	
	public void removerPessoaFisica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaFisica");
		this.pessoaFisicaDao.remove(this.pessoaFisicaDao.find(id));
	}

	public void buscarPessoaFisica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaFisica");
		this.pessoaFisica = this.pessoaFisicaDao.find(id);
	}

	public void buscarListaPessoaFisicas() {
		try {
			this.pessoasFisicas = this.pessoaFisicaDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPorNome(AjaxBehaviorEvent event) {
		try {
			this.pessoasFisicas = this.pessoaFisicaDao.buscarPorNome(this.nome);
			this.nome = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getPessoaFisicas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<PessoaFisica> it = this.pessoaFisicaDao.findAll();
		for (int i = 0; i < it.size(); i++) {
			PessoaFisica pessoaFisica = it.get(i);
			list.add(new SelectItem(pessoaFisica, pessoaFisica.getId() + ""));
		}
		return list;
	}
	
	/** GET E SET **/
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaFisicaDao getPessoaFisicaDao() {
		return pessoaFisicaDao;
	}

	public void setPessoaFisicaDao(PessoaFisicaDao pessoaFisicaDao) {
		this.pessoaFisicaDao = pessoaFisicaDao;
	}

	public List<PessoaFisica> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
