package Controladores;

import java.util.GregorianCalendar;

import DTOs.*;
import Servicio.*;
import jakarta.persistence.*;

/**
 * Donde se llama al menu y se abren y se cierran las comunicaciónes con la base de datos
 */
public class Inicio {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	CrudVajilla ss = new CrudVajilla();
	
	Vajilla vaj = new Vajilla(1, "qw", "plato","redondo", 5);
	Reserva re = new Reserva(new GregorianCalendar());
	
	
	em.persist(vaj);
	em.persist(re);
	
	em.getTransaction().commit();
	
	em.close();
}
