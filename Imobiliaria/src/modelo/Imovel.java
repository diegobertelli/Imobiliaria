package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "numeroescritura", nullable=false)
	private String numeroEscritura;
	
	@Basic(optional = false)
	@Column(name = "endereco", nullable=false)
	private String endereco;
	
	@Basic(optional = false)
	@Column(name = "uf", nullable=false)
	private String uf;
	
	@Basic(optional = false)
	@Column(name = "cep", nullable=false)
	private String cep;
	
	@Basic(optional = false)
	@Column(name = "bairro", nullable=false)
	private String bairro;
	
	@Basic(optional = false)
	@Column(name = "cidade", nullable=false)
	private String cidade;
	
	@Basic(optional = false)
	@Column(name = "tamanho", nullable=false)
	private String tamanho;
	
	@Basic(optional = false)
	@Column(name = "quartos", nullable=false)
	private int quartos;

	@Basic(optional = false)
	@Column(name = "salas", nullable=false)
	private int salas;
	
	@Basic(optional = false)
	@Column(name = "banheiros", nullable=false)
	private int banheiros;
	
	@Basic(optional = false)
	@Column(name = "vagasgaragem", nullable=false)
	private int vagasGaragem;
	
	@Basic(optional = false)
	@Column(name = "situacao", nullable=false)
	private String situacao;
	
	@Basic(optional = false)
	@Column(name = "finalidade", nullable=false)
	private String finalidade;
	
	@Basic(optional = false)
	@Column(name = "tipoimovel", nullable=false)
	private String tipoImovel;
	
	@Basic(optional = false)
	@Column(name = "valorimovel", nullable=false)
	private BigDecimal valorImovel;
	
	@Basic(optional = false)
	@Column(name = "valoriptu", nullable=false)
	private BigDecimal valorIptu;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Pessoa propietario;

	@OneToMany(mappedBy = "imovel")
	private List<Transacao> transacoes;

	public Imovel() {

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
	 * @return the numeroEscritura
	 */
	public String getNumeroEscritura() {
		return numeroEscritura;
	}

	/**
	 * @param numeroEscritura the numeroEscritura to set
	 */
	public void setNumeroEscritura(String numeroEscritura) {
		this.numeroEscritura = numeroEscritura;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the tamanho
	 */
	public String getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * @return the quartos
	 */
	public int getQuartos() {
		return quartos;
	}

	/**
	 * @param quartos the quartos to set
	 */
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	/**
	 * @return the salas
	 */
	public int getSalas() {
		return salas;
	}

	/**
	 * @param salas the salas to set
	 */
	public void setSalas(int salas) {
		this.salas = salas;
	}

	/**
	 * @return the banheiros
	 */
	public int getBanheiros() {
		return banheiros;
	}

	/**
	 * @param banheiros the banheiros to set
	 */
	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}

	/**
	 * @return the vagasGaragem
	 */
	public int getVagasGaragem() {
		return vagasGaragem;
	}

	/**
	 * @param vagasGaragem the vagasGaragem to set
	 */
	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the finalidade
	 */
	public String getFinalidade() {
		return finalidade;
	}

	/**
	 * @param finalidade the finalidade to set
	 */
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	/**
	 * @return the tipoImovel
	 */
	public String getTipoImovel() {
		return tipoImovel;
	}

	/**
	 * @param tipoImovel the tipoImovel to set
	 */
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	/**
	 * @return the valorImovel
	 */
	public BigDecimal getValorImovel() {
		return valorImovel;
	}

	/**
	 * @param valorImovel the valorImovel to set
	 */
	public void setValorImovel(BigDecimal valorImovel) {
		this.valorImovel = valorImovel;
	}

	/**
	 * @return the valorIptu
	 */
	public BigDecimal getValorIptu() {
		return valorIptu;
	}

	/**
	 * @param valorIptu the valorIptu to set
	 */
	public void setValorIptu(BigDecimal valorIptu) {
		this.valorIptu = valorIptu;
	}
	
	/**
	 * @return the propietario
	 */
	public Pessoa getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(Pessoa propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the transacoes
	 */
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	/**
	 * @param transacoes the transacoes to set
	 */
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Imovel)) {
	        return false;
	    }
	    Imovel other = (Imovel) object;
	    if (!(this.getId().equals(other.getId()))) {
	        return false;
	    }
	    return true;
	}
	
}
