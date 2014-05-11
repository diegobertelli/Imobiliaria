package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fiador")
public class Fiador extends PessoaFisica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "renda", nullable=false)
	private BigDecimal renda;
	
	public Fiador() {

	}

	/**
	 * @return the renda
	 */
	public BigDecimal getRenda() {
		return renda;
	}

	/**
	 * @param renda the renda to set
	 */
	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Fiador)) {
	        return false;
	    }
	    Fiador other = (Fiador) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
