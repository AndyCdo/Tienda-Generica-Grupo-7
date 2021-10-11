package File_CSV;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo7.TiendaGenerica.DTO.ProductsDTO;

@Repository
public interface CSV_Repositorio extends JpaRepository<ProductsDTO, Integer>{

}
