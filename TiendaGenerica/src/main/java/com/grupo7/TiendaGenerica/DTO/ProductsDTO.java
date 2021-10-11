package com.grupo7.TiendaGenerica.DTO;

public class ProductsDTO {
	
	private Integer codigo_producto;
	private float iva_compra;
	private Integer nitproveedor;
	private String nombre_producto;
	private float precio_compra;
	private float precio_venta;
	public Integer getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public float getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(float iva_compra) {
		this.iva_compra = iva_compra;
	}
	public Integer getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public float getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}
	public float getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	

}
