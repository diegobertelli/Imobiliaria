package dao;

import javax.persistence.EntityManager;

import modelo.Funcionario;

public class FuncionarioDao extends DaoGenerico<Funcionario> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public FuncionarioDao( ) {
		super(Funcionario.class);
	}

}
