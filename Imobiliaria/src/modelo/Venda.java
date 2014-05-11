package modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda extends Transacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "financeira", nullable=false)
	private String financeira;
	
	@Basic(optional = false)
	@Column(name = "parcelas", nullable=false)
	private int parcelas;

	/**
	 * 
	 */
	public Venda() {

	}

	/**
	 * @return the financeira
	 */
	public String getFinanceira() {
		return financeira;
	}

	/**
	 * @param financeira the financeira to set
	 */
	public void setFinanceira(String financeira) {
		this.financeira = financeira;
	}

	/**
	 * @return the parcelas
	 */
	public int getParcelas() {
		return parcelas;
	}

	/**
	 * @param parcelas the parcelas to set
	 */
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Venda)) {
	        return false;
	    }
	    Venda other = (Venda) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
