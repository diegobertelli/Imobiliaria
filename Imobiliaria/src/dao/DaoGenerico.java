package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoGenerico<T> {
	
	private Class<T> entityClass;
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projeto_Crud");

    public DaoGenerico(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
	 	 try {
		 	 getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
			 getEntityManager().getTransaction().commit();
		 } catch (Exception e) {
			 e.printStackTrace();
	 	 }
    }

    public void edit(T entity) {
	 	 try {
		 	 getEntityManager().getTransaction().begin();
        	 getEntityManager().merge(entity);
			 getEntityManager().getTransaction().commit();
		 } catch (Exception e) {
			 e.printStackTrace();
	 	 }
    }

    public void remove(T entity) {
	 	 try {
		 	 getEntityManager().getTransaction().begin();
        	 getEntityManager().remove(getEntityManager().merge(entity));
			 getEntityManager().getTransaction().commit();
		 } catch (Exception e) {
			 e.printStackTrace();
	 	 }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
