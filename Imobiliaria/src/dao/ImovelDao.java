package dao;

import javax.persistence.EntityManager;

import modelo.Imovel;

public class ImovelDao extends DaoGenerico<Imovel> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public ImovelDao() {
		super(Imovel.class);
	}

}
