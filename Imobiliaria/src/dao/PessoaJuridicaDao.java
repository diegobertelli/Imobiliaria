package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.PessoaJuridica;

public class PessoaJuridicaDao extends DaoGenerico<PessoaJuridica> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PessoaJuridicaDao() {
		super(PessoaJuridica.class);
	}
	
	public PessoaJuridica buscarPorCNPJ(String cnpj)
	{
		PessoaJuridica pessoaJuridica = null;
		try {
			
			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createQuery("select pj from PessoaJuridica as pj where pj.cnpj = :cnpj");
			query.setParameter("cnpj", cnpj);
			pessoaJuridica = (PessoaJuridica) query.getSingleResult();
			getEntityManager().getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoaJuridica;
	}

}
