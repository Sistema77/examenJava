package Servicio;

import java.util.List;

import DTOs.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Crud de Reserva
 */
public class CrudReserva {
	@PersistenceContext
	EntityManager entityManager;
	
	public void agregarReserva() {
		entityManager.persist(entityManager);
	}
	
	public Reserva obtenerReserva(long id) {
		return entityManager.find(Reserva.class, id);
	} 
	
	@Transactional
	public void actualizarReserva(Reserva reserva) {
		entityManager.merge(reserva);
	}
	
	@Transactional
	public void eliminarVajilla(long id) {
		Reserva elim = entityManager.find(Reserva.class, id);
		if(elim != null) {
			entityManager.remove(elim);
		}else {
			System.out.print("Error al eliminar: Reserva no encontrada");
		}
	}
	
	public List<Reserva> obtenerTodasVajillas(){
		/*
		 * String query = "SELECT * FROM ?";
		PreparedStatement sentencia = conexion.prepareStatement(query);
		sentencia.setInt(1,"reserva");
		ResultSet resultado = sentencia.executeQuery();
		
		entityManager.createQuery(query)*/ //No me funciona el Parametrizaje pero se que es Así
		
		return entityManager.createQuery("SELECE * FROM reserva", Reserva.class).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
