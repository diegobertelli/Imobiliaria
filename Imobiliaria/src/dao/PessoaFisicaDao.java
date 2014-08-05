package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.PessoaFisica;

public class PessoaFisicaDao extends DaoGenerico<PessoaFisica> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}

	public PessoaFisicaDao() {
		super(PessoaFisica.class);
	}

	public PessoaFisica buscarPorCPF(String cpf) {
		PessoaFisica pessoaFisica = null;
		try {

			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createQuery(
					"select pf from PessoaFisica as pf where pf.cpf = :cpf");
			query.setParameter("cpf", cpf);
			pessoaFisica = (PessoaFisica) query.getSingleResult();
			getEntityManager().getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoaFisica;
	}

	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscarPorNome(String nome) throws Exception {
		String hql = "select pf from PessoaFisica pf where pf.nome like :nome";

		Query q = this.getEntityManager().createQuery(hql);

		q.setParameter("nome", nome + '%');

		try {

			List<PessoaFisica> pessoasFisicas = q.getResultList();

			return pessoasFisicas;

		} catch (Exception e) {

			throw new Exception(e);

		}
	}

}
