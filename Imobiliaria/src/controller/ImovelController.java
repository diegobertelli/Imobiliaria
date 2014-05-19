package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import modelo.Imovel;
import dao.ImovelDao;
import enums.tipoImovelEnum;
import enums.ufEnum;

@ManagedBean
@RequestScoped
public class ImovelController {
	
	private Imovel imovel = new Imovel();
	
	private ImovelDao imovelDao = new ImovelDao();
	
	private List<ufEnum> estados;
	
	private List<tipoImovelEnum> tipoImovel;
	
	public ImovelController() {

	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public String novoImovel() {
		this.imovelDao.create(this.imovel);
		return "newSuccess";
	}

	public String editarImovel() {
		this.imovelDao.edit(this.imovel);
		return "editSuccess";
	}

	public void removerImovel(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codImovel");
		this.imovelDao.remove(this.imovelDao.find(id));
	}

	public void buscarImovel(ActionEvent e) {
		String id = (String) e.getComponent().getAttributes().get("codImovel");
		this.imovel = this.imovelDao.find(id);
	}

	public List<Imovel> getListaImovels() {
		return this.imovelDao.findAll();
	}

	public List<SelectItem> getImovels() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Imovel> it = getListaImovels();
		for (int i = 0; i < it.size(); i++) {
			Imovel imovel = it.get(i);
			list.add(new SelectItem(imovel, imovel.getId() + ""));
		}
		return list;
	}
	
	public List<ufEnum> getEstados() {
		return Arrays.asList(ufEnum.values());
	}

	public void setEstados(List<ufEnum> estados) {
		this.estados = estados;
	}

	public List<tipoImovelEnum> getTipoImovel() {
		return Arrays.asList(tipoImovelEnum.values());
	}

	public void setTipoImovel(List<tipoImovelEnum> tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
}
