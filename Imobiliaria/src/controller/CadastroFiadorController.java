package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import dao.FiadorDao;
import modelo.Fiador;

@ManagedBean
@ViewScoped
public class CadastroFiadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fiador fiador;

	private FiadorDao fiadorDao;

	/** METODOS **/

	@PostConstruct
	public void init() {
		this.fiador = new Fiador();
		this.fiadorDao = new FiadorDao();
	}

	public String novoFiador() {
		this.fiadorDao.create(this.fiador);
		return "cadastroFiador";
	}

	public String editarFiador() {
		this.fiadorDao.edit(this.fiador);
		this.fiador = new Fiador();
		return "cadastroFiador";
	}

	/** GET E SET **/

	public Fiador getFiador() {
		return fiador;
	}

	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}

	public FiadorDao getFiadorDao() {
		return fiadorDao;
	}

	public void setFiadorDao(FiadorDao fiadorDao) {
		this.fiadorDao = fiadorDao;
	}

}
