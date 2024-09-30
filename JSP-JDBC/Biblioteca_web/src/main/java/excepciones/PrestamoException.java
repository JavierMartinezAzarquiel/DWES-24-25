package excepciones;

@SuppressWarnings("serial")
public class PrestamoException extends Exception {
	public PrestamoException() {	
	};
	public PrestamoException(String message) {
		super(message);
	}
}
