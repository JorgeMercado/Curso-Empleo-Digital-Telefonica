import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("prueba.dat");
		try{
			FileInputStream fi = new FileInputStream(f);
			int n = fi.read();
			System.out.println(n);
			n = fi.read();
			System.out.println(n);
			fi.close();

		}
		catch(IOException ioe){
			System.out.println("No se ha podido escribir en el archivo");
		}
	}

}
