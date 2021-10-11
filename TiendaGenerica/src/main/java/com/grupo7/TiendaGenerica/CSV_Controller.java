package com.grupo7.TiendaGenerica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo7.TiendaGenerica.DTO.ProductsDTO;

import File_CSV.CSVProducts;
import File_CSV.CSV_Menssage;
import File_CSV.CSV_Service;

 
@Controller 
@RequestMapping 
public class CSV_Controller {
	
	@Autowired
	  CSV_Service fileService;
	
	@GetMapping("/archivoCSV")
	
	@PostMapping("/upload") //Post Request
	  public ResponseEntity<CSV_Menssage> uploadFile(@RequestParam("file") MultipartFile file) {
		  
		  String message = "";
		    System.out.println("entre a cargar");
		    if (CSVProducts.hasCSVFormat(file)) {
		    	System.out.println("Es un CSV");
		      try {		    	
		        fileService.save(file);
		        System.out.println("Se cargo");
		        message = "Carga exitosa: " + file.getOriginalFilename();
		        
		        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/download/")
		                .path(file.getOriginalFilename())
		                .toUriString();
		        System.out.println("Mensaje antes del return");
		        return ResponseEntity.status(HttpStatus.OK).body(new CSV_Menssage(message,fileDownloadUri));
		      } catch (Exception e) {
		    	  System.out.println("No se pudo cargar");
		        message = "No se pudo cargar: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CSV_Menssage(message,""));
		      }
		    }

		    System.out.println("Mensaje Es otro formatooo");
		    message = "Por favor carge un CSV!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CSV_Menssage(message,""));
		  }

	  @GetMapping("/products")  //GET request
	  public ResponseEntity<List<ProductsDTO>> obtenerProductos() {
		  
		  try {
		      List<ProductsDTO> productos = fileService.getAllProductos();

		      if (productos.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	  
	
	  @GetMapping("/download/{fileName:.+}")
	  public ResponseEntity<Resource> archivo(@PathVariable String fileName) {
		  
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
}
