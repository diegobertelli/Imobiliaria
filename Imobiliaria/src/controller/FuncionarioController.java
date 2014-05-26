package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Funcionario;
import dao.FuncionarioDao;

@ManagedBean
@RequestScoped
public class FuncionarioController {

	private Funcionario funcionario = new Funcionario();
	
	private FuncionarioDao funcionarioDao = new FuncionarioDao();

	public FuncionarioController() {

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String novoFuncionario() {
		this.funcionarioDao.create(this.funcionario);
		return "newSuccess";
	}

	public String editarFuncionario() {
		this.funcionarioDao.edit(this.funcionario);
		return "editSuccess";
	}

	public void removerFuncionario(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFuncionario");
		this.funcionarioDao.remove(this.funcionarioDao.find(id));
	}

	public void buscarFuncionario(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFuncionario");
		this.funcionario = this.funcionarioDao.find(id);
	}

	public List<Funcionario> getListaFuncionarios() {
		return this.funcionarioDao.findAll();
	}

	public List<SelectItem> getFuncionarios() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Funcionario> it = getListaFuncionarios();
		for (int i = 0; i < it.size(); i++) {
			Funcionario funcionario = it.get(i);
			list.add(new SelectItem(funcionario, funcionario.getId() + ""));
		}
		return list;
	}
	
}
