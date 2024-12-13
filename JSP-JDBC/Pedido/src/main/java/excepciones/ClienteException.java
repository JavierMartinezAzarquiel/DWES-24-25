package excepciones;

public class ClienteException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6414394870135798463L;
	public ClienteException() {
    }
    public ClienteException(String msg) {
        super(msg);
    }
}
