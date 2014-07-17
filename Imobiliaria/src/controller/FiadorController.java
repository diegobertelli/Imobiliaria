package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import modelo.Fiador;
import dao.FiadorDao;

@ManagedBean
@RequestScoped
public class FiadorController {

	private Fiador fiador = new Fiador();

	private String nome;

	private FiadorDao fiadorDao = new FiadorDao();

	private List<Fiador> fiadores;

	public FiadorController() {

		buscarListaFiadores();
		
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
		buscarListaFiadores();
	}

	/** METODOS **/

	public String novoFiador() {
		this.fiadorDao.create(this.fiador);
		return "newSuccess";
	}

	public String editarFiador() {
		this.fiadorDao.edit(this.fiador);

		this.fiador = new Fiador();

		return "editSuccess";
	}
	
	public void excluirFiador(){
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

	public void exibirErros(final AjaxBehaviorEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		List<FacesMessage> messages = context.getMessageList();
		if (messages.equals(null)) {
			
		} else {
			
		}
	}

	public void buscarListaFiadores() {
		if(this.nome == null){
			try {
				this.fiadores = this.fiadorDao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				this.fiadores = this.fiadorDao.buscarPorNome(this.nome);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void buscarPorNome(AjaxBehaviorEvent event) {
		try {
			/**this.fiadores = this.fiadorDao.buscarPorNome(this.nome);**/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
