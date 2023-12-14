package Servicio;

import java.util.List;

import DTOs.Vajilla;
import jakarta.persistence.*;
import jakarta.transaction.*;

/**
 * Crud de Vajjilla
 */
public class CrudVajilla {
	@PersistenceContext
	EntityManager entityManager;
	
	public void agregarVajilla(Vajilla vajilla) {
		entityManager.persist(vajilla);
	}
	
	public Vajilla obtenerVajilla(long id) {
		return entityManager.find(Vajilla.class, id);
	} 
	
	@Transactional
	public void actualizarVajilla(Vajilla vajilla) {
		entityManager.merge(vajilla);
	}
	
	@Transactional
	public void eliminarVajilla(long id) {
		Vajilla elim = entityManager.find(Vajilla.class, id);
		if(elim != null) {
			entityManager.remove(elim);
		}else {
			System.out.print("Error al eliminar: Vajilla no encontrada");
		}
	}
	
	public List<Vajilla> obtenerTodasVajillas(){
		/*
		 * String query = "SELECT * FROM ?";
		PreparedStatement sentencia = conexion.prepareStatement(query);
		sentencia.setInt(1,"Vajilla");
		ResultSet resultado = sentencia.executeQuery();
		
		entityManager.createQuery(query)*/ //No me funciona el Parametrizaje pero se que es Así
		
		return entityManager.createQuery("SELECE * FROM vajilla", Vajilla.class).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

}
