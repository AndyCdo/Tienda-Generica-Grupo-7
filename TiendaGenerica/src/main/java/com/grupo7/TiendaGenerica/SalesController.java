package com.grupo7.TiendaGenerica;


import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.SalesDAO;
import com.grupo7.TiendaGenerica.DTO.SalesDTO;

@RestController
public class SalesController {
	
	@RequestMapping(
	        value = "/sales/create",
	        method = RequestMethod.POST,
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Integer create(@RequestBody SalesDTO sale) {
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
