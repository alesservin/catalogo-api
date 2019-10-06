package py.edu.upa.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria", schema="public")
public class Categoria {
//	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "categoria_id_categoria_seq_1", sequenceName = "categoria_id_categoria_seq_1", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "categoria_id_categoria_seq_1")
	@Column(name="id_categoria")
	private Integer id;
	
	private String nombre;

	private boolean borrado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
}
