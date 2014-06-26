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

@FacesConverter("PessoaDocConverter")
public class PessoaDocConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if(value.length() <= 11){
			return new PessoaFisicaDao().buscarPorCPF(value);
		}else{
			return new PessoaJuridicaDao().buscarPorCNPJ(value);
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		Pessoa pessoa = (Pessoa) value;
		if(pessoa instanceof PessoaFisica){
			PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
			String cpf = pessoaFisica.getCpf();
			System.out.println(cpf);
	        return cpf;
		}
		if(pessoa instanceof PessoaJuridica){
			PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
			String cnpj = pessoaJuridica.getCnpj();
			System.out.println(cnpj);
	        return cnpj;
		}
		return null;
		
	}

}
