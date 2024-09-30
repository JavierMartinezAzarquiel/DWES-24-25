/**
 *
 */
package excepciones;

/**
 * @author Ortiz modificado por Julio León
 *
 */
@SuppressWarnings("serial")
public class BibliotecaException extends Exception {

	/**
	 *
	 */
	public BibliotecaException() {

	}
	/**
	 *    Constructor al que pasamos como argumento el mensaje
	 *    de la excepción que se haya producido
	 */

	public BibliotecaException(String message) {
		super(message);
	}
}
