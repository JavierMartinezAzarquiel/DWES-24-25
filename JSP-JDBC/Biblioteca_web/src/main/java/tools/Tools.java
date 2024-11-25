package tools;


import java.security.SecureRandom;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;

public class Tools {
	// de 1 genero 000001A (seguido de la letra del NIF)
	public static String creaSerie(int a) {
		return String.format("%06d%c", a,calculaLetra(a));
		
	}
	private static char calculaLetra(int dni) {
		String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
		return juegoCaracteres.charAt(dni % 23);
	}
	

	/**
	 * 
	 * @param    ancho: tamaño del token a generar    
	 * @return   Una cadena aleatoria de ancho caracteres formada por mezcla de mayúsculas,
	 *           minúsculas y números.
	 *           
	 * @throws Exception
	 */
	private static String generaAleatorio(int ancho) throws Exception {
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	    String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	    String NUMBER = "0123456789";
	    String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	    SecureRandom random = new SecureRandom();
	    StringBuilder sb = new StringBuilder(ancho);
	    
	    for (int i = 0; i < ancho; i++) {
	        // 0-62 (exclusive), retornos aleatorios 0-61
	        int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
	        char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
	        sb.append(rndChar);
	    }

	    return sb.toString();   
	}

	/**
	 * 
	 * @return  Token de 30 caracteres aleatorios para pasarlos por correo electrónico
	 *          como método de validación de un alta de usuario.
	 * @throws Exception
	 */
	
	public static String generaToken() throws Exception {
		return generaAleatorio(50);
	}
	
	public static String generaClave() throws Exception {
		return generaAleatorio(6);
	}
	

	
	/* ***********************************************************************************/
	/* Métodos para enviar correo con Google. Usamos la cuenta no_reply@ies-azarquiel.es */
	/* creada por Julio Efrén                                                            */
	/* ***********************************************************************************/
	
	/**
	 * 
	 * @param destinatario del mensaje de correo
	 * @param asunto: campo asunto del mensaje
	 * @param cuerpo: cuerpo del  mensaje.
	 */
	public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
		String remitente = "no_reply@ies-azarquiel.es";  
		String clave="*********";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.addRecipients(Message.RecipientType.TO, destinatario);// Se podrían añadir varios de la misma manera
			message.setSubject(asunto);
			// Para poner texto plano
			//message.setText(cuerpo);
			// Si no pones este encabezado no interpreta el html
			message.setContent(cuerpo,"text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
	}
	
	public static String creaCuerpoCorreo(String email,String token) {
		String ref="http://localhost:8080/Biblioteca_web/controller?operacion=validacion&email="+email+"&token="+token;
		StringBuilder st=new StringBuilder();
		st.append("<!DOCTYPE html>");
		st.append("<html lang='es'>");
		st.append("  <head>");
		st.append("    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		st.append("   <title>Correo de IES Azarquiel</title>");
		st.append(" </head>");
		st.append(" <body>");
		st.append(" Recibes este correo porque te has registrado en la  aplicación <strong>Biblioteca</strong> <br/>");
		st.append(" Para  empezar a usar la aplicación,debes validar antes el correo");
		st.append(" con el que te registraste.<br/><br/>");
		st.append(" Pulsa en el siguiente enlace para activar tu usuario <br/><br/>");
		st.append(" <a href=\""+ref+"\" style=\"font-size:36px;text-decoration:none;background-color:lightgreen; \"> Pulse para validar el usuario </a>");
		st.append(" </body>");
		st.append("</html>");
		return st.toString();
	}
	

}
