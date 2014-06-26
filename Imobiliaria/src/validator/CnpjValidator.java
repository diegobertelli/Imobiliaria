package validator;

import java.text.Normalizer;
import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.CnpjValidator")
public class CnpjValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		if (!validaCnpj(String.valueOf(value))) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CNPJ inv�lido!"); 
			throw new ValidatorException(message);
		}
	
	}

	private boolean validaCnpj(String cnpj) {

			// considera-se erro CPF's formados por uma sequencia de numeros iguais

			if (cnpj == null) {
				return false;
			}

			cnpj = retiraMascaraCpfCnpj(cnpj);

			if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
					|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
					|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
					|| cnpj.equals("99999999999999") || (cnpj.length() != 14)) {
				return false;
			}

			char dig13, dig14;
			int sm, i, r, num, peso;

			// "try" - protege o codigo para eventuais erros de conversao de tipo
			// (int)

			try {
				// Calculo do 1o. Digito Verificador
				sm = 0;
				peso = 2;

				for (i = 11; i >= 0; i--) {
					// converte o i-ésimo caractere do CNPJ em um número:
					// por exemplo, transforma o caractere '0' no inteiro 0
					// (48 eh a posição de '0' na tabela ASCII)
					num = cnpj.charAt(i) - 48;
					sm = sm + (num * peso);
					peso = peso + 1;
					if (peso == 10) {
						peso = 2;
					}
				}

				r = sm % 11;
				if ((r == 0) || (r == 1)) {
					dig13 = '0';
				} else {
					dig13 = (char) ((11 - r) + 48);
				}

				// converte no respectivo caractere numerico
				// Calculo do 2o. Digito Verificador
				sm = 0;
				peso = 2;

				for (i = 12; i >= 0; i--) {
					num = cnpj.charAt(i) - 48;
					sm = sm + (num * peso);
					peso = peso + 1;
					if (peso == 10) {
						peso = 2;
					}
				}

				r = sm % 11;

				if ((r == 0) || (r == 1)) {
					dig14 = '0';
				} else {
					dig14 = (char) ((11 - r) + 48);
				}

				// Verifica se os digitos calculados conferem com os digitos
				// informados.
				if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
					return true;
				} else {
					return false;
				}
			} catch (InputMismatchException erro) {
				return false;
			}
		
	}
	
	public static String retiraMascaraCpfCnpj(final String valor) {

		if (!validaString(valor)) {
			return "";
		}

		String novaStringFmt = Normalizer.normalize(valor, Normalizer.Form.NFD);
		novaStringFmt = retiraString(valor);
		return novaStringFmt;
	}
	
	public static boolean validaString(String arg) {
		return arg != null && !"".equals(arg);
	}
	
	public static String retiraString(final String valor) {
		String retorno;
		if (null == valor) {
			retorno = null;
		} else {
			String novaStringFmt = Normalizer.normalize(valor, Normalizer.Form.NFD);
			novaStringFmt = valor.replaceAll("[^0-9]", "");
			retorno = novaStringFmt;
		}
		return retorno;
	}

}
