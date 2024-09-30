package pool;

import java.util.ArrayList;

import entidades.Socio;

public class PoolSocio {
	// Es un poco absurdo almacenar aquí los socios
	// deberían estar en la Base de Datos
	private ArrayList<Socio> socios;
	private Secuencia idsocio=null;

	public PoolSocio() {
		socios = new ArrayList<Socio>();
		idsocio=new Secuencia();
	}
	// Devuelve número de socios
	public int numeroSocios() {
		return socios.size();
	}
	// Devuelve el objeto Socio si lo encuentra, sino null
	public Socio buscaSocio(String nif) {
		for (Socio s : socios)
			if (s.getNif().equals(nif))
				return s;
		return null;

	}
	// Inserta el Socio en la lista de socios
	// devuelve true si no existe, sino false
	public boolean altaSocio(Socio s) {
		// Lo primero es asignar un id antes de cargarlo
		// Si ya existe esa socio devuelvo false
		Socio existe=buscaSocio(s.getNif());
		if (existe!=null) return false;
		// Pido un número nuevo a la secuencia
		s.setIdsocio(idsocio.next());
		socios.add(s);
		return true;
	}
	// Da de baja el socio con ese cif
	// devuelve true si lo ha podido localizar
	public boolean bajaSocio(String nif) {
		Socio s = buscaSocio(nif);
		if (s != null) {
			socios.remove(s);
			return true;
		}
		return false;
	}
}

	