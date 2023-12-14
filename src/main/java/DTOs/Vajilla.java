package DTOs;


import java.util.List;

import jakarta.persistence.*;

/**
 * Clase que representa la virtualización de la tabla Vajilla en la base de datos
 * @author Jose Manuel Moreno Guerra
 */

@Entity
@Table(name="Vajilla", schema="examen")
public class Vajilla {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idElemento", nullable=false)
	private long idElemento;
	
	@Column(name="codigoElemento", nullable=false)
	private String codigoElemento;
	
	@Column(name="nombreElemento", nullable=false)
	private String nombreElemento;
	
	@Column(name="descripcionElemento", nullable=false)
	private String descripcionElemento;
	
	@Column(name="cantidadElemento", nullable=false)
	private int cantidadElemento;
	
	@ManyToMany(mappedBy ="Vajilla")
	List<Reserva> VajillaReserva; 
	
	// Getter / Setter
	public long getId() {
		return this.idElemento;
	}
	public String getCodigoElemento() {
		return this.codigoElemento;
	}
	public String getNombreElemento() {
		return this.nombreElemento;
	}
	public String getDescripcionElementos() {
		return this.descripcionElemento;
	}
	public int getCantidaElementos() {
		return this.cantidadElemento;
	}
	
	public void setId(long id) {
		this.idElemento = id;
	}
	public void setCodigoElemento(String codigo) {
		this.codigoElemento = codigo;
	}
	public void setNombreElemento(String nombre) {
		this.nombreElemento = nombre;
	}
	public void setDescripcionElementos(String descrp) {
		this.descripcionElemento = descrp;
	}
	public void setCantidaElementos(int cantidad) {
		this.cantidadElemento = cantidad;
	}
	
	
	public String toString() {
		return "Codigo: "+ this.getCodigoElemento() + " nombre: " + this.getNombreElemento() + " cantidad: " + this.cantidadElemento + "\n";
	}
	// Constructores
	
	/**
	 * Constructor Vacio Por defecto
	 */
	public Vajilla() {
		super();
	}
	
	/**
	 * Contructor de todos los Atributos
	 * @param codigoElemento
	 * @param nombreElemento
	 * @param descripcionElementos
	 * @param cantidaElementos
	 */
	public Vajilla(long id, String codigoElemento, String nombreElemento, String descripcionElementos, int cantidaElementos) {
		super();
		this.idElemento = id;
		this.codigoElemento = codigoElemento;
		this.nombreElemento = nombreElemento;
		this.descripcionElemento = descripcionElementos;
		this.cantidadElemento = cantidaElementos;
	}
}
