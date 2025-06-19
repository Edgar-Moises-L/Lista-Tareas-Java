import dto.TareaDTO;
import org.springframework.web.client.HttpClientErrorException;
import services.TareasApi;


import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainApp {
    public static void main(String[] args) {

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




    }
}
