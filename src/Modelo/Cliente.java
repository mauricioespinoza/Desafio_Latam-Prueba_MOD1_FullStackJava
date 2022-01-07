package Modelo;

public class Cliente {

	//Atributos
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private int aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	//Constructor
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	public Cliente() {
		
	}

	//Getters and setters
	public String getRunCliente() {
		return runCliente;
	}
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public int getAniosCliente() {
		return aniosCliente;
	}
	public void setAniosCliente(int aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	//ToString()
	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
}
