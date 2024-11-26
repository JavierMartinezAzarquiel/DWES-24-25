package captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class VerificarRecaptcha {

    public static boolean validate(String gRecaptchaResponse) throws IOException  {
      	 String urlCaptcha = "https://www.google.com/recaptcha/api/siteverify?secret=6Lee-IgqAAAAAAq_LPxP9eJhaheo9aD2EtUX25S-&response="+gRecaptchaResponse;

          if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
              return false;
          }

          try {
        	  URL url=URI.create(urlCaptcha).toURL();
              HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
              BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
              String inputLine;
              StringBuffer connectionResponse = new StringBuffer();
              while ((inputLine = in.readLine()) != null) {
           	   connectionResponse.append(inputLine);
              }
              in.close();
              System.out.println("Respuesta por parte del servicio Recaptcha de Google en Json="+connectionResponse.toString());
              JsonReader jsonReader = Json.createReader(new StringReader(connectionResponse.toString()));
              JsonObject jsonObject = jsonReader.readObject();
              jsonReader.close();
              if(jsonObject.getBoolean("success"))
           	   return true;
              else
           	   return false;
          } catch (MalformedURLException e) {
     	     e.printStackTrace();
          } catch (IOException e) {
     	     e.printStackTrace();
     	     throw e;
          }
          return false;
      }
}


