package py.edu.upa.test.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="producto", schema="public")
public class Producto {
//	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "producto_id_producto_seq", sequenceName = "producto_id_producto_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "producto_id_producto_seq")
	@Column(name="id_producto")
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	Proveedor proveedor;

	private boolean favorito;
	
	@Column(name="fecha_compra")
	private Timestamp fechaCompra;
	
	private String imagen;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public Timestamp getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Timestamp fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
}
