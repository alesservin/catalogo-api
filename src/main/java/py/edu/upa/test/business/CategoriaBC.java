package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.test.dao.CategoriaDAO;
import py.edu.upa.test.entity.Categoria;

@Named
@RequestScoped
public class CategoriaBC {

    @EJB
	private CategoriaDAO dao;
    
    public List<Categoria> find() {
		return dao.find();
	}
	
	public Categoria findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Categoria t){
		dao.insert(t);
	}
	
	public void update(Integer id, Categoria c){
		dao.update(id, c);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
}
