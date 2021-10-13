package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;


import com.grupo7.TiendaGenerica.DAO.SalesDAO;
import com.grupo7.TiendaGenerica.DTO.SalesDTO;

public class SalesController {
	
	@RequestMapping("/sales/confirmar")
	public boolean create(int codigoVenta, int cedulaCliente, int cedulaUsuario, 
			float ivaVenta, float totalVenta, float valorVenta) {
		SalesDTO sale = new SalesDTO();
		sale.setCodigoVenta(codigoVenta);
		sale.setCedulaCliente(cedulaCliente);
		sale.setCedulaUsuario(cedulaUsuario);
		sale.setIvaVenta(ivaVenta);
		sale.setTotalVenta(totalVenta);
		sale.setValorVenta(valorVenta);
		SalesDAO dao = new SalesDAO();
		return dao.createSale(sale);
	}
	
	@RequestMapping("/sales/list")
	public ArrayList<SalesDTO> list() {
		SalesDAO dao = new SalesDAO();
		return dao.saleList();
	}
	

	

	@RequestMapping("/sales/get")
	public SalesDTO get(int codigo) {
		SalesDAO dao = new SalesDAO();
		return dao.getSales(codigo);
	}

}
