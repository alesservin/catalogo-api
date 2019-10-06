package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Categoria;

@Stateless
public class CategoriaDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		
		criteria.add(Restrictions.or(
				Restrictions.eq("borrado", false),
				Restrictions.isNull("borrado")));
		
		return criteria.list();

	}
	
	public Categoria findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		
		criteria.add(Restrictions.eq("id_categoria", id));
		
		return (Categoria) criteria.uniqueResult();

	}
	
	public void insert(Categoria c){
		entityManager.persist(c);
	}
	
	public void update(Integer id, Categoria categoria){
		Categoria c = findById(id);
		c.setNombre(categoria.getNombre());
		c.setBorrado(categoria.isBorrado());
		entityManager.merge(c);
	}
	
	public void delete(Integer id){
		Categoria c = findById(id);
		c.setBorrado(true);
		entityManager.merge(c);
	}
}
