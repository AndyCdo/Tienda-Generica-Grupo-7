package com.grupo7.TiendaGenerica.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.grupo7.TiendaGenerica.DTO.ProviderDTO;

public class ProviderDAO {

	public ArrayList<ProviderDTO> proList() {
		ArrayList<ProviderDTO> provider = new ArrayList<ProviderDTO>();
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement query = connection.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet result = query.executeQuery();
			while (result.next()) {
				ProviderDTO pro = new ProviderDTO();
				pro.setNit(Integer.parseInt(result.getString("nit_proveedor")));
				pro.setProveedor(result.getString("nombre_proveedor"));
				pro.setDireccion(result.getString("direccion_proveedor"));
				pro.setTelefono(result.getString("telefono_proveedor"));
				pro.setCiudad(result.getString("ciudad_proveedor"));

				provider.add(pro);
			}
			result.close();
			query.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se pudo consultar el proveedor \n" + e);
		}
		return provider;
	}

	public boolean createProv(ProviderDTO pro) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO proveedores VALUES ('" + pro.getNit() + "', '"
					+ pro.getProveedor() + "', '" + pro.getDireccion() + "', '" + pro.getTelefono() + "', '"
					+ pro.getCiudad() + "')");
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el proveedor \n" + e);
		}
		return false;
	}

	public ProviderDTO getPro(int id) {
		MyConnection connection = new MyConnection();
		ProviderDTO pro = new ProviderDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				pro.setNit(Integer.parseInt(result.getString("nit_proveedor")));
				pro.setProveedor(result.getString("nombre_proveedor"));
				pro.setDireccion(result.getString("direccion_proveedor"));
				pro.setTelefono(result.getString("telefono_proveedor"));
				pro.setCiudad(result.getString("ciudad_proveedor"));
			}
			result.close();
			statement.close();
			connection.disconect();

		} catch (Exception e) {
			System.out.println("No se pudo cargar el proveedor \n" + e);
		}
		return pro;
	}

	public boolean update(int id, ProviderDTO pro) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("UPDATE proveedores SET nit_proveedor =  '" + pro.getNit()
					+ "', nombre_proveedor = '" + pro.getProveedor() + "', direccion_proveedor = '" + pro.getDireccion()
					+ "', telefono_proveedor = '" + pro.getTelefono() + "' WHERE nit_proveedor = " + pro.getNit());
			statement.close();
			connection.disconect();
			return true;

		} catch (Exception e) {
			System.out.println("No se pudo actualizar el proveedor \n" + e);
		}
		return false;
	}

	public boolean delete(int id) {
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("DELETE FROM proveedores WHERE nit_proveedor = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el proveedor \n" + e);
		}
		return false;
	}

	}