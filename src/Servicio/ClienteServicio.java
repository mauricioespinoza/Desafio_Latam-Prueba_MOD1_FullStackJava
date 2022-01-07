package Servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;
import Vista.Menu;

public class ClienteServicio {
	//Atributos
	private List<Cliente> listaClientes;
	
	//Constructor
	public ClienteServicio() {
		this.listaClientes =  new ArrayList<Cliente>();
	}

	//Getters
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


	//Metodos solicitados
	//Listar detalle clientes
	public void retornolistarClientes() {
		if (listaClientes.equals(null)||listaClientes.size() == 0) {
			System.out.println("La lista de clientes no cuenta con registros");
		}
		else {
		for (Cliente cliente : listaClientes) {
			System.out.println("-------------Datos del Cliente-------------");
			System.out.println("___________________________");
			System.out.println("RUN del Cliente: " + cliente.getRunCliente());
			System.out.println("Nombre del Cliente: "+ cliente.getNombreCliente());
			System.out.println("Apellido del Cliente: "+ cliente.getApellidoCliente());
			System.out.println("Años como Cliente: "+ cliente.getAniosCliente()+ " años");
			System.out.println("Categoría del Cliente: "+cliente.getNombreCategoria());
			System.out.println("-------------------------------------------");
		}
		}
	}
	
	//Agregar Clientes
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente,int aniosCliente,
			CategoriaEnum nombreCategoria) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		listaClientes.add(cliente);
		
	}
	

	//Editar Clientes, solo lo uso como un recorredor de la lista, por usarlo, ya que se pidio crearlo
	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente,int aniosCliente,
			CategoriaEnum nombreCategoria) throws IOException {
		//Recorro la lista y condiciono que el objeto "cliente" que obtenga sea igual a los datos recibidos
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(runCliente) &&
					cliente.getNombreCliente().equals(nombreCliente) &&
					cliente.getApellidoCliente().equals(apellidoCliente)&&
					(cliente.getAniosCliente() == aniosCliente) &&
					cliente.getNombreCategoria().equals(nombreCategoria)) {
				//Aca instancio la sobreescritura del metodo "Editar cliente" de la clase menú, mediante una sobrecarga del mismo
				Menu.editarCliente(Menu.opcion, cliente);
			}
		}
		
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

	



	


	
}
