package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "codcontacorrente", nullable=false)
	private int codContaCorrente;
	
	@Column(name = "datapagamento", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;
	
	@Column(name = "datavencimento", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVencimento;
	
	@Basic(optional = false)
	@Column(name = "valor", nullable=false)
	private BigDecimal valor;
	
	@Basic(optional = false)
	@Column(name = "juros", nullable=false)
	private BigDecimal juros;
	
	@Basic(optional = false)
	@Column(name = "multa", nullable=false)
	private BigDecimal multa;
	
	@JoinColumn(name = "id_transacao", referencedColumnName="id", nullable=false)
	@ManyToOne
	private Transacao transacao;

	/**
	 * 
	 */
	public Pagamento() {
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codContaCorrente
	 */
	public int getCodContaCorrente() {
		return codContaCorrente;
	}

	/**
	 * @param codContaCorrente the codContaCorrente to set
	 */
	public void setCodContaCorrente(int codContaCorrente) {
		this.codContaCorrente = codContaCorrente;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the juros
	 */
	public BigDecimal getJuros() {
		return juros;
	}

	/**
	 * @param juros the juros to set
	 */
	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	/**
	 * @return the multa
	 */
	public BigDecimal getMulta() {
		return multa;
	}

	/**
	 * @param multa the multa to set
	 */
	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	/**
	 * @return the transacao
	 */
	public Transacao getTransacao() {
		return transacao;
	}

	/**
	 * @param transacao the transacao to set
	 */
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Pagamento)) {
	        return false;
	    }
	    Pagamento other = (Pagamento) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
