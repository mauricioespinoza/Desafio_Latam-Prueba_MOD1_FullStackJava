package Utilidades;


//Metodo que limpia la pantalla
public class Utilidad {
	public static void limpiaPantalla(){
		for (int i=0; i < 10; i++)
		{
		System.out.println("");
		}
		System.out.println();
	    System.out.flush();
	
	}
	
	//MNetodo que hace que espere 3 segundos antes de pasar al proximo paso en la ejecución
	public static void tiempoEsperaPrint() throws InterruptedException {
		try {
			//la medida a usar se expresa en milisegundos, 1000 = 1 segundo
			Thread.sleep(2500);
		}
		 catch (Exception error){
			System.out.println("El tiempo de espera ha sido interrumpido por un error: "+ error.getMessage());
			}
	}
	
	
	//Valido el Sistema operativo y la logica de los slash de la ruta para el manejo de exportar y cargar data por archivos
	public static String ValidaArchivo(String fileName) {
		String os = System.getProperty("os.name");
		System.out.println("El sistema operativo detectado es: "+ os);
		if (os.contains("Windows"))
        {
			fileName = fileName.trim().replace("/", "\\");
        }
        else
        {
        	fileName = fileName.trim().replace("\\", "/");
        }
		return fileName;
	}

}
