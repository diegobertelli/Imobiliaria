package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import modelo.Pessoa;
import dao.PessoaDao;

@ManagedBean
@RequestScoped
public class PessoaController {
	
	private Pessoa pessoa = new Pessoa();
	
	private PessoaDao pessoaDao = new PessoaDao();
	
	private boolean exibeFisica = false;
	private boolean exibeJuridica = false;
	private String tipoPessoa;

	public PessoaController() {

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String novoPessoa(Pessoa pessoa) {
		this.pessoaDao.create(pessoa);
		return "newSuccess";
	}

	public String editarPessoa() {
		this.pessoaDao.edit(this.pessoa);
		return "editSuccess";
	}

	public void removerPessoa(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoa");
		this.pessoaDao.remove(this.pessoaDao.find(id));
	}

	public void buscarPessoa(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPessoa");
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
	
	public void tipoPessoa(ValueChangeEvent event){
		
		this.setTipoPessoa(event.getNewValue().toString());
		
		if(this.getTipoPessoa().equals("fisica")){
			
			this.setExibeFisica(true);
			this.setExibeJuridica(false);
			
		}else{
			
			this.setExibeJuridica(true);
			this.setExibeFisica(false);
			
		}
	}

	public boolean isExibeFisica() {
		return exibeFisica;
	}

	public void setExibeFisica(boolean exibeFisica) {
		this.exibeFisica = exibeFisica;
	}

	public boolean isExibeJuridica() {
		return exibeJuridica;
	}

	public void setExibeJuridica(boolean exibeJuridica) {
		this.exibeJuridica = exibeJuridica;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	

}
