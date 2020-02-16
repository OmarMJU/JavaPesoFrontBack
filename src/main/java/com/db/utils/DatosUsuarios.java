package com.db.utils;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.usuario.modelo.Usuario;

/**
 * Clase de persistencia con la DB para datos del usuario: insersion y consulta.
 * @author omarjuarezurbina
 *
 */
public class DatosUsuarios {
	private Connection dbConnection;
	private static final String insertUsuario = "INSERT INTO USUARIOS (NOMBRE, APELLIDOS, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
	private static final String selectUsuario = "SELECT NOMBRE, APELLIDOS, EMAIL FROM USUARIOS WHERE EMAIL = ${email} AND PASSWORD = ${pass}";
	
	/**
	 * Constructor de la clase que crea una conexion con la BD.
	 */
	public DatosUsuarios() {
		dbConnection = DB_Coneccion.getDBConeccion();
	}
	
	/**
	 * Metodo el cual inserta un usuario en la DB.
	 * @param nombre
	 * @param apellidos
	 * @param emal
	 * @param pass
	 * @throws SQLException
	 */
	public void registroUsuario(String nombre, String apellidos, String emal, String pass) throws SQLException, Exception {
		PreparedStatement pStatement = null;
		
		try {
			pStatement = dbConnection.prepareStatement(insertUsuario);
			pStatement.setString(1, nombre);
			pStatement.setString(2, apellidos);
			pStatement.setString(3, emal);
			pStatement.setString(4, pass);
			
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Metodo el cual busca un usuario en la DB por medio del <p>Usuario</p> y el <p>Password</p>   
	 * @param email Representa el email del usuario.
	 * @param password Representa el pass del usuario.
	 * @return
	 * @throws SQLException
	 */
	public Usuario consultaUsuario(String email, String password) throws Exception {
		Usuario usuario = null;
		Statement statement = null;
		
		try {
			statement = dbConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectUsuario.replace("${email}", email).replace("${pass}", password));
			
			if(resultSet != null) {
				usuario = new Usuario();
				
				while (resultSet.next()) {
					usuario.setNombre(resultSet.getString(1));
					usuario.setApellidos(resultSet.getString(2));
					usuario.setEmail(resultSet.getString(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
}