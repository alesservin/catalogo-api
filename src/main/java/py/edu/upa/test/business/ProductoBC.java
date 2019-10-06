package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.test.dao.ProductoDAO;
import py.edu.upa.test.entity.Producto;

@Named
@RequestScoped
public class ProductoBC {

    @EJB
	private ProductoDAO dao;
    
    public List<Producto> find() {
		return dao.find();
	}
	
	public Producto findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Producto p){
		dao.insert(p);
	}
	
	public void update(Integer id, Producto p){
		dao.update(id, p);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
}
