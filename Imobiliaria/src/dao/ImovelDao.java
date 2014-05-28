package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Imovel;

public class ImovelDao extends DaoGenerico<Imovel> {

	private EntityManager em = DaoGenerico.emf.createEntityManager();

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public ImovelDao() {
		super(Imovel.class);
	}
	
public List<Imovel> consultarImoveis(Imovel imovel){
		
		StringBuilder queryStr = new StringBuilder("SELECT i FROM Imovel i ");
		queryStr.append("where ");
		queryStr.append("(1=1) ");
		queryStr.append("and i.situacao = :situacao ");
		queryStr.append("and i.tipoImovel = :tipoImovel ");
		queryStr.append("and i.finalidade = :finalidade ");
		queryStr.append("and i.quartos = :quartos ");
		queryStr.append("and i.salas = :salas ");
		queryStr.append("and i.banheiros = :banheiros ");
		queryStr.append("and i.vagasGaragem = :vagasGaragem ");
		
		Query query = this.getEntityManager().createQuery(queryStr.toString());
		
		query.setParameter("situacao", imovel.getSituacao());
		query.setParameter("tipoImovel", imovel.getTipoImovel());
		query.setParameter("finalidade", imovel.getFinalidade());
		query.setParameter("quartos", imovel.getQuartos());
		query.setParameter("salas", imovel.getSalas());
		query.setParameter("banheiros", imovel.getBanheiros());
		query.setParameter("vagasGaragem", imovel.getVagasGaragem());
		
		@SuppressWarnings({ "unchecked" })
		List<Imovel> imovels = query.getResultList();
		
		return imovels;
	}

}
