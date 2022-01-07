package Servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;
import Utilidades.Utilidad;
import Vista.Menu;

public class ArchivoServicio extends Exportador{
	

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
	}
	
	public void cargarDatos(String fileName) {
		//Hago una instancia al metodo ValidarArchivo de la clase Utilidad para poblar el File archivo
		File archivo = new File(Utilidad.ValidaArchivo(fileName));
				
		//Procedo a lectura y carga del archivo
		try {
			if (archivo.exists()) {
				//Declaro variables de los tipos necesarios para el proceso de lectura y escritura
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String data = br.readLine();
				String[] arreglo;
				String[] arregloAnio;
				String separador = ",";
				
				//Ciclo de lectura y carga
				while (data != null) {
						//Genero la instancia de separador
						arreglo = data.split(separador);
						Menu.cliente.setRunCliente(arreglo[0]);
						Menu.cliente.setNombreCliente(arreglo[1]);
						Menu.cliente.setApellidoCliente(arreglo[2]);
						//Separo el número de la sección año
						arregloAnio = arreglo[3].split(" ");
						Menu.cliente.setAniosCliente(Integer.parseInt(arregloAnio[0]));
						//Parseo el valor recibido del arreglo al enum definido
						CategoriaEnum nombreCategoria = CategoriaEnum.valueOf(arreglo[4]);
						Menu.cliente.setNombreCategoria(nombreCategoria);
						//Uso el metodo agregar del Menú
						Menu.agregarCliente(Menu.cliente.getRunCliente(), Menu.cliente.getNombreCliente(), Menu.cliente.getApellidoCliente(),
								Menu.cliente.getAniosCliente(), Menu.cliente.getNombreCategoria());
						data = br.readLine();
				}
				br.close();
				System.out.println("Datos cargados correctamente en la lista");
			}
			else {
				System.out.println("El fichero "+fileName+ " no existe");
			}
			
		//Control de excepciones
		} 
		catch (Exception e) {
			System.out.println("Excepcion leyendo fichero : " + e);
		}
		catch (Error e){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
	}

}
