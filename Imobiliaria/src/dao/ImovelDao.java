package dao;

import java.util.ArrayList;
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
		
		if(!imovel.getSituacao().equals("")){
			queryStr.append("and i.situacao = :situacao ");
		}
		
		if(!imovel.getTipoImovel().equals("")){
			queryStr.append("and i.tipoImovel = :tipoImovel ");
		}
		
		if(!imovel.getFinalidade().equals("")){
			queryStr.append("and i.finalidade = :finalidade ");
		}
		
		if(imovel.getQuartos() != 0){
			queryStr.append("and i.quartos = :quartos ");
		}
		
		if(imovel.getSalas() != 0){
			queryStr.append("and i.salas = :salas ");
		}
		
		if(imovel.getBanheiros() != 0){
			queryStr.append("and i.banheiros = :banheiros ");
		}
		
		if(imovel.getVagasGaragem() != 0){
			queryStr.append("and i.vagasGaragem = :vagasGaragem ");
		}		
		
		Query query = this.getEntityManager().createQuery(queryStr.toString());
		
		if(!imovel.getSituacao().equals("")){
			query.setParameter("situacao", imovel.getSituacao());
		}
		
		if(!imovel.getTipoImovel().equals("")){
			query.setParameter("tipoImovel", imovel.getTipoImovel());
		}
		
		if(!imovel.getFinalidade().equals("")){
			query.setParameter("finalidade", imovel.getFinalidade());
		}
		
		if(imovel.getQuartos() != 0){
			query.setParameter("quartos", imovel.getQuartos());
		}
		
		if(imovel.getSalas() != 0){
			query.setParameter("salas", imovel.getSalas());
		}
		
		if(imovel.getBanheiros() != 0){
			query.setParameter("banheiros", imovel.getBanheiros());
		}
		
		if(imovel.getVagasGaragem() != 0){
			query.setParameter("vagasGaragem", imovel.getVagasGaragem());
		}
		
		List<Imovel> imovelsRetorno = new ArrayList<Imovel>();
		
		try {
			@SuppressWarnings({ "unchecked" })
			List<Imovel> imovels = (List<Imovel>) query.getResultList();
			imovelsRetorno.addAll(imovels);
		} catch (Exception ex) {
			return new ArrayList<Imovel>();
		}
		
		return imovelsRetorno;
	}

	public Imovel buscarPorNumeroEscritura(String numEscritura) {
		
		Imovel imovel = null;
		try {

			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createQuery("select i from Imovel as i where i.numeroEscritura = :numEscritura");
			query.setParameter("numEscritura", numEscritura);
			imovel = (Imovel) query.getSingleResult();
			getEntityManager().getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imovel;
	}

}
