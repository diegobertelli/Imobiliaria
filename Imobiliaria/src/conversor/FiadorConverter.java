package conversor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import modelo.Fiador;
import dao.FiadorDao;

@FacesConverter(forClass = Fiador.class)
public class FiadorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			Fiador fiador = new FiadorDao().find(Long.valueOf(arg2));
			return fiador;
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage( String.format("Cannot convert %s to Company", arg2)), e);
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Fiador fiador = (Fiador) arg2;
		return String.valueOf(fiador.getId());
	}

}
