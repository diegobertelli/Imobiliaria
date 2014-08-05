package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Imovel;
import dao.ImovelDao;
import enums.tipoImovelEnum;
import enums.ufEnum;

@ManagedBean
@ViewScoped
public class CadastroImovelController implements Serializable{

	private static final long serialVersionUID = 1L;

	private Imovel imovel;
	
	private ImovelDao imovelDao;
	
	private List<ufEnum> estados;
	
	private List<tipoImovelEnum> tipoImovel;
	
	public CadastroImovelController() {

	}
	
	/** METODOS **/
	
	@PostConstruct
	public void init(){
		this.imovelDao = new ImovelDao();
		verificaParametro();
	}
	
	private void verificaParametro() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imovel");  
		if(id == null || id.isEmpty()){
			this.imovel = new Imovel();
		}else{
			this.imovel = imovelDao.find(Long.valueOf(id));
		}
	}
	
	public String novoImovel() {
		/*PessoaDao pessoaDao = new PessoaDao();
		this.imovel.setPropietario(pessoaDao.find(new Long(prop)));*/
		this.imovelDao.create(this.imovel);
		return "cadastroImovel";
	}

	public String salvarImovel() {
		/*PessoaDao pessoaDao = new PessoaDao();
		this.imovel.setPropietario(pessoaDao.find(new Long(prop)));*/
		this.imovelDao.edit(this.imovel);
		
		this.imovel = new Imovel();
		
		return "cadastroImovel";
	}
	
	/** GET E SET **/ 
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ImovelDao getImovelDao() {
		return imovelDao;
	}

	public void setImovelDao(ImovelDao imovelDao) {
		this.imovelDao = imovelDao;
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
