package Vista;

import java.io.IOException;
import java.util.Scanner;

import Modelo.*;
import Servicio.*;
import Utilidades.*;

public class Menu {
	
	//Instancias solicitadas
	public static ClienteServicio clienteServicio = new ClienteServicio();
	private static ArchivoServicio archivoServicio = new ArchivoServicio();
	private static ExportadorCsv exportadorCsv = new ExportadorCsv();
	private static ExportadorTxt exportarTxt = new ExportadorTxt();
	//Genero una instancia de la clase cliente que utlizare como recurso
	public static Cliente cliente = new Cliente();
	
	//Genero atributos solicitados y otros "static" que se usaran en diversos procesos
	private static String fileName = "Clientes";
	private static String fileName1 = "DBClientes.csv";
	public static Scanner scan = new Scanner(System.in);
	public static String leer, auxiliar;
	public static int opcion;

	
	public static void iniciarMenu() throws IOException, InterruptedException {
		int x = 1;
		while (x == 1) {
		do {
			Utilidad.limpiaPantalla();
			System.out.println("1. Listar Clientes\r\n"
					+ "2. Agregar Cliente\r\n"
					+ "3. Editar Cliente\r\n"
					+ "4. Cargar Datos\r\n"
					+ "5. Exportar Datos\r\n"
					+ "6. Salir\r\n"
					+ "Ingrese una opción:");
			leer = scan.nextLine();
			ManejaExcepcion.controlaOpcion();
		}
		while(leer.equals(""));
		switch(Integer.parseInt(leer)) {
		//Listar Clientes
			case 1:
				Utilidad.limpiaPantalla();
				listarClientes();
				Utilidad.tiempoEsperaPrint();
				x = 1;
				break;
	   //agregar cliente
			case 2:
				Utilidad.limpiaPantalla();
				System.out.println("Iniciando Proceso de agregar Cliente...");
				agregarCliente();
				System.out.println("Cliente agregado...en breve retornara a menú principal");
				Utilidad.tiempoEsperaPrint();
				x = 1;
				break;
		//Editar Cliente
			case 3:
				Utilidad.limpiaPantalla();
				editarCliente();
				Utilidad.tiempoEsperaPrint();
				x = 1;
				break;
		//Cargar Datos
			case 4:
				Utilidad.limpiaPantalla();
				cargarDatos();
				Utilidad.limpiaPantalla();
				Utilidad.tiempoEsperaPrint();
				x = 1;
				break;
		//Exportar Datos
			case 5:
				Utilidad.limpiaPantalla();
				exportarDatos();
				Utilidad.tiempoEsperaPrint();
				break;
		//Salir
			case 6:
				Utilidad.limpiaPantalla();
				terminarPrograma();
				x = 0;
				break; 
		}
		}
	}
	
	//Metodo que Lista Clientes
	public static void listarClientes() {
		clienteServicio.retornolistarClientes();
	}

	//Metodo agregar cliente
	public static void agregarCliente() throws IOException {
		String runCliente, nombreCliente, apellidoCliente;
		int aniosCliente;
		
		System.out.println("-------------Crear Cliente-------------");
		do {
			System.out.println("Ingresa RUN del Cliente: ");
			auxiliar = scan.nextLine();
			ManejaExcepcion.RutCliente();
		}
		while(auxiliar.equals(""));
		runCliente = auxiliar;
		
		do {
			System.out.println("Ingresa Nombre del Cliente: ");
			auxiliar = scan.nextLine();
			ManejaExcepcion.ControlaCaracter();
		}
		while(auxiliar.equals(""));
		nombreCliente = auxiliar;
		
		do {
			System.out.println("Ingresa Apellido del Cliente: ");
			auxiliar = scan.nextLine();
			ManejaExcepcion.ControlaCaracter();
		}
		while(auxiliar.equals(""));
		apellidoCliente = auxiliar;
		
		do {
			System.out.println("Ingresa años como Cliente: ");
			auxiliar = scan.nextLine();
			ManejaExcepcion.controlaNum();
		}
		while(auxiliar.equals(""));
		aniosCliente = Integer.parseInt(auxiliar);
		//Dejo fijo la categoria de cliente como "activo"
		CategoriaEnum nombreCategoria = CategoriaEnum.Activo;
		System.out.println("---------------------------------------");
		//Aca "sobreescribo el metodo, mediante la logica de la sobrecarga
		agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		}
	
	//Sobreescribo metodo agregar Cliente
	public static  void  agregarCliente(String runCliente, String nombreCliente, String apellidoCliente,int aniosCliente,
			CategoriaEnum nombreCategoria) {
		//Desde aca llamo al metodo agregar de ClienteServkicio
		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
	}
	
	//Metodo de edición de cliente
	public static void editarCliente() throws IOException, InterruptedException {
		if (clienteServicio.getListaClientes().size() != 0) {
			do {
				System.out.println("-------------Editar Cliente-------------\r\n"
				+ "Seleccione qué desea hacer:\r\n"
				+ "1.-Cambiar el estado del Cliente\r\n"
				+ "2.-Editar los datos ingresados del Cliente\r\n"
				+ "Ingrese opcion:\r\n"
				+ "----------------------------------------");
				auxiliar = scan.nextLine();
				ManejaExcepcion.controlaOpcionEdita2();
			}
			while (auxiliar.equals(""));
			opcion = Integer.parseInt(auxiliar);
			do {
				System.out.println("Ingrese RUN del Cliente a editar:");
				auxiliar = scan.nextLine();
				if (auxiliar.trim().equals("")||auxiliar.trim().equals(null)) {
					System.out.println("Debe ingresar un rut para consultar la edición");
					auxiliar = "";
				}
				//Consulto si el RUT recibido existe en la lista de clientes
				else if (clienteServicio.getListaClientes().toString().contains(auxiliar) == true) {
					//Si el RUT esta en la lista, Obtengo el indice de la Lista, que usare para obtener los atributos del registro
					int indice = -1;
					for (int i = 0; i < clienteServicio.getListaClientes().size(); i++) {
						if (clienteServicio.getListaClientes().get(i).getRunCliente().equals(auxiliar)) {
							indice = i;
						}
					}
					//Llamo al metodo "editaCliente" de la clase ClienteServicio, solo con fin de usarlo porque se pidio crearlo
					//En la llamada, le paso los parametros obtenidos de la misma lista
					clienteServicio.editarCliente(
							clienteServicio.getListaClientes().get(indice).getRunCliente(),
							clienteServicio.getListaClientes().get(indice).getNombreCliente(),
							clienteServicio.getListaClientes().get(indice).getApellidoCliente(),
							clienteServicio.getListaClientes().get(indice).getAniosCliente(),
							clienteServicio.getListaClientes().get(indice).getNombreCategoria()
							);
					
					//Arrojo mensaje Final
					Utilidad.limpiaPantalla();
					System.out.println("----------------------------------------\r\n"
							+ "Datos cambiados con éxito");
					Utilidad.tiempoEsperaPrint();
				}
				else {
					System.out.println("El rut ingresado no existe en el sistema");
				}
			}
			while (auxiliar.equals(""));
		}
		else {
			System.out.println("El sistema aun no recibe clientes, para que pueda editarlos");
		}
	}
	
	//Sobrescribo el metodo editarCliente mediante una sobrecarga y lo alimento con ub objeto "cliente" obtenido de su metodo homonimo
	//situado en la clase ClienteServicio
	public static void editarCliente(int opcionRecibida, Cliente cliente) throws IOException {
		//Evaluo la misma opción recibida desde menu, pero pasada desde clase ClienteServicio
		if (opcionRecibida == 1) {
			System.out.println("-----Actualizando estado del Cliente----\r\n"
									+ "El estado actual es: "+ cliente.getNombreCategoria() +" \n");
				do {
					if (cliente.getNombreCategoria() == CategoriaEnum.Activo) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo\r\n"
							+ "2.-Si desea mantener el estado del cliente Activo\r\n"
							+ "Ingrese opcion:\r\n"
							+ "----------------------------------------");	
						}
					else {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Activo\r\n"
											+ "2.-Si desea mantener el estado del cliente Inactivo\r\n"
											+ "Ingrese opcion:\r\n"
											+ "----------------------------------------");
					}
					auxiliar = scan.nextLine();
					ManejaExcepcion.controlaOpcionEdita2();
				}
				while (auxiliar.equals(""));
				if (Integer.parseInt(auxiliar)== 1 && cliente.getNombreCategoria()== CategoriaEnum.Activo) {
						cliente.setNombreCategoria(CategoriaEnum.Inactivo);
					}
				else if (Integer.parseInt(auxiliar)== 1) {
						cliente.setNombreCategoria(CategoriaEnum.Activo);
					}
						
		}
		else {
			do {
				System.out.println("----Actualizando datos del Cliente-----\n");
				System.out.println("1.-El RUN del Cliente es: "+ cliente.getRunCliente());
				System.out.println("2.-El Nombre del Cliente es: "+cliente.getNombreCliente());
				System.out.println("3.-El Apellido del Cliente es: "+cliente.getApellidoCliente());
				System.out.println("4.-Los años como Cliente son: "+cliente.getAniosCliente()+ " años\n");
				System.out.println("Ingrese opcion a editar de los datos del cliente");
				System.out.println("------------------------------------------------");
				auxiliar = scan.nextLine();
				ManejaExcepcion.controlaOpcionEdita();
				}
			while (auxiliar.equals(""));
			//aca genero un switch con las 4 opciones de edición de data de cliente
			switch (Integer.parseInt(auxiliar)) {
			case 1:
				do {
					System.out.println("Ingrese nuevo RUT de Cliente: ");
					auxiliar = scan.nextLine();
					ManejaExcepcion.RutCliente();
				}
				while (auxiliar.equals(""));
				cliente.setRunCliente(auxiliar);
				break;
			case 2:
				do {
					System.out.println("Ingrese nuevo Nombre del Cliente: ");
					auxiliar = scan.nextLine();
					ManejaExcepcion.ControlaCaracter();
				}
				while (auxiliar.equals(""));
				cliente.setNombreCliente(auxiliar);
				break;
			case 3:
				do {
					System.out.println("Ingrese nuevo Apellido del Cliente: ");
					auxiliar = scan.nextLine();
					ManejaExcepcion.ControlaCaracter();
				}
				while (auxiliar.equals(""));
				cliente.setApellidoCliente(auxiliar);
				break;
			case 4:
				do {
					System.out.println("Ingrese nuevo valor para años como Cliente: ");
					auxiliar = scan.nextLine();
					ManejaExcepcion.controlaNum();
				}
				while (auxiliar.equals(""));
				cliente.setAniosCliente(Integer.parseInt(auxiliar));
				break;
			}
			}
	}
					
		
	
	//Metodo Cargar Datos, agrega clientes por archivo
	public static void cargarDatos() throws IOException {
		Utilidad.limpiaPantalla();
		do {
			System.out.println("-------------Cargar Datos-------------");
			System.out.println("Indique su la familia de su Sistema Operativo");
			System.out.println("1- Windows");
			System.out.println("2- Linux, MAC (base Unix)");
			auxiliar = scan.nextLine();
			ManejaExcepcion.controlaOpcionEdita2();
		}
		while (auxiliar.equals(""));
		//Hago una instancia al metodo sobrecargado
		cargarDatos(Integer.parseInt(auxiliar));
	}
	
	//Sobreescribo el metodo CargarDatos mediante una sobrecarga
	public static void cargarDatos(int x){
		Utilidad.limpiaPantalla();	
		do {
			if (x == 2) {
				System.out.println("---------Cargar Datos en Linux o Mac-----------\r\n"
						+ "Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
			}
			else {
				System.out.println("---------Cargar Datos en Windows---------------\r\n"
						+ "Ingresa la ruta en donde se encuentra el archivo DBClientes.csv");
			}
			auxiliar = scan.nextLine();
			if (auxiliar.equals(null)||auxiliar.trim().equals("")) {
				System.out.println("Debe definir una ruta valida, no vacia ni con espacios");
				auxiliar = "";
			}			
		}
		while (auxiliar.equals(""));
		auxiliar = auxiliar + "/"+ fileName1;
		archivoServicio.cargarDatos(auxiliar);
	}
	
	//Metodo para exportar la data
	public static void exportarDatos() throws IOException {
		if (clienteServicio.getListaClientes().size() != 0) {
			do {
				System.out.println("---------Exportar Datos-----------\r\n"
					+ "Seleccione el formato a exportar:\r\n"
					+ "1.-Formato csv\r\n"
					+ "2.-Formato txt\r\n"
					+ "Ingrese una opción para exportar:\r\n"
					+ "----------------------------------\r\n"
					+ "");
				auxiliar = scan.nextLine();
				ManejaExcepcion.controlaOpcionEdita2();
			}
			while (auxiliar.equals(""));
			opcion = Integer.parseInt(auxiliar);
		//Instancio el metodo exportarDatos sobrescrito en sobrecarga
			exportarDatos(opcion);
		}
		else {
			System.out.println("No hay clientes definidos para generar un archivo");
		}
	}
	
	//Sobrescribo metodo exportarDatos mediante una sobrecarga
	public static void exportarDatos(int x) throws IOException {
		Utilidad.limpiaPantalla();
		do {
			System.out.println("-------------Exportar Datos-------------");
			System.out.println("Indique la familia de su Sistema Operativo");
			System.out.println("1- Windows");
			System.out.println("2- Linux, MAC (base Unix)");
			auxiliar = scan.nextLine();
			ManejaExcepcion.controlaOpcionEdita2();
		}
		while (auxiliar.equals(""));
		Utilidad.limpiaPantalla();
		//Defino y manejo las diversas opciones
		do {
			if (Integer.parseInt(auxiliar) == 2 && x == 1) {
				System.out.println("---------Exportar Datos en Linux o Mac--------------");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo "+ fileName +".csv");
			}
			else if (Integer.parseInt(auxiliar) == 2) {
				System.out.println("---------Exportar Datos en Linux o Mac--------------");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo "+ fileName +".txt");
			}
			else if (Integer.parseInt(auxiliar) == 1 && x == 1) {
				System.out.println("---------Exportar Datos en Windows--------------");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo "+ fileName +".csv");
			}
			else {
				System.out.println("---------Exportar Datos en Windows--------------");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo "+ fileName +".txt");
			}
			auxiliar = scan.nextLine();
			if (auxiliar.equals(null)||auxiliar.trim().equals("")) {
				System.out.println("Debe definir una ruta valida, no vacia ni con espacios");
				auxiliar = "";
			}
		}
		while (auxiliar.equals(""));
		
		//Manejo la instancia y variable fileName acorde a selección del formato del archivo
		if (x == 1) {
			fileName = auxiliar + "/"+fileName+".csv";
			exportadorCsv.exportar(fileName, clienteServicio.getListaClientes());
			//Reseteo el atributo estatico tras el proceso
			fileName= "Clientes";
		}
		else {
			fileName = auxiliar + "/"+fileName+".txt";
			exportarTxt.exportar(fileName, clienteServicio.getListaClientes());
			fileName= "Clientes";
		}
	}
	
	//Metodo de salida
	public static void terminarPrograma() throws InterruptedException {
		System.out.println("Abandonando el sistema de clientes...");
		//Instancio al metodo sobreescrito por sobrecarga donde le envio parametro de tiempo en milisegundos que debe esperar
		Utilidad.tiempoEsperaPrint();
		terminarPrograma(1000);
	}
	
	public static void terminarPrograma(int tiempo) {
		try {
			//Cierro el scanner
			scan.close();
			Thread.sleep(tiempo);
			System.out.println("Acaba de salir del sistema");
			System.exit(0);
			
		}
		 catch (Exception error){
			System.out.println("No se ha podido salir del programa por un error: "+ error.getMessage());
			}
	}
	
}
