package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.CustomerDAO;
import com.grupo7.TiendaGenerica.DTO.CustomerDTO;

@RestController
public class CustomerControlller {
	
	@RequestMapping("/customer/create")
	public boolean create(int cedulaCliente, String direccionCliente, String emailCliente, String nombreCliente, String telefonoCliente) {
		CustomerDTO customer = new CustomerDTO();
		customer.setCedulaCliente(cedulaCliente);
		customer.setDireccionCliente(direccionCliente);
		customer.setEmailCliente(emailCliente);
		customer.setNombreCliente(nombreCliente);
		customer.setTelefonoCliente(telefonoCliente);
		CustomerDAO dao = new CustomerDAO();
		return dao.createCustomer(customer);
		
	}
	
	@RequestMapping("/customer/list")
	public ArrayList<CustomerDTO> list() {
		CustomerDAO dao = new CustomerDAO();
		return dao.customerList();
	}
	
	@RequestMapping("/customer/update")
	public boolean update(int cedulaCliente, String direccionCliente, String emailCliente, String nombreCliente, String telefonoCliente) {
		CustomerDTO customer = new CustomerDTO();
		customer.setCedulaCliente(cedulaCliente);
		customer.setDireccionCliente(direccionCliente);
		customer.setEmailCliente(emailCliente);
		customer.setNombreCliente(nombreCliente);
		customer.setTelefonoCliente(telefonoCliente);
		CustomerDAO dao = new CustomerDAO();
		return dao.update(cedulaCliente, customer);
	}
	
	@RequestMapping("/customer/delete")
	public boolean delete(int id) {
		CustomerDAO dao = new CustomerDAO();
		return dao.delete(id);
	}
	
	@RequestMapping("/customer/get")
	public CustomerDTO get(int id) {
		CustomerDAO dao = new CustomerDAO ();
		return dao.getCustomer(id);
	}
	
}
