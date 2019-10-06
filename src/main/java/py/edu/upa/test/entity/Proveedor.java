package py.edu.upa.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="proveedor", schema="public")
public class Proveedor {
//	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "proveedor_id_proveedor_seq_1", sequenceName = "proveedor_id_proveedor_seq_1", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "proveedor_id_proveedor_seq_1")
	@Column(name="id_proveedor")
	private int id;
	
	private String nombre;
	
	private String ruc;
	
	private String direccion;
	
	private String telefono;
	
	private String correo;

	private boolean borrado;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
}
