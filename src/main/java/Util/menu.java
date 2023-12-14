package Util;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import DTOs.Vajilla;
import Servicio.CrudVajilla;

/**
 * Clase que sera el menu que se llamara en inicio
 */
public class menu {
	public static void elmenu() {
		Scanner teclado = new Scanner(System.in);
		int cantidad;
		CrudVajilla crud = new CrudVajilla();
		CrudReserva crudre = new CrudReserva();
		
		do {
			System.out.println("------------MENU-----------");
			System.out.println("1 - Alta Vajilla");
			System.out.println("2 - Eliminar Vajilla");
			System.out.println("3 - Modificar Cantidad");
			System.out.println("4 - Mostrar Stok");
			System.out.println("5 - Crear Reserva");
			System.out.println("6 - Salir menu");
			System.out.println("---------------------------");
			
			int option = teclado.nextInt();
			
			switch(option) {
				case 1:
					try {
						System.out.println("----Alta Vajilla-----");
						
						System.out.print("introduzca el id: ");
						long id = teclado.nextLong();
						
						System.out.print("introduzca el nombre: ");
						String nombre = teclado.next();
						
						System.out.print("introduzca el descripcion: ");
						String descrip = teclado.next();
						
						String codigo = nombre.concat(id /*Combertir a String pero soy gilipollas y no me acuerdo como se hace*/);
						
						do {
							System.out.print("introduzca cantidad (deve de ser mayor a 0): ");
							cantidad = teclado.nextInt();
						}while(cantidad < 0);
						
						Vajilla va = new Vajilla(id, codigo, nombre, descrip, cantidad);
						
						crud.agregarVajilla(va);
						
					}catch(Exeption /*aqui es exepcion invalide format y exepcion de crud porque quiero quel execpocion suba pero no me acuqero como se escribe el exeption*/ e) {
						System.out.print("error: "+ e);
					}

				break;
				case 2:
					System.out.println("-----Eliminar Vajilla----");
					System.out.print("Ponga el id de la Vajilla que quiera eliminar: ");
					try {
						long id = teclado.nextLong();
						
						crud.eliminarVajilla(id);
					}catch(Exception e /*Por si pones algo que no sea un long en el teclado y por si hay algun problema en la eliminación*/) {
						System.out.print("error: "+ e);
					}
				break;
				case 3:
					System.out.println("-----Modificar Cantidad-----");
					
					
					try {
						System.out.print("Ponga el id de la vajilla que quiera modificar: ");
						long id = teclado.nextLong();
						
						Vajilla modificar = crud.obtenerVajilla(id);
							
						System.out.print("Ponga el nuevo id : ");
						id = teclado.nextLong();
						
						System.out.print("Ponga el nuevo nombre : ");
						String nombre = teclado.next();
						
						
						crud.actualizarVajilla(modificar);
					
					}catch(Exception e) {}
					
				break;
				case 4:
					
					List<Vajilla> lista = crud.obtenerTodasVajillas();
					
					for(Vajilla in : lista) {
						in.toString();
					}
					
				break;
				case 5:
					
					System.out.println("-------Crear Reserva------");
					
					System.out.println("Introduzca la año:");
					int year = teclado.nextInt();
					
					System.out.println("Introduzca la mes:");
					int mes = teclado.nextInt();
					
					System.out.println("Introduzca la dia:");
					int day = teclado.nextInt();
					
					Calendar fecha = new GregoriaCalendar();
					
					fecha.set(year, mes, day);
					
					
				break;
			}
		}while(option != 6);
	}
}
