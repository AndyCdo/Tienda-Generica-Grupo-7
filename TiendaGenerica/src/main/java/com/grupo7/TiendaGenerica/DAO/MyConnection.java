package com.grupo7.TiendaGenerica.DAO;

import java.sql.*;

public class MyConnection {

	static String bd = "tienda_generica_grupo7";
	static String login = "grupo7";
	static String password = "AdminGrupo7";
	static String url = "jdbc:mariadb://tiendagenericagrupo7.c47knbsonjdi.us-east-2.rds.amazonaws.com:3306/" + bd;

	Connection connection = null;

	public MyConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexion a base de datos " + bd + " ok\n");
			} else {
				System.out.println("No se pudo conectar a la base de datos");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void disconect() {
		connection = null;
	}

}
