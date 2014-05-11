package dao;

import javax.persistence.EntityManager;

import modelo.Pessoa;

public class PessoaDao extends DaoGenerico<Pessoa> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();
	
	protected EntityManager getEntityManager() {
        return em;
    }
	
	public PessoaDao() {
		super(Pessoa.class);
	}

}
