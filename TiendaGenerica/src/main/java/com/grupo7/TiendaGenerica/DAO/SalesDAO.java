package com.grupo7.TiendaGenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo7.TiendaGenerica.DTO.DetailSaleDTO;
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
	
	public boolean createDetailSale(ArrayList<DetailSaleDTO> details, Integer codigoVenta) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			for (DetailSaleDTO detail : details){
			statement.executeUpdate("INSERT INTO detalle_ventas (cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valor_iva) VALUES ('" + detail.getCantidadProducto() + "', '"
					+ detail.getCodigoProducto() + "', '" + codigoVenta + "', '" + detail.getValorTotal() + "', '"
					+ detail.getValorVenta() + "', '" + detail.getValorIva() + "')");
			}
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el cliente \n" + e);
		}
		return false;
	}
	
	public Integer createSale(SalesDTO sales) {
		MyConnection connection = new MyConnection();
		try (
			PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO ventas (cedula_cliente, cedula_usuario, iva_venta, total_venta, valor_venta) VALUES ('"
					+ sales.getCedulaCliente() + "', '" + sales.getCedulaUsuario() + "', '" + sales.getIvaVenta() + "', '"
					+ sales.getTotalVenta() + "', '" + sales.getValorVenta() + "')", 
                    Statement.RETURN_GENERATED_KEYS);){
			int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Error creando la venta");
	        }
	        
	        Integer codigoVenta;
	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	codigoVenta = generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
	        statement.close();
			connection.disconect();
	        createDetailSale(sales.getDetailSale(), codigoVenta);
			
			return codigoVenta;
			
		} catch (Exception e) {
			System.out.println("No se pudo crear la Venta \n" + e);
		}
		return null;
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
