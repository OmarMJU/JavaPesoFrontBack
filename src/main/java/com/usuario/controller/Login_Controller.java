package com.usuario.controller;

import org.json.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import com.db.utils.DatosUsuarios;
import com.usuario.modelo.Usuario;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = {"/Login_Controller"})
public class Login_Controller extends HttpServlet {
	public static final long serialVersionUID = 1L;
	
	public Login_Controller() {
		super();
	}
	
	public void procesaPeticion(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException, Exception {
		PrintWriter escritura = respuesta.getWriter();
		respuesta.setContentType("text/plain");
		
		String jsongPeticion = peticion.getParameter("datasUser");
		JSONObject json = new JSONObject(jsongPeticion);
		String usuario = json.getString("usuarioID");
		String pass = json.getString("passwordID");
		
		DatosUsuarios userDB = new DatosUsuarios();
		Usuario myUsuario = userDB.consultaUsuario(usuario, pass);
		
		if(myUsuario != null)
			escritura.print(myUsuario.toString());
		else
			escritura.print("No se encuetra el usuario solicitado.");
		
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