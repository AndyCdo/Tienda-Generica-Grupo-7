package com.grupo7.TiendaGenerica.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.grupo7.TiendaGenerica.DTO.CustomerDTO;

public class CustomerDAO {
	
	public ArrayList<CustomerDTO> customerList() {
		ArrayList<CustomerDTO> customer = new ArrayList<CustomerDTO>();
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement query = connection.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet result = query.executeQuery();
			while (result.next()) {
				CustomerDTO cus = new CustomerDTO();
				cus.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
				cus.setDireccionCliente(result.getString("direccion_cliente"));
				cus.setEmailCliente(result.getString("email_cliente"));
				cus.setNombreCliente(result.getString("nombre_cliente"));
				cus.setTelefonoCliente(result.getString("telefono_cliente"));
										
				customer.add(cus);
			}
			result.close();
			query.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se pudo consultar el cliente \n" + e);
		}
		return customer;
	}
	
	public boolean createCustomer(CustomerDTO customer) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO clientes VALUES ('" + customer.getCedulaCliente() + "', '"	+ customer.getDireccionCliente() + "', '" + customer.getEmailCliente() + "', '" + customer.getNombreCliente() + "', '" + customer.getTelefonoCliente()+ "')");
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el cliente \n" + e);
		}
		return false;
	}
	
	public CustomerDTO getCustomer(int id) {
		MyConnection connection = new MyConnection();
		CustomerDTO customer = new CustomerDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				customer.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
				customer.setDireccionCliente(result.getString("direccion_cliente"));
				customer.setEmailCliente(result.getString("email_cliente"));
				customer.setNombreCliente(result.getString("nombre_cliente"));
				customer.setTelefonoCliente(result.getString("telefono_cliente"));
			}
			result.close();
			statement.close();
			connection.disconect();

		} catch (Exception e) {
			System.out.println("No se pudo crear el cliente \n" + e);
		}
		return customer;
	}
	
	public boolean update(int id, CustomerDTO customer) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("UPDATE clientes SET email_cliente =  '" + customer.getEmailCliente()
					+ "', direccion_cliente ='" + customer.getDireccionCliente() + "', nombre_cliente = '" + customer.getNombreCliente()
					+ "', telefono_cliente ='" + customer.getTelefonoCliente() +"' WHERE cedula_cliente = " + customer.getCedulaCliente());
			statement.close();
			connection.disconect();
			return true;

		} catch (Exception e) {
			System.out.println("No se pudo actualizar el cliente \n" + e);
		}
		return false;
	}
	
	public boolean delete(int id) {
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("DELETE FROM clientes WHERE cedula_cliente = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el cliente \n" + e);
		}
		return false;
	}
	
}
