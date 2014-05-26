package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Pagamento;
import dao.PagamentoDao;

@ManagedBean
@RequestScoped
public class PagamentoController {
	
	private Pagamento pagamento = new Pagamento();
	
	private PagamentoDao pagamentoDao =  new PagamentoDao();

	public PagamentoController() {

	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public String novoPagamento() {
		this.pagamentoDao.create(this.pagamento);
		return "newSuccess";
	}

	public String editarPagamento() {
		this.pagamentoDao.edit(this.pagamento);
		return "editSuccess";
	}

	public void removerPagamento(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPagamento");
		this.pagamentoDao.remove(this.pagamentoDao.find(id));
	}

	public void buscarPagamento(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codPagamento");
		this.pagamento = this.pagamentoDao.find(id);
	}

	public List<Pagamento> getListaPagamentos() {
		return this.pagamentoDao.findAll();
	}

	public List<SelectItem> getPagamentos() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Pagamento> it = getListaPagamentos();
		for (int i = 0; i < it.size(); i++) {
			Pagamento pagamento = it.get(i);
			list.add(new SelectItem(pagamento, pagamento.getId() + ""));
		}
		return list;
	}

}
