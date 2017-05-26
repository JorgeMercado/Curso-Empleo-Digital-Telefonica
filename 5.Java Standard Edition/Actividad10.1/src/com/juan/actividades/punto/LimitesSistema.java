package com.juan.actividades.punto;

interface LimitesSistema{
	int MAX_X=300;
	int MIN_X=0;
	int MAX_Y=500;
	int MIN_Y=0;
	
	default public void normalizar(int x, int y, Punto punto) {
		// con esta función se asegura que ningún punto estará
		// fuera de los límites del sistema
		if (x > MAX_X)
			punto.setX(MAX_X);
		else if (x < MIN_X)
			punto.setX(MIN_X);
		else
			punto.setX(x);
		if (y > MAX_Y)
			punto.setY(MAX_Y);
		else if (y < MIN_Y)
			punto.setY(MIN_Y);
		else
			punto.setY(y);
	}
	
	public void pintar();

	
}
