package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.PessoaJuridica;
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

	public List<PessoaJuridica> buscarPorNome(String nome) throws Exception {
		String hql = "select pj from PessoaJuridica pj where pj.nome like :nome";

		Query q = this.getEntityManager().createQuery(hql);

		q.setParameter("nome", nome + '%');

		try {

			List<PessoaJuridica> pessoasJuridicas = q.getResultList();

			return pessoasJuridicas;

		} catch (Exception e) {

			throw new Exception(e);

		}
	}

}
