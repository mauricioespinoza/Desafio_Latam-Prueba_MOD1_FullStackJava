package Servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Modelo.Cliente;
import Utilidades.ManejaExcepcion;
import Utilidades.Utilidad;

public class ExportadorCsv extends Exportador{
	
	//Este metodo exporta un archivo csv
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		//Hago una instancia al metodo ValidarArchivo de la clase Utilidad para poblar el File archivo
		File archivo = new File(Utilidad.ValidaArchivo(fileName));
		
		try {
			//Hago instancia de control acerca de la ruta recibida
			archivo = ManejaExcepcion.existeDirectorio(archivo);
			archivo.createNewFile();
			FileWriter fileW = new FileWriter(archivo);
			BufferedWriter bufferedWriter = new BufferedWriter(fileW);
			if (listaClientes == null) {
				System.out.println("El listado de productos no contiene valores");
			}
			else {
				for (Iterator<Cliente> iterator = listaClientes.iterator(); iterator.hasNext();) {
					Cliente elemento = (Cliente) iterator.next();
					bufferedWriter.write(elemento.toString());
					bufferedWriter.newLine();
				}
				bufferedWriter.close();
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("Datos de clientes exportados correctamente en formato .cvs");
			
		}
		catch(IOException e){
			System.out.println("Se ha generado una excepción en el proceso: "+e);
		}		
	}

}
