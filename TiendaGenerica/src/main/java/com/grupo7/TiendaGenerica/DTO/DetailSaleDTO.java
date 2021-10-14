package com.grupo7.TiendaGenerica.DTO;

public class DetailSaleDTO {
	
	private Integer codigoDetalleVenta;
	private Integer cantidadProducto;
	private Integer codigoProducto;
	private Integer codigoVenta;
	private float valorTotal;
	private float valorVenta;
	public float getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(float valorVenta) {
		this.valorVenta = valorVenta;
	}
	private float valorIva;
	
	public Integer getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public Integer getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Integer getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Integer codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public float getValorIva() {
		return valorIva;
	}
	public void setValorIva(float valorIva) {
		this.valorIva = valorIva;
	}
	

}
