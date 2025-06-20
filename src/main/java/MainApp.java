import dto.TareaDTO;
import services.ErrorDeConexionException;
import services.RecursoNoEncontradoException;
import services.TareasApi;

import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
            try {
                    Date fecha = new Date();

                    TareaDTO tarea = new TareaDTO("m", "mandar a llamar un crud desde java", fecha, fecha, "pendiente", "alta");
                    TareasApi conexion = new TareasApi();


                    TareaDTO respuesta1 = conexion.addTarea(tarea);
                    System.out.println(respuesta1.toString());

                    TareaDTO respuesta2 = conexion.updateTarea(3L, tarea);
                    System.out.println(respuesta2.toString());

                    TareaDTO respuesta3 = conexion.getById(3L);
                    System.out.println(respuesta3.toString());

                    conexion.deleteTarea(3L);


                    List<TareaDTO> respuesta4 = conexion.getAllTareas();
                    for (TareaDTO tareas : respuesta4) {
                            System.out.println(tareas.toString());
                    }
            } catch (ErrorDeConexionException | RecursoNoEncontradoException e) {
                    System.err.println("Error funcional: " + e.getMessage());
            } catch (Exception e) {
                    System.err.println("Error inesperado: " + e.getMessage());
            }




}





    }

