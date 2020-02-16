package com.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que crea una conexion con la DB
 * @author Omar M. Juárez.
 * 16/02/2020
 */
public class DB_Coneccion {
	private static Connection dbConnection = null;
	
	/**
	 * Crea una conexion con la BD, en caso que que ya la tenga solo regresa la conexion existente.
	 * @return objeto tipo <p>java.sql.Connection</p>
	 */
	public static Connection getDBConeccion() {
		if(dbConnection != null) {
			return dbConnection;
		} else {
			try {
				String dbDriver = System.getenv("dbDriver");
				String connectionURL = System.getenv("dbConnectionURL");
				String userName = System.getenv("dbUserName");
				String userPass = System.getenv("dbPassword");
				
				// String dbDriver = "com.mysql.jdbc.Driver";
				// String connectionURL = "jdbc:mysql://MySQL_Container:3306/prueba";
				// String userName = "root";
				// String userPass = "root";
				
				Class.forName(dbDriver).newInstance();
				dbConnection = DriverManager.getConnection(connectionURL, userName, userPass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dbConnection;
	}
}