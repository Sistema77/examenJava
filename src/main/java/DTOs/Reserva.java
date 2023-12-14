package DTOs;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.*;

/**
 * Clase que representa la virtualización de la tabla Reserva en la base de datos
 * @author Jose Manuel Moreno Guerra
 */

@Entity
@Table(name="Reserva", schema="examen")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idReserva", nullable=false)
	private long idReserva;
	
	@Column(name="fchReserva", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchReserva;
	
	@ManyToMany()
	@JoinColumn(name="idElemento")
	List<Vajilla> VajillaReserva;
	
	// Getter / Setter
	
	public long getIdReserva() {
		return this.idReserva;
	}
	public Calendar getFchReserva() {
		return this.fchReserva;
	}
	
	public void setIdReserva(long id) {
		this.idReserva=id;
	}
	public void setFchReserva(Calendar fecha) {
		this.fchReserva = fecha;
	}
	
	// Constructor
	
	/**
	 * Constructor Vacio por defecto
	 */
	public Reserva() {
		super();
	}
	
	/**
	 * Constructro con los atributos de la clase
	 * @param id
	 * @param fecha
	 */
	public Reserva( Calendar fecha) {
		super();
		this.fchReserva=fecha;
	}
}
