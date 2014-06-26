package valida;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator (value="CpfValidator")
public class CpfValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		if (!validaCpf(String.valueOf(value))) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(ResourceBundle.getBundle(FacesContext.getCurrentInstance().getApplication().getMessageBundle()).getString("erro.validacao.cpf"));
            throw new ValidatorException(message);
       }
		
	}
	
	private static boolean validaCpf(String cpf){
		
		
		return false;
		
	}

}
