package dao;

import java.util.List;

import javax.persistence.Query;
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

	@SuppressWarnings("unchecked")
	public List<Fiador> buscarPorNome(String nome) throws Exception {

		String hql = "select f from Fiador f where f.nome like :nome";

		Query q = this.getEntityManager().createQuery(hql);

		q.setParameter("nome", nome + '%');

		try {

			List<Fiador> fiadores = q.getResultList();

			return fiadores;

		} catch (Exception e) {

			throw new Exception(e);

		}

	}

}
