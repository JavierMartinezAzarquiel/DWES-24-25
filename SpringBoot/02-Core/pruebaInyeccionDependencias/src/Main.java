
import entrenadores.EntrenadorFutbol;

public class Main {
    public static void main(String[] args) {

        Deportista javi = new Deportista("Javier",new EntrenadorFutbol());
        System.out.println(javi.getMiEntrenador().getEntrenamiento());
    }
}