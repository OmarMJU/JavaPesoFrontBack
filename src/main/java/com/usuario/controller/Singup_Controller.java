package com.usuario.controller;

import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import com.db.utils.DatosUsuarios;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = {"/Singup_Controller"})
public class Singup_Controller extends HttpServlet {
	public static final long serialVersionUID = 1L;
	
	public Singup_Controller() {
		super();
	}
	
	public void procesaPeticion(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException, Exception {
		PrintWriter escritura = respuesta.getWriter();
		respuesta.setContentType("text/plain");
		
		String jsonPeticion = peticion.getParameter("datasUser");
		JSONObject json = new JSONObject(jsonPeticion);		
		String nombre = json.getString("nombreR");
		String apellido = json.getString("apellidoR");
		String email = json.getString("emailR");
		String password = json.getString("passwordR");
		
		DatosUsuarios userDB = new DatosUsuarios();
		userDB.registroUsuario(nombre, apellido, email, password);
		
		escritura.print("Registro exitoso");
		escritura.flush();
		escritura.close();
		
	}
	@Override
	protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
		try {
			procesaPeticion(solicitud, respuesta);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}