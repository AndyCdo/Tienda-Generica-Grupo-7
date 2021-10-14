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
	
	@RequestMapping("/reports")
	public String reportsView()
	{
		return "reports";
		
	}	
	
	@RequestMapping("/reports/userslist")
	public String reportsusersView()
	{
		return "reports/userslist";
		
	}	
	
	@RequestMapping("/reports/saleslist")
	public String reportssalesView()
	{
		return "reports/saleslist";
		
	}
	
	@RequestMapping("/reports/customerslist")
	public String reportscustomersView()
	{
		return "reports/customerslist";
		
	}	
}
