package services;

import dto.TareaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TareasApi implements ITareaApi {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8080/api/tareas";


    @Override
    public List<TareaDTO> getAllTareas() {
        try {
            ResponseEntity<List<TareaDTO>> response = restTemplate.exchange(
                    URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<TareaDTO>>() {
                    }
            );
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RecursoNoEncontradoException("Error:", e);
        } catch (Exception e) {
            throw new ErrorDeConexionException("Error al obtener tareas.", e);
        }

    }

    @Override
    public TareaDTO getById(Long id) {
        try {
            ResponseEntity<TareaDTO> response = restTemplate.exchange(
                    URL + "/" + id,
                    HttpMethod.GET,
                    null,
                    TareaDTO.class
            );
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RecursoNoEncontradoException("Error:", e);
        } catch (Exception e) {
            throw new ErrorDeConexionException("Error al obtener la tarea comn id " + id, e);
        }

    }

    @Override
    public TareaDTO addTarea(TareaDTO tarea) {
        try {
            HttpEntity<TareaDTO> request = new HttpEntity<>(tarea);
            ResponseEntity<TareaDTO> response = restTemplate.exchange(
                    URL,
                    HttpMethod.POST,
                    request,
                    TareaDTO.class
            );
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RecursoNoEncontradoException("Error:", e);
        } catch (Exception e) {
            throw new ErrorDeConexionException("Error al agregar la tarea.", e);
        }

    }

    @Override
    public TareaDTO updateTarea(Long id, TareaDTO tarea) {
        try {
            HttpEntity<TareaDTO> request = new HttpEntity<>(tarea);
            ResponseEntity<TareaDTO> response = restTemplate.exchange(
                    URL + "/" + id,
                    HttpMethod.PUT,
                    request,
                    TareaDTO.class
            );
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RecursoNoEncontradoException("Error:", e);
        } catch (Exception e) {
            throw new ErrorDeConexionException("Error al modificar la tarea con id " + id, e);
        }
    }

    @Override
    public void deleteTarea(Long id) {
        try {
            restTemplate.exchange(
                    URL + "/" + id,
                    HttpMethod.DELETE,
                    null,
                    Void.class
            );
        } catch (HttpClientErrorException.NotFound e) {
            throw new RecursoNoEncontradoException("Error:", e);
        } catch (Exception e) {
            throw new ErrorDeConexionException("Error al eliminar la tarea con id " + id, e);
        }

    }
}





