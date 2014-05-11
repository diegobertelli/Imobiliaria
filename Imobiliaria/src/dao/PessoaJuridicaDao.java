package dao;

import javax.persistence.EntityManager;

import modelo.PessoaJuridica;

public class PessoaJuridicaDao extends DaoGenerico<PessoaJuridica> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PessoaJuridicaDao() {
		super(PessoaJuridica.class);
	}

}
