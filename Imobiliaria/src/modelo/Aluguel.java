package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aluguel")
public class Aluguel extends Transacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datafim", nullable=false)
	private Date dataFimContrato;
	
	@Basic(optional = false)
	@Column(name = "diavencimento", nullable=false)
	private int diaVencimento;
	
	@ManyToOne
	@JoinColumn(name = "id_fiador")
	private Fiador fiador;

	/**
	 * 
	 */
	public Aluguel() {

	}

	/**
	 * @return the dataFimContrato
	 */
	public Date getDataFimContrato() {
		return dataFimContrato;
	}

	/**
	 * @param dataFimContrato the dataFimContrato to set
	 */
	public void setDataFimContrato(Date dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}

	/**
	 * @return the diaVencimento
	 */
	public int getDiaVencimento() {
		return diaVencimento;
	}

	/**
	 * @param diaVencimento the diaVencimento to set
	 */
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	/**
	 * @return the fiador
	 */
	public Fiador getFiador() {
		return fiador;
	}

	/**
	 * @param fiador the fiador to set
	 */
	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Aluguel)) {
	        return false;
	    }
	    Aluguel other = (Aluguel) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
