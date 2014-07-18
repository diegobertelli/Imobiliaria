package conversor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("MoedaConverter")
public class MoedaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		value = value.replaceAll("[R$.]", "");
		value = value.replaceAll("[,]", ".");

		BigDecimal valor = new BigDecimal(Double.parseDouble(value));

		return valor;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		return df.format(value);
		
	}

}
