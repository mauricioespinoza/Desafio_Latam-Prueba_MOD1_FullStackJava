package Servicio;

import java.util.List;

import Modelo.Cliente;

public abstract class Exportador {
	
	//Metodo Abstracto exportar
	public abstract void exportar(String fileName, List<Cliente> listaClientes);
}
