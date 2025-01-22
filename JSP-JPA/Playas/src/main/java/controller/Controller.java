/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Ccaa;
import model.Municipio;
import model.Playa;
import model.Provincia;
import model.Punto;
import model.PuntoView;
import model.Usuario;
import java.io.IOException;
import java.util.List;

import daos.DAOCcaa;
import daos.DAOMunicipio;
import daos.DAOPlaya;
import daos.DAOProvincia;
import daos.DAOUsuario;
import daos.DaoPunto;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Controller")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        RequestDispatcher dispatcher;

        List<Ccaa> comunidades;
        Usuario usuario = null;
        Ccaa comunidadSelected = null;
        Provincia provinciaSelected = null;
        Municipio municipioSelected = null;
        Playa playa= null;
        String msg;
        Query q;
        int searchState=0;

       switch(op) {
       
       
       case "inicio": {
    	   
            comunidades = DAOCcaa.getAllCcaa();
            
            session.setAttribute("comunidades", comunidades);
            session.setAttribute("comunidadSelected", comunidadSelected);
            session.setAttribute("provinciaSelected", provinciaSelected);
            session.setAttribute("municipioSelected", municipioSelected);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
        } 
       case "ccaa": {
            // posicion, índice del List
            String idccaa = request.getParameter("idccaa");
            comunidadSelected = DAOCcaa.getCcaa(Long.parseLong(idccaa));
            
            session.setAttribute("comunidadSelected", comunidadSelected);
            session.setAttribute("provinciaSelected", null);
            session.setAttribute("municipioSelected", null);
            request.getRequestDispatcher("home.jsp").forward(request, response);
    
            break;
        } 
       case "provincia": {
            // ahora viene el id de la provincia
            String idprovincia = request.getParameter("idprovincia");
            provinciaSelected = DAOProvincia.getProvincia(Long.parseLong(idprovincia));
            
            session.setAttribute("provinciaSelected", provinciaSelected);
            session.setAttribute("municipioSelected", null);

            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
        } 
       case "municipio": {
            // De nuevo viene el id del municipio    
            String idmunicipio = request.getParameter("idmunicipio");
            municipioSelected = DAOMunicipio.getMunicipio(Long.parseLong(idmunicipio));
            
            session.setAttribute("municipioSelected", municipioSelected);
            
            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
        } 
       case "login": {
            String nick = request.getParameter("nick");
            String pass = request.getParameter("pass");
            
            usuario = DAOUsuario.getUsuario(nick,pass);

            if (usuario==null) { // Login incorrecto procedemos a insertarlo
                usuario = new Usuario();
                usuario.setId(Long.valueOf("1"));
                usuario.setNick(nick);
                usuario.setPass(pass);
                DAOUsuario.insertaUsuario(usuario);
                msg = "User Created...";
            }
            else
                msg = "Login Ok ...";
            session.setAttribute("usuario", usuario);
            session.setAttribute("msg", msg);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
        } 
       case "logout": {
            session.removeAttribute("usuario");
            session.setAttribute("msg", "Bye");
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);  
            break;
        } 
       case "detail":{
            // Nos vine el id de la playa
            String idplaya = request.getParameter("playa");
            
            playa = DAOPlaya.getPlaya(Long.parseLong(idplaya));
           
            List<Punto> puntos = playa.getPuntos();
            float puntosTotal = 0;
         
            for (Punto punto: puntos){
                puntosTotal = punto.getPuntos() + puntosTotal;
            }
            Integer star = Math.round(puntosTotal / puntos.size());
            
            session.setAttribute("playa", playa);
            session.setAttribute("star", star);

            dispatcher = request.getRequestDispatcher("detail.jsp");
            dispatcher.forward(request, response);
            break;
        } 
       case "puntuacion": {
            String idplaya = request.getParameter("idplaya");
            
            List<PuntoView> puntuaciones = DAOPlaya.getPuntos(Long.parseLong(idplaya));
            
            request.setAttribute("puntuaciones", puntuaciones);
            request.getRequestDispatcher("puntuaciones.jsp").forward(request, response);
            break;
        } 
       case "savePuntuacion":{
            String puntos = request.getParameter("puntos");
            playa = (Playa) session.getAttribute("playa");
            usuario = (Usuario) session.getAttribute("usuario");

            Punto punto = new Punto();
            punto.setId(1L);
            punto.setPuntos(Integer.valueOf(puntos));
            punto.setPlayaBean(playa);
            punto.setUsuarioBean(usuario);
            DaoPunto.insertaPunto(punto);
            playa = DAOPlaya.getPlaya(playa.getId());
            session.setAttribute("playa", playa);
            session.setAttribute("msg", "Anotado "+puntos+" puntos a "+playa.getNombre());
            request.getRequestDispatcher("home.jsp").forward(request, response);
            break;
        }
       }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
