package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.ProviderDAO;
import com.grupo7.TiendaGenerica.DTO.ProviderDTO;

@RestController
public class ProviderController {

	@RequestMapping("/provider/create")
	public boolean create(int nit, String proveedor, String ciudad, String direccion,
			String telefono) {
		ProviderDTO pro = new ProviderDTO();
		pro.setNit(nit);
		pro.setProveedor(proveedor);
		pro.setCiudad(ciudad);
		pro.setDireccion(direccion);
		pro.setTelefono(telefono);
		ProviderDAO dao = new ProviderDAO();
		return dao.createProv(pro);
	}

	@RequestMapping("/provider/list")
	public ArrayList<ProviderDTO> list() {
		ProviderDAO dao = new ProviderDAO();
		return dao.proList();
	}

	@RequestMapping("/provider/update")
	public boolean update(int nit, String proveedor, String ciudad, String direccion,
			String telefono) {
		ProviderDTO pro = new ProviderDTO();
		pro.setNit(nit);
		pro.setProveedor(proveedor);
		pro.setCiudad(ciudad);
		pro.setDireccion(direccion);
		pro.setTelefono(telefono);
		ProviderDAO dao = new ProviderDAO();
		return dao.update(nit, pro);
	}

	@RequestMapping("/provider/delete")
	public boolean delete(int id) {
		ProviderDAO dao = new ProviderDAO();
		return dao.delete(id);
	}

	@RequestMapping("/provider/get")
	public ProviderDTO get(int id) {
		ProviderDAO dao = new ProviderDAO();
		return dao.getPro(id);
	}


}
