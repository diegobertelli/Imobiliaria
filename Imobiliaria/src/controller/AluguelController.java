package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Aluguel;
import dao.AluguelDao;

@ManagedBean
@RequestScoped
public class AluguelController {

	private Aluguel aluguel = new Aluguel();

	private AluguelDao aluguelDao = new AluguelDao();

	public AluguelController() {

	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public String novoAluguel() {
		this.aluguelDao.create(this.aluguel);
		return "newSuccess";
	}

	public String editarAluguel() {
		this.aluguelDao.edit(this.aluguel);
		return "editSuccess";
	}

	public void removerAluguel(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codAluguel");
		this.aluguelDao.remove(this.aluguelDao.find(id));
	}

	public void buscarAluguel(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codAluguel");
		this.aluguel = this.aluguelDao.find(id);
	}

	public List<Aluguel> getListaAluguels() {
		return this.aluguelDao.findAll();
	}

	public List<SelectItem> getAluguels() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Aluguel> it = getListaAluguels();
		for (int i = 0; i < it.size(); i++) {
			Aluguel aluguel = it.get(i);
			list.add(new SelectItem(aluguel, aluguel.getId() + ""));
		}
		return list;
	}

}
