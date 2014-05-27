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
	
	private String usuario;
	private String senha;

	public FuncionarioController() {

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String novoFuncionario() {
		this.funcionario.setTipoPessoa("funcionario");
		this.funcionarioDao.create(this.funcionario);
		return "login";
	}

	public String editarFuncionario() {
		this.funcionarioDao.edit(this.funcionario);
		return "editSuccess";
	}

	public void removerFuncionario(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codFuncionario");
		this.funcionarioDao.remove(this.funcionarioDao.find(id));
	}

	public void buscarFuncionario(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codFuncionario");
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String validarUsuario(){
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario func = null;
		
		try {
			func = funcionarioDao.buscarPorLogin(this.usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!func.equals(null)){
		
			if(this.usuario.equals(func.getLogin()) && this.senha.equals(func.getSenha()) ){
				
				return"principal";
				
			}else{
				return "login";
			}
		}else{
			
			return "login";
			
		}
		
	}
	
	public String cadastrarUsuario(){
		
		return "novoFuncionario";
		
	}
	
}
