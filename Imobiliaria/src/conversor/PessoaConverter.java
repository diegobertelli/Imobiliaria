package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Pessoa;
import dao.PessoaDao;

@FacesConverter("PessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		return new PessoaDao().find(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Pessoa pessoa = (Pessoa) value;
        return pessoa.getId()+"";
	}
	
	

}
