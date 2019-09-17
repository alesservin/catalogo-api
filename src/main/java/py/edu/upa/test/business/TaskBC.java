package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import py.edu.upa.test.dao.TaskDAO;
import py.edu.upa.test.entity.Task;

@Named
@RequestScoped
public class TaskBC {
	
    @EJB
	private TaskDAO dao;
	
	public List<Task> find() {
		return dao.find();
	}
	
	public Task findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Task t){
		dao.insert(t);
	}
	
	public void update(Integer id, Task t){
		dao.update(id, t);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public List<Task> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	
	/**
	 * Obtener task filtrando por id_type
	 * @param id_type
	 * @return
	 */
	public List<Task> getByType(Integer id_type) {
		return dao.findByType(id_type);
	}
	
	/**
	 * Obtener tasks paginando
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Task> getWithPagination(Integer page,Integer size) {
		return dao.findWithPagination(page, size);
	}
	
}

