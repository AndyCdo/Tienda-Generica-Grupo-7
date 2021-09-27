package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.UserDAO;
import com.grupo7.TiendaGenerica.DTO.UserDTO;

@RestController
public class UserController {

	@RequestMapping("/users/create")
	public boolean create(int cedulaUsuario, String emailUsuario, String nombreUsuario, String password,
			String usuario) {
		UserDTO user = new UserDTO();
		user.setCedulaUsuario(cedulaUsuario);
		user.setEmailUsuario(emailUsuario);
		user.setNombreUsuario(nombreUsuario);
		user.setPassword(password);
		user.setUsuario(usuario);
		UserDAO dao = new UserDAO();
		return dao.createUser(user);
	}

	@RequestMapping("/users/list")
	public ArrayList<UserDTO> list() {
		UserDAO dao = new UserDAO();
		return dao.userList();
	}

	@RequestMapping("/users/update")
	public boolean update(int cedulaUsuario, String emailUsuario, String nombreUsuario, String password,
			String usuario) {
		UserDTO user = new UserDTO();
		user.setCedulaUsuario(cedulaUsuario);
		user.setEmailUsuario(emailUsuario);
		user.setNombreUsuario(nombreUsuario);
		user.setPassword(password);
		user.setUsuario(usuario);
		UserDAO dao = new UserDAO();
		return dao.update(cedulaUsuario, user);
	}

	@RequestMapping("/users/delete")
	public boolean delete(int id) {
		UserDAO dao = new UserDAO();
		return dao.delete(id);
	}

	@RequestMapping("/users/get")
	public UserDTO get(int id) {
		UserDAO dao = new UserDAO();
		return dao.getUser(id);
	}

	@RequestMapping("/users/auth")
	public boolean auth(String userName, String password) {
		UserDAO dao = new UserDAO();
		return dao.auth(userName, password);
	}

}
