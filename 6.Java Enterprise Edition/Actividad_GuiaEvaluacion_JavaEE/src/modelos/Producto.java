package modelos;

public class Producto {
	//Datos o propiedades
	private int idProducto;
	private String descripcion;
	private double precio;
	
	//Construcotores
	//Constructor vacio
	public Producto(){
		
	}
	//Constructor con 3 parametros
	public Producto (int id_producto,String descripcion,double precio){
		this.idProducto= id_producto;
		this.descripcion=descripcion;
		this.precio=precio;
	}
	//Metodos
	//Getters y setters
	public int getId_producto() {
		return idProducto;
	}
	public void setId_producto(int id_producto) {
		this.idProducto = id_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
