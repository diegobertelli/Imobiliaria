package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enums.TipoPessoaEnum;

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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "fiador")
	private List<Aluguel> alugueis;
	
	public Fiador() {
		this.setTipoPessoa(TipoPessoaEnum.fisica.toString());
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
