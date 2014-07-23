package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Fiador;
import dao.FiadorDao;

@ManagedBean
@ViewScoped
public class CadastroFiadorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Fiador fiador;

	private FiadorDao fiadorDao;

	/** METODOS **/

	@PostConstruct
	public void init() {
		this.fiadorDao = new FiadorDao();
		verificaParametro();
	}
	
	private void verificaParametro() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("fiador");  
		if(id == null || id.isEmpty()){
			this.fiador = new Fiador();
		}else{
			this.fiador = fiadorDao.find(Long.valueOf(id));
		}
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
