package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Proveedor;

@Stateless
public class ProveedorDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.or(
				Restrictions.eq("borrado", false),
				Restrictions.isNull("borrado")));
		
		return criteria.list();

	}
	
	public Proveedor findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.eq("id_proveedor", id));
		
		return (Proveedor) criteria.uniqueResult();

	}
	
	public void insert(Proveedor p){
		entityManager.persist(p);
	}
	
	public void update(Integer id, Proveedor proveedor){
		Proveedor p = findById(id);
		p.setNombre(proveedor.getNombre());
		p.setRuc(proveedor.getRuc());
		p.setDireccion(proveedor.getDireccion());
		p.setTelefono(proveedor.getTelefono());
		p.setCorreo(proveedor.getCorreo());
		p.setBorrado(proveedor.isBorrado());
		entityManager.merge(p);
	}
	
	public void delete(Integer id){
		Proveedor p = findById(id);
		p.setBorrado(true);
		entityManager.merge(p);
	}
}
