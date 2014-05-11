package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Transacao;
import dao.TransacaoDao;

@ManagedBean
@RequestScoped
public class TransacaoController {
	
	private Transacao transacao = new Transacao();
	
	private TransacaoDao transacaoDao = new TransacaoDao();

	public TransacaoController() {

	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	public String novoTransacao() {
		this.transacaoDao.create(this.transacao);
		return "newSuccess";
	}

	public String editarTransacao() {
		this.transacaoDao.edit(this.transacao);
		return "editSuccess";
	}

	public void removerTransacao(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codTransacao");
		this.transacaoDao.remove(this.transacaoDao.find(id));
	}

	public void buscarTransacao(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codTransacao");
		this.transacao = this.transacaoDao.find(id);
	}

	public List<Transacao> getListaTransacaos() {
		return this.transacaoDao.findAll();
	}

	public List<SelectItem> getTransacaos() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Transacao> it = getListaTransacaos();
		for (int i = 0; i < it.size(); i++) {
			Transacao transacao = it.get(i);
			list.add(new SelectItem(transacao, transacao.getId() + ""));
		}
		return list;
	}

}
