package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Fiador;
import dao.FiadorDao;

@ManagedBean
@RequestScoped
public class FiadorController {
	
	private Fiador fiador = new Fiador();
	
	private FiadorDao fiadorDao = new FiadorDao();
	
	public FiadorController() {
		
		
	}

	public Fiador getFiador() {
		return fiador;
	}

	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}
	
	public String novoFiador() {
		this.fiadorDao.create(this.fiador);
		return "newSuccess";
	}

	public String editarFiador() {
		this.fiadorDao.edit(this.fiador);
		return "editSuccess";
	}

	public void removerFiador(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFiador");
		this.fiadorDao.remove(this.fiadorDao.find(id));
	}

	public void buscarFiador(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFiador");
		this.fiador = this.fiadorDao.find(id);
	}

	public List<Fiador> getListaFiadors() {
		return this.fiadorDao.findAll();
	}

	public List<SelectItem> getFiadors() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Fiador> it = getListaFiadors();
		for (int i = 0; i < it.size(); i++) {
			Fiador fiador = it.get(i);
			list.add(new SelectItem(fiador, fiador.getId() + ""));
		}
		return list;
	}

}
