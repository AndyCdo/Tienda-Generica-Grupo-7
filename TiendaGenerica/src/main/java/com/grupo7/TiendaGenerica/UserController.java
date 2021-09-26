package com.grupo7.TiendaGenerica;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo7.TiendaGenerica.DAO.UserDAO;
import com.grupo7.TiendaGenerica.DTO.UserDTO;

@RestController
public class UserController {
	
	@RequestMapping("/users/create")
	public void create(UserDTO user) {
		UserDAO dao = new UserDAO();
		dao.createUser(user);
	}
	@RequestMapping("/users/list")
	public ArrayList <UserDTO> list(){
		UserDAO dao = new UserDAO();
		return dao.userList();
	}
	@RequestMapping("/users/update")
	public void update(int id, UserDTO user) {
		UserDAO dao = new UserDAO();
		dao.update(id, user);
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

