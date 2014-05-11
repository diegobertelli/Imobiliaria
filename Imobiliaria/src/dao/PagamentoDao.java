package dao;

import javax.persistence.EntityManager;

import modelo.Pagamento;

public class PagamentoDao extends DaoGenerico<Pagamento>{

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PagamentoDao() {
		super(Pagamento.class);
	}

}
