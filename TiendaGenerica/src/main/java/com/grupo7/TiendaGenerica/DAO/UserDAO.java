package com.grupo7.TiendaGenerica.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.grupo7.TiendaGenerica.DTO.UserDTO;

public class UserDAO {

	public ArrayList<UserDTO> userList() {
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement query = connection.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet result = query.executeQuery();
			while (result.next()) {
				UserDTO user = new UserDTO();
				user.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				user.setEmailUsuario(result.getString("email_usuario"));
				user.setNombreUsuario(result.getString("nombre_usuario"));
				user.setPassword(result.getString("password"));
				user.setUsuario(result.getString("usuario"));

				users.add(user);
			}
			result.close();
			query.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se pudo consultar el usuario \n" + e);
		}
		return users;
	}

	public boolean createUser(UserDTO user) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO usuarios VALUES ('" + user.getCedulaUsuario() + "', '"
					+ user.getEmailUsuario() + "', '" + user.getNombreUsuario() + "', '" + user.getPassword() + "', '"
					+ user.getUsuario() + "')");
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el usuario \n" + e);
		}
		return false;
	}

	public UserDTO getUser(int id) {
		MyConnection connection = new MyConnection();
		UserDTO user = new UserDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				user.setEmailUsuario(result.getString("email_usuario"));
				user.setNombreUsuario(result.getString("nombre_usuario"));
				user.setPassword(result.getString("password"));
				user.setUsuario(result.getString("usuario"));
			}
			result.close();
			statement.close();
			connection.disconect();

		} catch (Exception e) {
			System.out.println("No se pudo crear el usuario \n" + e);
		}
		return user;
	}

	public boolean update(int id, UserDTO user) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("UPDATE usuarios SET email_usuario =  '" + user.getEmailUsuario()
					+ "', nombre_usuario = '" + user.getNombreUsuario() + "', password = '" + user.getPassword()
					+ "', usuario = '" + user.getUsuario() + "' WHERE cedula_usuario = " + user.getCedulaUsuario());
			statement.close();
			connection.disconect();
			return true;

		} catch (Exception e) {
			System.out.println("No se pudo eliminar el usuario \n" + e);
		}
		return false;
	}

	public boolean delete(int id) {
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el usuario \n" + e);
		}
		return false;
	}

	public boolean auth(String userName, String password) {
		MyConnection connection = new MyConnection();
		UserDTO user = new UserDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? and password = ?");
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				user.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				user.setEmailUsuario(result.getString("email_usuario"));
				user.setNombreUsuario(result.getString("nombre_usuario"));
				user.setPassword(result.getString("password"));
				user.setUsuario(result.getString("usuario"));

			}
			result.close();
			statement.close();
			connection.disconect();
			if (user.getCedulaUsuario() != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("No se pudo autenticar el usuario \n" + e);
		}
		return false;
	}

}
