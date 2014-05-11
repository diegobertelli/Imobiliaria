package modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoajuridica")
public class PessoaJuridica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "razaosocial", nullable=false)
	private String razaoSocial;
	
	@Basic(optional = false)
	@Column(name = "cnpj", nullable=false)
	private String cnpj;
	
	@Basic(optional = false)
	@Column(name = "ie", nullable=false)
	private String ie;

	public PessoaJuridica() {

	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the ie
	 */
	public String getIe() {
		return ie;
	}

	/**
	 * @param ie the ie to set
	 */
	public void setIe(String ie) {
		this.ie = ie;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof PessoaJuridica)) {
	        return false;
	    }
	    PessoaJuridica other = (PessoaJuridica) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}
	

}
