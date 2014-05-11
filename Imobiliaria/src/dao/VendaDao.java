package dao;

import javax.persistence.EntityManager;

import modelo.Venda;

public class VendaDao extends DaoGenerico<Venda> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public VendaDao() {
		super(Venda.class);
	}

}
