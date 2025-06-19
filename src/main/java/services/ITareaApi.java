package services;

import dto.TareaDTO;

import java.util.List;

public interface ITareaApi {
    List<TareaDTO> getAllTareas();

    TareaDTO getById(Long id);

    TareaDTO addTarea(TareaDTO tarea);

    TareaDTO updateTarea(Long id, TareaDTO tarea);

    void deleteTarea(Long id);
}
