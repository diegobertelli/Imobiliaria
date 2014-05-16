package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "nome", nullable=false)
	private String nome;
	
	@Basic(optional = false)
	@Column(name = "email", nullable=false)
	private String email;
	
	@Basic(optional = false)
	@Column(name = "telefone", nullable=true)
	private String telefone;
	
	@Basic(optional = false)
	@Column(name = "tipopessoa", nullable=true)
	private String tipoPessoa;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "cliente")
	private List<Transacao> transacoes;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "propietario")
	private List<Imovel> imovel;

	public Pessoa() {

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the tipoPessoa
	 */
	public String getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
