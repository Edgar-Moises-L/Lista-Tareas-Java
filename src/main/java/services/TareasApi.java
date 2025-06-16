package services;

import dto.TareaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TareasApi implements ITareaApi {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8080/api/tareas";

    @Override
    public List<TareaDTO> getAllTareas() {
        ResponseEntity<List<TareaDTO>> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TareaDTO>>() {}
        );

        return response.getBody();
    }

    @Override
    public TareaDTO getById(Long id) {
        ResponseEntity<TareaDTO> response = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.GET,
                null,
                TareaDTO.class
        );
        return response.getBody();
    }

    @Override
    public TareaDTO addTarea(TareaDTO tarea) {
        HttpEntity<TareaDTO> request = new HttpEntity<>(tarea);
        ResponseEntity<TareaDTO> response = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                request,
                TareaDTO.class
        );
        return response.getBody();
    }

    @Override
    public TareaDTO updateTarea(Long id, TareaDTO tarea) {
        HttpEntity<TareaDTO> request = new HttpEntity<>(tarea);
        ResponseEntity<TareaDTO> response = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.PUT,
                request,
                TareaDTO.class
        );
        return response.getBody();
    }

    @Override
    public void deleteTarea(Long id) {
        ResponseEntity<TareaDTO> response = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.DELETE,
                null,
                TareaDTO.class
        );
    }
}


//@Service
//public class ProductoExchangeService {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private final String baseUrl = "http://localhost:8080/productos";
//
//    // CREATE
//    public ProductoDTO crear(ProductoDTO producto) {
//        HttpEntity<ProductoDTO> request = new HttpEntity<>(producto);
//        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
//                baseUrl, HttpMethod.POST, request, ProductoDTO.class);
//        return response.getBody();
//    }
//
//    // READ
//    public ProductoDTO buscar(id) {
//        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
//                baseUrl + "/" + id,
//                HttpMethod.GET,
//                null,
//                ProductoDTO.class);
//        return response.getBody();
//    }
//
//    // UPDATE
//    public ProductoDTO actualizar(Long id, ProductoDTO producto) {
//        HttpEntity<ProductoDTO> request = new HttpEntity<>(producto);
//        ResponseEntity<ProductoDTO> response = restTemplate.exchange(
//                baseUrl + "/" + id,
//                HttpMethod.PUT,
//                request,
//                ProductoDTO.class);
//        return response.getBody();
//    }
//
//    // REMOVE
//    public void eliminar(Long id) {
//        restTemplate.exchange(
//                baseUrl + "/" + id,
//                HttpMethod.DELETE,
//                null,
//                Void.class);
//    }
//}


//
//@Service
//public class ProductoPostForEntityService {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private final String baseUrl = "http://localhost:8080/productos";
//
//    // CREATE
//    public ProductoDTO crear(ProductoDTO producto) {
//        ResponseEntity<ProductoDTO> response = restTemplate.postForEntity(
//                baseUrl,
//                producto,
//                ProductoDTO.class);
//        return response.getBody();
//    }
//
//    // READ
//    public ProductoDTO buscar(Long id) {
//        return restTemplate.getForObject(baseUrl + "/" + id, ProductoDTO.class);
//    }
//
//    // UPDATE
//    public void actualizar(Long id, ProductoDTO producto) {
//        restTemplate.put(baseUrl + "/" + id, producto);
//    }
//
//    // REMOVE
//    public void eliminar(Long id) {
//        restTemplate.delete(baseUrl + "/" + id);
//    }
//}
//

