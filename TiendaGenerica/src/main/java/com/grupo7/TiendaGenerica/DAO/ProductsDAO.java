package com.grupo7.TiendaGenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo7.TiendaGenerica.DTO.ProductsDTO;

public class ProductsDAO {
	
	public ArrayList<ProductsDTO> prodList(){
		ArrayList<ProductsDTO> products = new ArrayList<ProductsDTO>();
		MyConnection connection = new MyConnection();
		try {
			PreparedStatement query = connection.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet result =query.executeQuery();
			while (result.next()) {
				ProductsDTO prod = new ProductsDTO();
				prod.setCodigo_producto(Integer.parseInt(result.getString("codigo_producto")));
				prod.setIva_compra(result.getFloat("iva"));
				prod.setNitproveedor(Integer.parseInt(result.getString("nit_proveedor")));
				prod.setNombre_producto(result.getString("nombre_producto"));
				prod.setPrecio_compra(result.getFloat("precio_compra"));
				prod.setPrecio_venta(result.getFloat("precio_venta"));
				
				products.add(prod);
				}
			result.close();
			query.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se encontro el producto \n" + e);
		}
		return products;
	}
	
	public boolean createProd(ProductsDTO pro) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO productos VALUES ('" + pro.getCodigo_producto() + "', '"
					+ pro.getIva_compra() + "', '" + pro.getNitproveedor() + "', '" + pro.getNombre_producto() + "', '"
					+ pro.getPrecio_compra() + "', '" + pro.getPrecio_venta() + "')");
			statement.close();
			connection.disconect();
			return true;
		} catch (Exception e) {
			System.out.println("No se pudo crear el producto \n" + e);
		}
		return false;
	}
	
	public ProductsDTO getProd(int codigo) {
		MyConnection connection = new MyConnection();
		ProductsDTO prod = new ProductsDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM productos WHERE codigo_producto = ?");
			statement.setInt(1, codigo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prod.setCodigo_producto(Integer.parseInt(result.getString("codigo_producto")));
				prod.setIva_compra(result.getFloat("iva"));
				prod.setNitproveedor(Integer.parseInt(result.getString("nit_proveedor")));
				prod.setNombre_producto(result.getString("nombre_producto"));
				prod.setPrecio_compra(result.getFloat("precio_compra"));
				prod.setPrecio_venta(result.getFloat("precio_venta"));
			}
			result.close();
			statement.close();
			connection.disconect();
		} catch (Exception e) {
			System.out.println("No se pudo cargar el producto \n" + e);
		}
		return prod;
	}
	
	public boolean updateProd(int codigo, ProductsDTO prod) {
		MyConnection connection = new MyConnection();
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("UPDATE productos SET iva =  '" + prod.getIva_compra()
					+ "', nit_proveedor = '" + prod.getNitproveedor() + "', nombre_producto = '" + prod.getNombre_producto() 
					+ "', precio_compra = '" + prod.getPrecio_compra() + "', precio_venta = '" + prod.getPrecio_compra() 
					+ "' WHERE codigo_producto = " + prod.getCodigo_producto());
			statement.close();
			connection.disconect();
			return true;
			
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el prodcuto \n" + e);
		}
		
		return false;
	}

	public boolean auth(String prodName, String codigo) {
		MyConnection connection = new MyConnection();
		ProductsDTO prod = new ProductsDTO();
		try {
			PreparedStatement statement = connection.getConnection()
					.prepareStatement("SELECT * FROM productos WHERE nombre_producto = ? and codigo_producto = ?");
			statement.setString(1, prodName);
			statement.setString(2, codigo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prod.setCodigo_producto(Integer.parseInt(result.getString("codigo")));
				prod.setIva_compra(result.getFloat("iva"));
				prod.setNitproveedor(Integer.parseInt(result.getString("nit_proveedor")));
				prod.setNombre_producto(result.getString("nombre"));
				prod.setPrecio_compra(result.getFloat("precio_compra"));
				prod.setPrecio_venta(result.getFloat("precio_venta"));

			}
			result.close();
			statement.close();
			connection.disconect();
			if (prod.getNitproveedor() != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("No se pudo autenticar el proveedor \n" + e);
		}
		return false;
	}

}


