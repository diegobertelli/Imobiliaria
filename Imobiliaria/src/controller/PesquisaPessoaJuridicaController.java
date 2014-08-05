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

import modelo.PessoaJuridica;
import dao.PessoaJuridicaDao;

@ManagedBean
@ViewScoped
public class PesquisaPessoaJuridicaController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private PessoaJuridica pessoaJuridica;
	
	private PessoaJuridicaDao pessoaJuridicaDao;
	
	private List<PessoaJuridica> pessoasJuridicas;
	
	private String nome;
	
	public PesquisaPessoaJuridicaController() {

	}

	/** METODOS **/
	
	@PostConstruct
	public void init() {
		this.pessoaJuridica = new PessoaJuridica();
		this.pessoaJuridicaDao = new PessoaJuridicaDao();
		buscarListaPessoaJuridicas();
	}
	
	public void excluirPessoaJuridica() {
		this.pessoaJuridicaDao.remove(this.pessoaJuridica);
		buscarListaPessoaJuridicas();
		this.nome = null;
	}
	
	public void removerPessoaJuridica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaJuridica");
		this.pessoaJuridicaDao.remove(this.pessoaJuridicaDao.find(id));
	}

	public void buscarPessoaJuridica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaJuridica");
		this.pessoaJuridica = this.pessoaJuridicaDao.find(id);
	}

	public void buscarListaPessoaJuridicas() {
		try {
			this.pessoasJuridicas = this.pessoaJuridicaDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPorNome(AjaxBehaviorEvent event) {
		try {
			this.pessoasJuridicas = this.pessoaJuridicaDao.buscarPorNome(this.nome);
			this.nome = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getPessoaJuridicas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<PessoaJuridica> it = this.pessoaJuridicaDao.findAll();
		for (int i = 0; i < it.size(); i++) {
			PessoaJuridica pessoaJuridica = it.get(i);
			list.add(new SelectItem(pessoaJuridica, pessoaJuridica.getId() + ""));
		}
		return list;
	}
	
	/** GET E SET **/
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaJuridicaDao getPessoaJuridicaDao() {
		return pessoaJuridicaDao;
	}

	public void setPessoaJuridicaDao(PessoaJuridicaDao pessoaJuridicaDao) {
		this.pessoaJuridicaDao = pessoaJuridicaDao;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
