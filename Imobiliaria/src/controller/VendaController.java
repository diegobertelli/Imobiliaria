package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Venda;
import dao.VendaDao;

@ManagedBean
@RequestScoped
public class VendaController {
	
	private Venda venda = new Venda();
	
	private VendaDao vendaDao = new VendaDao();

	public VendaController() {

	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public String novoVenda() {
		this.vendaDao.create(this.venda);
		return "newSuccess";
	}

	public String editarVenda() {
		this.vendaDao.edit(this.venda);
		return "editSuccess";
	}

	public void removerVenda(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codVenda");
		this.vendaDao.remove(this.vendaDao.find(id));
	}

	public void buscarVenda(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codVenda");
		this.venda = this.vendaDao.find(id);
	}

	public List<Venda> getListaVendas() {
		return this.vendaDao.findAll();
	}

	public List<SelectItem> getVendas() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Venda> it = getListaVendas();
		for (int i = 0; i < it.size(); i++) {
			Venda venda = it.get(i);
			list.add(new SelectItem(venda, venda.getId() + ""));
		}
		return list;
	}

}
