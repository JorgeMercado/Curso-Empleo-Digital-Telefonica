package modelos;

public class Anuncio {

	
	private int id;
	
	private String texto;
	
	public Anuncio(){
		
	}
	
	public Anuncio(int id,String texto){
		this.id=id;
		this.texto=texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null ) return false;
		else if(!(o instanceof Anuncio))return false;
		else{
			Anuncio a=(Anuncio)o;
			return a.id==id;
		}
	}
}
