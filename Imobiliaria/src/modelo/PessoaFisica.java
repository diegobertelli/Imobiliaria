package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "datanascimento", nullable=false)
	private Date dataNascimento;
	
	@Basic(optional = false)
	@Column(name = "sexo", nullable=false)
	private String sexo;
	
	@Basic(optional = false)
	@Column(name = "rg", nullable=false)
	private String rg;
	
	@Basic(optional = false)
	@Column(name = "cpf", nullable=false)
	private String cpf;

	public PessoaFisica() {

	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof PessoaFisica)) {
	        return false;
	    }
	    PessoaFisica other = (PessoaFisica) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
