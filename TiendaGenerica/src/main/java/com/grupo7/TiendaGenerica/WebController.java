package com.grupo7.TiendaGenerica;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")
	public String indexView()
	{
		return "index";
	}
	
	@RequestMapping("/users")
	public String usersView()
	{
		return "users";
		
	}
	
	@RequestMapping("/providers")
	public String providerView()
	{
		return "prov";		
	}	
	
	@RequestMapping("/customers")
	public String customerView()
	{
		return "customer";
		
	}

	@RequestMapping("/products")
	public String productView()
	{
		return "products";
		
	}


	@RequestMapping("/sales")
	public String salesView()
	{
		return "sales";
		
	}		
}
