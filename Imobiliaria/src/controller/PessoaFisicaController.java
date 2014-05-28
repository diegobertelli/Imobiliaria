package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.PessoaFisica;
import dao.PessoaFisicaDao;

@ManagedBean
@RequestScoped
public class PessoaFisicaController {
	
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
	private PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao();

	public PessoaFisicaController() {

	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public String novoPessoaFisica() {
		
		this.pessoaFisica.setTipoPessoa("fisica");
			
		this.pessoaFisicaDao.create(this.pessoaFisica);
		
		return "novaPessoaFisica";
	}

	public String editarPessoaFisica() {
		this.pessoaFisica.setTipoPessoa("fisica");
		
		this.pessoaFisicaDao.edit(this.pessoaFisica);
		
		this.pessoaFisica = new PessoaFisica();
		return "novaPessoaFisica";
	}

	public void removerPessoaFisica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaFisica");
		this.pessoaFisicaDao.remove(this.pessoaFisicaDao.find(id));
	}

	public void buscarPessoaFisica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaFisica");
		this.pessoaFisica = this.pessoaFisicaDao.find(id);
	}

	public List<PessoaFisica> getListaPessoaFisicas() {
		return this.pessoaFisicaDao.findAll();
	}

	public List<SelectItem> getPessoaFisicas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<PessoaFisica> it = getListaPessoaFisicas();
		for (int i = 0; i < it.size(); i++) {
			PessoaFisica pessoaFisica = it.get(i);
			list.add(new SelectItem(pessoaFisica, pessoaFisica.getId() + ""));
		}
		return list;
	}

}
