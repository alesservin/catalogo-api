package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.test.dao.ProveedorDAO;
import py.edu.upa.test.entity.Proveedor;

@Named
@RequestScoped
public class ProveedorBC {

    @EJB
	private ProveedorDAO dao;
    
    public List<Proveedor> find() {
		return dao.find();
	}
	
	public Proveedor findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Proveedor p){
		dao.insert(p);
	}
	
	public void update(Integer id, Proveedor p){
		dao.update(id, p);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
}
