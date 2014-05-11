package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Pessoa;
import dao.PessoaDao;

@ManagedBean
@RequestScoped
public class PessoaController {
	
	private Pessoa pessoa = new Pessoa();
	
	private PessoaDao pessoaDao = new PessoaDao();

	public PessoaController() {

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String novoPessoa() {
		this.pessoaDao.create(this.pessoa);
		return "newSuccess";
	}

	public String editarPessoa() {
		this.pessoaDao.edit(this.pessoa);
		return "editSuccess";
	}

	public void removerPessoa(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codPessoa");
		this.pessoaDao.remove(this.pessoaDao.find(id));
	}

	public void buscarPessoa(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codPessoa");
		this.pessoa = this.pessoaDao.find(id);
	}

	public List<Pessoa> getListaPessoas() {
		return this.pessoaDao.findAll();
	}

	public List<SelectItem> getPessoas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Pessoa> it = getListaPessoas();
		for (int i = 0; i < it.size(); i++) {
			Pessoa pessoa = it.get(i);
			list.add(new SelectItem(pessoa, pessoa.getId() + ""));
		}
		return list;
	}

}
