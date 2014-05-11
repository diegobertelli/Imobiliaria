package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "transacao")
public class Transacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable=false)
	private Date dataVenda = new java.sql.Date(System.currentTimeMillis());
	
	@Basic(optional = false)
	@Column(name = "valor", nullable=false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Pessoa cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_imovel")
	private Imovel imovel;
	
	@OneToMany(mappedBy= "transacao")
	private List<Pagamento> pagamentos;
	
	public Transacao() {

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
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}

	/**
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
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
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the cliente
	 */
	public Pessoa getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the imovel
	 */
	public Imovel getImovel() {
		return imovel;
	}

	/**
	 * @param imovel the imovel to set
	 */
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Transacao)) {
	        return false;
	    }
	    Transacao other = (Transacao) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}

}
