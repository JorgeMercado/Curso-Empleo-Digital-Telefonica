import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args){
		File f = new File("prueba.dat");
		try{
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(100);
			fo.write(200);
			fo.close();

		}
		catch(IOException ioe){
			System.out.println("No se ha podido escribir en el archivo");
		}
	}

}
