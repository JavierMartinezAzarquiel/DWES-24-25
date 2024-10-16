package modelo;

public class Conversor {

	
	public static float convertirMillasAKm(float millas) { 
        return millas * 1.6093F;
	}
	
	public static float convertirKmAMillas(float km) { 
        return km / 1.6093F;
	}
}
