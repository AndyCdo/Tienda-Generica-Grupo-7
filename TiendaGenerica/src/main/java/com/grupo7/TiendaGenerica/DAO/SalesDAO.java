package com.grupo7.TiendaGenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.grupo7.TiendaGenerica.DTO.SalesDTO;

public class SalesDAO {
	public ArrayList<SalesDTO> saleList(){
		ArrayList<SalesDTO> sales = new ArrayList<SalesDTO>();
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement query = connection.getConnection().prepareStatement("SELECT * FROM ventas");
			ResultSet result =query.executeQuery();
			while (result.next()) {
				SalesDTO sale = new SalesDTO();
				sale.setCodigoVenta(Integer.parseInt(result.getString("codigo_venta")));				
				sale.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
				sale.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				sale.setIvaVenta(result.getFloat("iva_venta"));				
				sale.setTotalVenta(result.getFloat("total_venta"));
				sale.setValorVenta(result.getFloat("valor_venta"));
				
				sales.add(sale);
				}
			result.close();
			query.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se creo la venta \n" + e);
		}
		return sales;
	}
	public boolean createSale(SalesDTO sales) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO ventas VALUES ('" + sales.getCodigoVenta() + "', '"
					+ sales.getCedulaCliente() + "', '" + sales.getCedulaUsuario() + "', '" + sales.getIvaVenta() + "', '"
					+ sales.getTotalVenta() + "', '" + sales.getValorVenta() + "')");
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el Venta \n" + e);
		}
		return false;
	}
	public SalesDTO getSales(int id) {
		MyConnection connection = new MyConnection();
		SalesDTO sale = new SalesDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM ventas WHERE codigo_venta = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				sale.setCodigoVenta(Integer.parseInt(result.getString("codigo_venta")));				
				sale.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
				sale.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				sale.setIvaVenta(result.getFloat("iva_venta"));				
				sale.setTotalVenta(result.getFloat("total_venta"));
				sale.setValorVenta(result.getFloat("valor_venta"));
			}
			result.close();
			statement.close();
			connection.disconect();

		} catch (Exception e) {
			System.out.println("No se pudo encontrar la venta \n" + e);
		}
		return sale;
	}
	
}
