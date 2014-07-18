package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import modelo.Fiador;
import dao.FiadorDao;

@ManagedBean
@ViewScoped
public class PesquisaFiadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fiador fiador = new Fiador();

	private String nome;

	private FiadorDao fiadorDao;

	private List<Fiador> fiadores;

	public PesquisaFiadorController() {

	}

	/** METODOS **/

	@PostConstruct
	public void init() {
		this.fiador = new Fiador();
		this.fiadorDao = new FiadorDao();
		buscarListaFiadores();
	}

	public void excluirFiador() {
		this.fiadorDao.remove(this.fiador);
	}

	public void removerFiador(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFiador");
		this.fiadorDao.remove(this.fiadorDao.find(id));
	}

	public void buscarFiador(ActionEvent e) {
		Long id = (Long) e.getComponent().getAttributes().get("codFiador");
		this.fiador = this.fiadorDao.find(id);
	}
	
	public void buscarListaFiadores() {
		try {
			this.fiadores = this.fiadorDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarPorNome(AjaxBehaviorEvent event) {
		try {
			this.fiadores = this.fiadorDao.buscarPorNome(this.nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exibirErros(final AjaxBehaviorEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		List<FacesMessage> messages = context.getMessageList();
		if (messages.equals(null)) {

		} else {

		}
	}

	/** GET E SET **/

	public Fiador getFiador() {
		return fiador;
	}

	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}

	public List<Fiador> getFiadores() {
		return fiadores;
	}

	public void setFiadores(List<Fiador> fiadores) {
		this.fiadores = fiadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
