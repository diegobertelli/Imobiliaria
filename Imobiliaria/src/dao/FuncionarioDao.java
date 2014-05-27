package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Funcionario;

public class FuncionarioDao extends DaoGenerico<Funcionario> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public FuncionarioDao( ) {
		super(Funcionario.class);
	}
	
public Funcionario buscarPorLogin(String login) throws Exception {
		
		String hql = "select f from Funcionario f where f.login=:login";
		
		Query q = this.getEntityManager().createQuery(hql);

		q.setParameter("login", login);
		
		try {
			
			Funcionario funcionario = (Funcionario)  q.getSingleResult();
			
			return funcionario;
			
		} catch (Exception e) {
			
			throw new Exception(e); 
			
		}
		
		
	}

}
