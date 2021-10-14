package com.grupo7.TiendaGenerica.DTO;

import java.util.ArrayList;

public class SalesDTO {
	private Integer codigoVenta;
	private Integer cedulaCliente;
	private Integer cedulaUsuario;
	private float ivaVenta;
	private float totalVenta;
	private ArrayList <DetailSaleDTO> detailSale;
	
	public ArrayList<DetailSaleDTO> getDetailSale() {
		return detailSale;
	}
	public void setDetailSale(ArrayList<DetailSaleDTO> detailSale) {
		this.detailSale = detailSale;
	}
	public Integer getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Integer codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public Integer getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(Integer cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public Integer getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(Integer cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public float getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(float ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public float getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}
	public float getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(float valorVenta) {
		this.valorVenta = valorVenta;
	}
	private float valorVenta;
	
}