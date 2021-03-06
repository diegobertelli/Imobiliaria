package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Funcionario;
import dao.FuncionarioDao;

@ManagedBean
@SessionScoped
public class FuncionarioController {

	private Funcionario funcionario = new Funcionario();
	
	private FuncionarioDao funcionarioDao = new FuncionarioDao();
	
	private String usuario;
	private String senha;
	private String confirmaSenha;

	public FuncionarioController() {

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String novoFuncionario() {
		
		if(this.funcionario.getSenha().equals(this.confirmaSenha)){
			this.funcionario.setTipoPessoa("funcionario");
			this.funcionarioDao.create(this.funcionario);
			return "login";
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("A senha n�o foi confirmada corretamente.");
			context.addMessage(null, facesMessage);
			return null;
		}
		
	}

	public String editarFuncionario() {
		this.funcionario.setTipoPessoa("funcionario");
		this.funcionarioDao.edit(this.funcionario);
		return "login";
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
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public String validarUsuario(){
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		try {
			this.funcionario = funcionarioDao.buscarPorLogin(this.usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!this.funcionario.equals(null)){
		
			if(this.usuario.equals(this.funcionario.getLogin()) && this.senha.equals(this.funcionario.getSenha()) ){
				
				return"principal";
				
			}else{
				return "login";
			}
		}else{
			
			return "login";
			
		}
		
	}
	
	public String cadastrarUsuario(){
		
		this.funcionario = new Funcionario();
		
		return "novoFuncionario";
		
	}

	public boolean confirmarSenha(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(this.funcionario.getSenha().equals(this.confirmaSenha)){
			return true;
		}else{
			FacesMessage facesMessage = new FacesMessage("A senha n�o foi confirmada corretamente.");
			context.addMessage(null, facesMessage);
			return false;
		}
	}

	
}
