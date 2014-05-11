package modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends PessoaFisica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "login", nullable=false)
	private String login;
	
	@Basic(optional = false)
	@Column(name = "senha", nullable=false)
	private String senha;
	
	public Funcionario() {

	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Funcionario)) {
	        return false;
	    }
	    Funcionario other = (Funcionario) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
