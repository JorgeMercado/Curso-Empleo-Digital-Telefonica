package modelo;

public class Producto {

	private int idproducto;
	private String nombre;
	private double precio;
	
	public Producto(int idproducto,String nombre,double precio){
		this.idproducto=idproducto;
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString(){
		return "id:  "+idproducto+" Nombre: "+nombre+" precio: "+precio;
	}
	
}
