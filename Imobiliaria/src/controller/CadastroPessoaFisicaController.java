package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.PessoaFisica;
import dao.PessoaFisicaDao;

@ManagedBean
@ViewScoped
public class CadastroPessoaFisicaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaFisica pessoaFisica;

	private PessoaFisicaDao pessoaFisicaDao;

	/** METODOS **/

	@PostConstruct
	public void init() {
		this.pessoaFisicaDao = new PessoaFisicaDao();
		verificaParametro();
	}

	private void verificaParametro() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("pessoaFisica");
		if (id == null || id.isEmpty()) {
			this.pessoaFisica = new PessoaFisica();
		} else {
			this.pessoaFisica = pessoaFisicaDao.find(Long.valueOf(id));
		}
	}

	public String novoPessoaFisica() {

		this.pessoaFisica.setTipoPessoa("fisica");

		this.pessoaFisicaDao.create(this.pessoaFisica);

		return "cadastroPessoaFisica";
	}

	public String salvarPessoaFisica() {
		this.pessoaFisica.setTipoPessoa("fisica");

		this.pessoaFisicaDao.edit(this.pessoaFisica);

		this.pessoaFisica = new PessoaFisica();
		
		return "cadastroPessoaFisica";
	}
	
	/** GET E SET **/
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaFisicaDao getPessoaFisicaDao() {
		return pessoaFisicaDao;
	}

	public void setPessoaFisicaDao(PessoaFisicaDao pessoaFisicaDao) {
		this.pessoaFisicaDao = pessoaFisicaDao;
	}

}
