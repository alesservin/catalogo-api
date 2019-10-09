package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Producto;

@Stateless
public class ProductoDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Producto> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.or(
				Restrictions.eq("borrado", false),
				Restrictions.isNull("borrado")));
		
		return criteria.list();

	}
	
	public Producto findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Producto) criteria.uniqueResult();

	}
	
	public void insert(Producto p){
		entityManager.persist(p);
	}
	
	public void update(Integer id, Producto producto){
		Producto p = findById(id);
		p.setNombre(producto.getNombre());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setCategoria(producto.getCategoria());
		p.setProveedor(producto.getProveedor());
		p.setFavorito(producto.isFavorito());
		p.setFechaCompra(producto.getFechaCompra());
		p.setImagen(producto.getImagen());
		p.setBorrado(producto.isBorrado());
		entityManager.merge(p);
	}
	
	public void delete(Integer id){
		Producto p = findById(id);
		p.setBorrado(true);
		entityManager.merge(p);
	}
}
