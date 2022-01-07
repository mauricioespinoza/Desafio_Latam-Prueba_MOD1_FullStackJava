package Utilidades;
import java.io.*;

import Modelo.Cliente;
import Vista.Menu;

public class ManejaExcepcion{
	//Metodo con el que verifico el string de archivo
	public static File existeDirectorio(File archivo) throws IOException{
		try {
			if (archivo.exists()) {
				System.out.println("El archivo "+ archivo + " ya fue creado en otra ejecución del programa");
				System.out.println("En está instancia será sobreescrito, tenga precaución");
			}
			
			else {
				System.out.println("Es la primera vez que ejecuta el programa o el archivo base fue eliminado, \n se procede a crear el archivo "+archivo);
			
			}
					
		}
		catch (Error e){
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
        catch (Exception error){
			System.out.println("Se ha generado un error asociado a logica o programador"+ error.getMessage());
		}
		return archivo;
	}
	
	//Metodo con el que se controla la opcion a ingresar
		public static void controlaOpcion() throws IOException{
			
			try {
				if((!Menu.leer.matches("[0-9]{1,1}"))|| Menu.leer.trim().equals("")
						||Integer.parseInt(Menu.leer) > 6 ||Integer.parseInt(Menu.leer) < 1) {
					System.out.println("La opción no puede ser 0, mayor de 6 o \n espacios en blanco u otros caracteres no númericos");
					System.out.println("__________________________________");
					Menu.leer = "";
				 }
			}
			catch (Error e){
				Menu.leer = "";
				System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
			}
	        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
	        catch (Exception error){
				Menu.leer = "";
				System.out.println("Se ha generado un error asociado a logica o programador"+ error.getMessage());
			}
		}
		
	
	//Metodo con el que controlo "char"
	public static void ControlaCaracter() {
		
		if (Menu.auxiliar.trim().equals("") || Menu.auxiliar.equals(null)) {
			Menu.auxiliar = "";
			System.out.println("No es valido la entrada de cadenas de espacios en blanco o sin data");
        	}
		else {
		try {
			if(!Menu.auxiliar.trim().matches("^[a-zA-Z ,;0-9'\\u00E0-\\u00FC]*")) {
				Menu.auxiliar = "";
				System.out.println("Puede usar solo letras, números, acentos, comas, punto/coma, apostrofes y espacios");
			 }
		}
		catch (Error e){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
        catch (Exception error){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a logica o programador: "+ error.getMessage());
		}
		}
	
		}
	

	
	//Metodo controla ingreso números
		
	public static void controlaNum() throws IOException{
		
		try {
			if((!Menu.auxiliar.matches("[0-9]*"))|| Menu.auxiliar.trim().equals("")||Integer.parseInt(Menu.auxiliar) < 1) {
				System.out.println("No puede contener caracteres distintos de número o ser 0");
				System.out.println("__________________________________");
				Menu.auxiliar = "";
			 }
		}
		catch (Error e){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
        catch (Exception error){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a logica o programador"+ error.getMessage());
		}
		}
	
	//Metodo con el que controlo la opción de número de edición para cliente donde se agregaran otros datos distintos al estado
	public static void controlaOpcionEdita() throws IOException{
		
		try {
			if((!Menu.auxiliar.matches("[1-9]{1,1}"))|| Menu.auxiliar.trim().equals("")||Integer.parseInt(Menu.auxiliar) > 7 
					||Integer.parseInt(Menu.auxiliar) < 1) {
				System.out.println("La opción no puede ser 0 ni mayor que 7, \n espacios en blanco u otros caracteres no númericos");
				System.out.println("__________________________________");
				Menu.auxiliar = "";
			 }
		}
		catch (Error e){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
        catch (Exception error){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a logica o programador"+ error.getMessage());
		}
		}
	
	//Metodo que controla la opción de edición para cliente en cambio de estado
	public static void controlaOpcionEdita2() throws IOException{
		
		try {
			if((!Menu.auxiliar.matches("[1-2]{1,1}"))|| Menu.auxiliar.trim().equals("")|| Menu.auxiliar.trim().equals(null)||Integer.parseInt(Menu.auxiliar) > 2 
					||Integer.parseInt(Menu.auxiliar) < 1) {
				System.out.println("La opción no puede ser 0 ni mayor que 2, \n espacios en blanco u otros caracteres no númericos");
				System.out.println("__________________________________");
				Menu.auxiliar = "";
			 }
		}
		catch (Error e){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
		}
        //Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
        catch (Exception error){
			Menu.auxiliar = "";
			System.out.println("Se ha generado un error asociado a logica o programador"+ error.getMessage());
		}
		}
	
	//Valida Rut Cliente previo a inserción u edición
			public static void RutCliente() {
				String cadenaOriginal = Menu.auxiliar;
				String[] rut; 
				String rutdv[];
				//Controlo que la cadena no venga vacia
				if (Menu.auxiliar.trim().equals("")||Menu.auxiliar.trim().equals(null)){
					System.out.println("El rut no puede venir vacio");
					Menu.auxiliar = "";
				}
				//controlo los caracteres que soporta el string de RUT
				else if (!Menu.auxiliar.matches("[0-9Kk.-]*")) {
					System.out.println("El rut debe estar conformado por digitos + el digito verificador, siendo este último caracter \n "
							+ "el unico que puede soportar la letra K");
					Menu.auxiliar = "";
				}
				//Controlo que la cadena contenga guión
				else if (Menu.auxiliar.contains("-") == false) {
					System.out.println("El RUT debe contener guión separador del digito verificador");
					Menu.auxiliar = "";
				}
				//Controlo que la cadena contenga 1 solo guión
				else if (Menu.auxiliar.contains("-") == true) {
					int total = 0;
					char temp;
					for (int i = 0; i < Menu.auxiliar.length(); i++) {
			            temp = Menu.auxiliar.charAt(i);
			            if (temp == '-') {
			                total++;}
			        }
					if (total != 1) {
						System.out.println("El RUT debe contener 1 solo guión que separa el DV");
						Menu.auxiliar = "";
					}
					//Hago un manejo de excepción dedicado si se ingreso RUT con puntos
					else if (Menu.auxiliar.contains(".") == true) {
					total = 0;
					temp = 0;
					rut = Menu.auxiliar.split("\\.");
					//Controlo que solo 2 puntos vengan en la cadena
					for (int i = 0; i < Menu.auxiliar.length(); i++) {
			            temp = Menu.auxiliar.charAt(i);
			            if (temp == '.') {
			                total++;}
			        	}
						if (total != 2) {
							System.out.println("El RUT debe contener 2 separadores de tipo punto");
							Menu.auxiliar = "";
						}
					
					//Control de unidades de millon del rut
						
						else if (!rut[0].matches("[0-9]*")) {
							
							System.out.println("El valor de Millones del RUT debe ser un digito");
							Menu.auxiliar = "";
						}
						else if (rut[0].equals("")|| rut[0].equals(null)) {
							System.out.println("El valor expresado en millones del RUT no puede venir vacio");
							Menu.auxiliar = "";
						}
						else if (rut[0].length()<1||Integer.parseInt(rut[0]) == 0||Integer.parseInt(rut[0]) > 50000000){
							System.out.println("El Rut no puede ser menos de 1 millon ni mayor a 50 millones para cliente persona natural");
							Menu.auxiliar = "";
						}
					
					//Control de centenas, decenas y unidades de mil del rut
						else if (!rut[1].matches("[0-9]*")) {
							System.out.println("El valor de miles del RUT debe ser un digito");
							Menu.auxiliar = "";
						}
						else if (rut[1].equals("")|| rut[1].equals(null)) {
							System.out.println("El valor expresado en miles del RUT no puede venir vacio");
							Menu.auxiliar = "";
						}
						else if (rut[1].length()<3){
							System.out.println("El valor en miles del rut debe si o si expresarse con 3 digitos");
							Menu.auxiliar = "";
						}
					
					//Control de centenas, decenas y unidades del rut + dv
						rutdv = rut[2].split("-");
						if (rutdv.length <= 1) {
							System.out.println("El digito verificador del RUT no puede estar vacio");
							Menu.auxiliar = "";
						}
						else if (!rutdv[0].matches("[0-9]*")) {
							System.out.println("El valor de centenas y unidades inferiores del RUT debe ser un digito");
							Menu.auxiliar = "";
						}
						else if (rutdv[0].equals("")|| rutdv[0].equals(null)) {
							System.out.println("El valor de centenas y unidades inferiores del RUT no puede venir vacio");
							Menu.auxiliar = "";
						}
						else if (rutdv[0].length()<3){
							System.out.println("El valor de centenas y unidades inferiores del rut debe si o si expresarse con 3 digitos");
							Menu.auxiliar = "";
						}
					//Controlo digito verificador
						else if (!rutdv[1].matches("[0-9Kk]{1,1}")) {
							System.out.println("El digito verificador del RUT debe ser un digito o la letra K");
							Menu.auxiliar = "";
						}
						else if (rutdv[1].equals("")|| rutdv[1].equals(null)) {
							System.out.println("El digito verificador del RUT no puede venir vacio");
							Menu.auxiliar = "";
						}
						else if (rutdv[1].length() != 1){
							System.out.println("El digito verificador del rut debe si o si expresarse con 1 caracter");
							Menu.auxiliar = "";
						}
					}
					//Controlo rut ingresado sin puntos
					else if (Menu.auxiliar.contains(".") == false) {
						rut = Menu.auxiliar.split("-");
						if (rut.length <= 1) {
							System.out.println("El digito verificador del RUT no puede estar vacio");
							Menu.auxiliar = "";
						}
						else if (!rut[0].matches("[0-9]*")) {
							System.out.println("La parte numerica del RUT debe estar conformada solo por Digitos");
							Menu.auxiliar = "";
						}
						else if (rut[0].equals("")|| rut[0].equals(null)) {
							System.out.println("La parte numerica del RUT no puede venir vacia");
							Menu.auxiliar = "";
						}
						else if (rut[0].length()<7||Integer.parseInt(rut[0]) == 0||Integer.parseInt(rut[0]) > 50000000){
							System.out.println("El Rut no puede ser menos de 1 millon ni mayor a 50 millones para cliente persona natural");
							Menu.auxiliar = "";
						}
					//Controlo digito verificador
						else if (!rut[1].matches("[0-9Kk]{1,1}")||rut[1].trim().equals("")||Integer.parseInt(rut[1]) > 9) {
							System.out.println("El digito verificador del RUT debe ser un digito o la letra K, tampoco puede ser mayor a 9");
							Menu.auxiliar = "";
						}
						
					}
				}
				
				//Aca entro derechamente a la validación MOD11
			
					try {
						//Declaro variables para proceso
						String DV;
						
						int resultado = 0;
						int suma = 0;
						int patron = 2;
						
						//Manipulo la variable de entrada
						Menu.auxiliar = Menu.auxiliar.trim().replace(".", "");
						Menu.auxiliar = Menu.auxiliar.trim().replace("-", "");
						DV = Menu.auxiliar.substring(Menu.auxiliar.length()-1, Menu.auxiliar.length());
						Menu.auxiliar = Menu.auxiliar.substring(0,Menu.auxiliar.length()-1);
						//Invierto la cadena de rut para hacerla más manejable
						StringBuilder invertido = new StringBuilder(Menu.auxiliar);
						Menu.auxiliar = invertido.reverse().toString();
						//Recorro el rut con for y voy multiplicando y sumando simultaneamente
						for (int i = 0; i < Menu.auxiliar.length(); i++) {
							resultado = Integer.parseInt(Menu.auxiliar.substring(i, (i+1))) * patron;
							suma = suma + resultado;
							patron++;
							if (patron > 7) {
								patron = 2;
							}
						}
						//Manejo dentro de la misma variable suma la obtención del calculo del DV
						suma = suma%11;
						suma = 11-suma;
						//Valido el DV
						if (DV.toLowerCase().equals("k") && suma == 10) {
							 Menu.auxiliar =  cadenaOriginal;
						}
						else if (Integer.parseInt(DV) == 0 && suma == 11) {
							 Menu.auxiliar =  cadenaOriginal;
						}
						else if (Integer.parseInt(DV) != suma) {
							System.out.println("El digito verificador del  RUT no es valido");
							 Menu.auxiliar = "";
						}
						else {
							 Menu.auxiliar =  cadenaOriginal;
						}
						
						//Finalmente, consulto la existencia del rut en el array
						System.out.println();
						if (Menu.clienteServicio.getListaClientes() == null|| Menu.clienteServicio.getListaClientes().size() == 0) {
							System.out.println("Es el primer RUT ingresado en el registro");
							Menu.auxiliar =  cadenaOriginal;
							
						}
						else {
							for (Cliente cliente : Menu.clienteServicio.getListaClientes()) {
								if (Menu.auxiliar.equals(cliente.getRunCliente())){
									System.out.println("El rut que esta ingresando ya existe en el registro");
									Menu.auxiliar = "";
								}
							}
						}
					
					}
					catch (Error e){
						Menu.auxiliar = "";
						System.out.println("Se ha generado un error asociado a Hardware: "+ e.getMessage());
					}
					//Aca controlo a nivel más generico excepciones de logica de programa o errores en la programación
					catch (Exception error){
						Menu.auxiliar = "";
						System.out.println("Se ha generado un error asociado a logica o programador: "+ error.getMessage());
					}
				
			}
			
	
}
