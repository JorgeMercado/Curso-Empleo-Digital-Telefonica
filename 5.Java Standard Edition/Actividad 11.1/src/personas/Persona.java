package personas;


public class Persona {
	//Datos
	protected String nombre;
	protected int edad;
	protected char sexo;
	protected String dni;
	protected boolean bCasado;
	
	//Constructores
	public Persona(){
		
	}
	public Persona(String nombre, int edad, char sexo, String dni, boolean bCasado) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.dni = dni;
		this.bCasado = bCasado;
	}
	public Persona(Persona p){
		nombre=p.nombre;
		edad = p.edad;
		sexo = p.sexo;
		dni = p.dni;
		bCasado =p.bCasado;
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isbCasado() {
		return bCasado;
	}
	public void setbCasado(boolean bCasado) {
		this.bCasado = bCasado;
	}
	
	
	//Sobreescribir
	@Override
	public String toString() {
		return "Persona"+"\nNombre: "+nombre+"\nEdad: "+edad+"\nSexo: "+sexo+"\nDNI: "+dni+"\nCasado: "+bCasado;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (bCasado != other.bCasado)
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
	
	public void pintar(){
		System.out.println("--------------------");
		System.out.println(this);
	}
}
