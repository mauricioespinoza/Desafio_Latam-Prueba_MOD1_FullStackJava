package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CategoriaEnum;
import Servicio.ClienteServicio;

public class Pruebas {
	//Genero una instancia de cliente Servicio
	ClienteServicio clienteServ = new ClienteServicio();
	
	/*NOTA: Indico que  */

	@Test
	public void testAgregarCliente() {
		System.out.println("Este test falla, ya que no hay una implementación activa para ejecutar alguna prueba");
		System.out.println("____________________________________________________________");
		fail("Not yet implemented");
		
	}

	@Test
	public void agregarClienteTest() {
		try {
			clienteServ.agregarCliente("15971639-2", "Mauricio", "Espinoza", 0, CategoriaEnum.Activo);
			int resultado = clienteServ.getListaClientes().size();
			int esperado = 1;
			assertEquals(esperado, resultado);
			System.out.println("Se ha agregado un cliente al sistema, mediante test");
			System.out.println("____________________________________________________________");
		}
		catch (Exception Error) {
			System.out.println("Se ha generado una excepción en el test: " + Error);
			System.out.println("____________________________________________________________");
		}
	}
	
	@Test
	public void agregarClienteNullTest() {
		try {
			clienteServ.agregarCliente(null, null, null, 0, null);
			int resultado = clienteServ.getListaClientes().size();
			int esperado = 1;
			assertEquals(esperado, resultado);
			System.out.println("No debería agregar un cliente con data \"null\" al sistema,pero la excepción de null");
			System.out.println("se maneja en la clase ManejoExcepcion del package Utilidades");
			System.out.println("____________________________________________________________");
		}
		catch (Exception Error) {
			System.out.println("Se ha generado una excepción en el test: " + Error);
			System.out.println("____________________________________________________________");
		}
		
	}

}
