package dao;

import javax.persistence.EntityManager;

import modelo.Aluguel;

public class AluguelDao extends DaoGenerico<Aluguel> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public AluguelDao() {
		super(Aluguel.class);
	}

}
