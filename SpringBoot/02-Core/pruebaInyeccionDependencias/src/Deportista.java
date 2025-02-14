import entrenadores.Entrenador;

public class Deportista {
    private String nombre;
    private Entrenador miEntrenador;

    public Deportista(String nombre, Entrenador miEntrenador) {
        this.nombre = nombre;
        this.miEntrenador=miEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getMiEntrenador() {
        return miEntrenador;
    }

    public void setMiEntrenador(Entrenador miEntrenador) {
        this.miEntrenador = miEntrenador;
    }
}
