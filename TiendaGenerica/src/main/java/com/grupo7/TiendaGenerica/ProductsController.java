package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.ProductsDAO;
import com.grupo7.TiendaGenerica.DTO.ProductsDTO;

@RestController
public class ProductsController {
	
	@RequestMapping("/products/create")
	public boolean create(int codigo, float iva_compra, int nit_proveedor, 
			String nombre, float precio_compra, float precio_venta) {
		ProductsDTO prod = new ProductsDTO();
		prod.setCodigo_producto(codigo);
		prod.setIva_compra(iva_compra);
		prod.setNitproveedor(nit_proveedor);
		prod.setNombre_producto(nombre);
		prod.setPrecio_compra(precio_compra);
		prod.setPrecio_venta(precio_venta);
		ProductsDAO dao = new ProductsDAO();
		return dao.createProd(prod);
	}
	
	@RequestMapping("/products/list")
	public ArrayList<ProductsDTO> list() {
		ProductsDAO dao = new ProductsDAO();
		return dao.prodList();
	}
	
	@RequestMapping("/products/update")
	public boolean update(int codigo, float iva_compra, int nit_proveedor, 
			String nombre, float precio_compra, float precio_venta) {
		ProductsDTO prod = new ProductsDTO();
		prod.setCodigo_producto(codigo);
		prod.setIva_compra(iva_compra);
		prod.setNitproveedor(nit_proveedor);
		prod.setNombre_producto(nombre);
		prod.setPrecio_compra(precio_compra);
		prod.setPrecio_venta(precio_venta);
		ProductsDAO dao = new ProductsDAO();
		return dao.updateProd(codigo, prod);
	}

	@RequestMapping("/products/get")
	public ProductsDTO get(int codigo) {
		ProductsDAO dao = new ProductsDAO();
		return dao.getProd(codigo);
	}

	@RequestMapping("/products/auth")
	public boolean auth(String prodName, String nit) {
		ProductsDAO dao = new ProductsDAO();
		return dao.auth(prodName, nit);
	}
}
