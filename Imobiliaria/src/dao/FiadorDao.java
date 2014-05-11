package dao;

import javax.persistence.EntityManager;

import modelo.Fiador;

public class FiadorDao extends DaoGenerico<Fiador> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public FiadorDao() {
		super(Fiador.class);

	}

}
