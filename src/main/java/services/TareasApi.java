package services;

import dto.TareaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
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
                new ParameterizedTypeReference<List<TareaDTO>>() {
                }
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
        restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.DELETE,
                null,
                Void.class
        );

    }
}





