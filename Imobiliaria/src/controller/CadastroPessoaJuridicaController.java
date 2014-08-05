package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.PessoaJuridica;
import dao.PessoaJuridicaDao;

@ManagedBean
@ViewScoped
public class CadastroPessoaJuridicaController implements Serializable{

	private static final long serialVersionUID = 1L;

	private PessoaJuridica pessoaJuridica;

	private PessoaJuridicaDao pessoaJuridicaDao;

	/** METODOS **/

	@PostConstruct
	public void init() {
		this.pessoaJuridicaDao = new PessoaJuridicaDao();
		verificaParametro();
	}

	private void verificaParametro() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("pessoaJuridica");
		if (id == null || id.isEmpty()) {
			this.pessoaJuridica = new PessoaJuridica();
		} else {
			this.pessoaJuridica = pessoaJuridicaDao.find(Long.valueOf(id));
		}
	}

	public String novoPessoaJuridica() {

		this.pessoaJuridica.setTipoPessoa("fisica");

		this.pessoaJuridicaDao.create(this.pessoaJuridica);

		return "cadastroPessoaJuridica";
	}

	public String salvarPessoaJuridica() {
		this.pessoaJuridica.setTipoPessoa("fisica");

		this.pessoaJuridicaDao.edit(this.pessoaJuridica);

		this.pessoaJuridica = new PessoaJuridica();

		return "cadastroPessoaJuridica";
	}

	/** GET E SET **/

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaJuridicaDao getPessoaJuridicaDao() {
		return pessoaJuridicaDao;
	}

	public void setPessoaJuridicaDao(PessoaJuridicaDao pessoaJuridicaDao) {
		this.pessoaJuridicaDao = pessoaJuridicaDao;
	}

}
