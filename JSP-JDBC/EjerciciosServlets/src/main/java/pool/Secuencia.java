package pool;

public class Secuencia {
	int valor=0;
	// Con cada llamada incrementa el valor y lo devuelve
	public synchronized int next() {
		return ++valor;
		
	}

}
