package com.grupo7.TiendaGenerica.File_CSV;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grupo7.TiendaGenerica.DTO.ProductsDTO;

public class CSV_Service {
  
  CSV_Repositorio repository;

  public void save(MultipartFile file) {
    try {
      List<ProductsDTO> productos = CSVProducts.csvproductsTG7(file.getInputStream());
      repository.saveAll(productos);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<ProductsDTO> productos = repository.findAll();

    ByteArrayInputStream in = CSVProducts.CSV(productos);
    return in;
  }

  public List<ProductsDTO> getAllProductos() {
    return repository.findAll();
  }

}