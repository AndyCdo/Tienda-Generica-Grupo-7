package com.grupo7.TiendaGenerica.DTO;

import java.util.ArrayList;

public class SalesReportDTO {
	private Integer cedulaCliente;
	private String nombreCliente;
	private float totalVenta;
	public Integer getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(Integer cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public float getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}	
	
}