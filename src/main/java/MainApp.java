import dto.TareaDTO;
import services.TareasApi;


import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Date fecha = new Date();

        TareaDTO tarea = new TareaDTO("Tarea desde java", "mandar a llamar un crud desde java", fecha, fecha, "En Proseso", "urgente");
        TareasApi conexion = new TareasApi();

//        TareaDTO respuesta = conexion.addTarea(tarea);
//        System.out.println(respuesta.toString());
//
//        TareaDTO respuesta = conexion.updateTarea( 2L, tarea);
//        System.out.println(respuesta.toString());
//
//        TareaDTO respuesta = conexion.getById(2L);
//        System.out.println(respuesta.toString());
//
//        conexion.deleteTarea(2L);
//
//        List<TareaDTO> respuesta = conexion.getAllTareas();
//        for(TareaDTO tareas :respuesta){
//                System.out.println(tareas.toString());
//        }

    }
}
