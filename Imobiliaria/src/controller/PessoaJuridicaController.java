package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.PessoaJuridica;
import dao.PessoaJuridicaDao;

@ManagedBean
@RequestScoped
public class PessoaJuridicaController {
	
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	private PessoaJuridicaDao pessoaJuridicaDao = new PessoaJuridicaDao();

	public PessoaJuridicaController() {

	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public String novoPessoaJuridica() {
		
		this.pessoaJuridica.setTipoPessoa("juridica");
		
		this.pessoaJuridicaDao.create(this.pessoaJuridica);
		return "novaPessoaJuridica";
	}

	public String editarPessoaJuridica() {
		this.pessoaJuridicaDao.edit(this.pessoaJuridica);
		return "editSuccess";
	}

	public void removerPessoaJuridica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaJuridica");
		this.pessoaJuridicaDao.remove(this.pessoaJuridicaDao.find(id));
	}

	public void buscarPessoaJuridica(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoaJuridica");
		this.pessoaJuridica = this.pessoaJuridicaDao.find(id);
	}

	public List<PessoaJuridica> getListaPessoaJuridicas() {
		return this.pessoaJuridicaDao.findAll();
	}

	public List<SelectItem> getPessoaJuridicas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<PessoaJuridica> it = getListaPessoaJuridicas();
		for (int i = 0; i < it.size(); i++) {
			PessoaJuridica pessoaJuridica = it.get(i);
			list.add(new SelectItem(pessoaJuridica, pessoaJuridica.getId() + ""));
		}
		return list;
	}

	public PessoaJuridica buscarPorCNPJ(String codigo) {

		return null;
	}

}
