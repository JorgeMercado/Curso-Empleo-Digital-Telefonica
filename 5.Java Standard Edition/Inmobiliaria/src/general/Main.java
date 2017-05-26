package general;

public class Main {

	public static void main(String[] args) {
		//Creacion de inmuebles
		InmuebleEnVenta inmueble = new InmuebleEnVenta(100, true, "Calle molona",300,"Cardenas");
		InmuebleEnAlquiler inmueble1 = new InmuebleEnAlquiler(100, true, "Calle molona",300,"Mario");
		InmuebleEnVenta inmueble2 = new InmuebleEnVenta(1000,true,"C/cthulu",100000,"Chtulu");
		
		//Creacion de la inmobiliaria
		Inmobiliaria inmobiliaria = new Inmobiliaria("Jorge");
		inmobiliaria.add(inmueble);
		inmobiliaria.add(inmueble1);		
		inmobiliaria.add(inmueble2);


		//Imprimimos por pantalla el tamaño de nuestra inmobiliaria y sus inmuebles
		System.out.println(inmobiliaria);
		
		//Incrementamos el precio de los inmuebles en un 10%
		for (int i = 0; i < inmobiliaria.size(); i++) {
			Inmueble inm = inmobiliaria.get(i);
			double p = inm.getPrecio()*1.1;
			inm.setPrecio(p);
		}
		
		//Interface
		ConPropietario cp1 = inmobiliaria;
		cp1.setPropietario("Mario");
		ConPropietario cp2 = inmueble1;
		cp2.setPropietario("Darth Vader");
		System.out.println(inmobiliaria);
		
	}

}
