package File_CSV;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.grupo7.TiendaGenerica.DTO.ProductsDTO;


public class CSVProducts {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "codigo_producto", "iva_compra", "nitproveedor", "nombre_producto", "precio_compra","precio_venta"};

  public static boolean hasCSVFormat(MultipartFile file) {
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<ProductsDTO> csvproductsTG7(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<ProductsDTO> productsList = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  ProductsDTO products = new ProductsDTO(
    			  
              Integer.parseInt(csvRecord.get("codigo_producto")),
              Float.parseFloat(csvRecord.get("iva_compra")),
              Integer.parseInt(csvRecord.get("nitproveedor")),
              csvRecord.get("nombre_producto"),
              Float.parseFloat(csvRecord.get("precio_compra")),
              Float.parseFloat(csvRecord.get("precio_venta"))
             );

    	  productsList.add(products);
      }

      return productsList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream CSV(List<ProductsDTO> productsList) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (ProductsDTO products : productsList) {
        List<String> data = Arrays.asList(
              String.valueOf(products.getCodigo_producto()),
              String.valueOf(products.getIva_compra()),
              String.valueOf(products.getNitproveedor()),
              products.getNombre_producto(),
              String.valueOf(products.getPrecio_compra()),
              String.valueOf(products.getPrecio_venta())
             );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
