package modelo;

public class Libro {
	//Datos o propiedades
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;

	//Construcotres
	//Construcor 4 parametros
	public Libro(int isbn,String titulo,String autor,int paginas){
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas= paginas;
	}
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	//Metodos
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	//ToString
		@Override
		public String toString() {
			return "----LIBRO---- "
					+ "\nISBN= " + isbn + 
					"\nTitulo= " + titulo+
					"\nAutor= " + autor +
					"\nPaginas= " + paginas+"\n";
			
		}
}
