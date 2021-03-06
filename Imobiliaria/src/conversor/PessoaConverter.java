package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import dao.PessoaFisicaDao;
import dao.PessoaJuridicaDao;

@FacesConverter("PessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
				
		if(value.length() <= 11){
			PessoaFisica pessoaFisica = null;
			try {
				pessoaFisica = new PessoaFisicaDao().buscarPorCPF(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return pessoaFisica;
		}else{
			PessoaJuridica pessoaJuridica = null;
			try {
				pessoaJuridica = new PessoaJuridicaDao().buscarPorCNPJ(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return pessoaJuridica;
		}
				
				/*PessoaDao().find(new Long(value));*/
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		Pessoa pessoa = (Pessoa) value;
		if(pessoa instanceof PessoaFisica){
			PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
			String cpf = pessoaFisica.getCpf();
	        return cpf;
		}
		if(pessoa instanceof PessoaJuridica){
			PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
			String cnpj = pessoaJuridica.getCnpj();
	        return cnpj;
		}
		return null;
		
	}
	
	

}
