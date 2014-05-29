package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean
@RequestScoped
public class EmailController {

	private String nome;
	
	private String email;
	
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String EnviarEmail(){
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		//email.setSmtpPort(465);
		email.setAuthentication("zigbertelli@gmail.com", "ColoqueSuaSenha");
		email.setSSLOnConnect(true);
		try {
			email.setFrom(this.getEmail(), this.getNome());
			email.setMsg(this.getMensagem());
			email.addTo("zigbertelli@gmail.com");
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}	
		
		return "principal";
	}
	
}
