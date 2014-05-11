package dao;

import javax.persistence.EntityManager;

import modelo.Transacao;

public class TransacaoDao extends DaoGenerico<Transacao> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public TransacaoDao() {
		super(Transacao.class);
	}

}
