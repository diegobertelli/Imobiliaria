package dao;

import javax.persistence.EntityManager;

import modelo.PessoaFisica;

public class PessoaFisicaDao extends DaoGenerico<PessoaFisica> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PessoaFisicaDao() {
		super(PessoaFisica.class);
	}

}
