package Main;


import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Adolfo on 3/6/2017.
 */
public class Main {

    public static void main(String[] args) {

        FreeMarkerEngine freemarker = configurar();
        Estudiantes.getInstance().getStudent().add(new Estudiante(20131196,"Ricardo","Luna","8097790299"));
        Estudiantes.getInstance().getStudent().add(new Estudiante(20130867,"Leny","Luna","8095552222"));
        Estudiantes.getInstance().getStudent().add(new Estudiante(20130260,"Anderson","Carrasco","8090001111"));


        get("/", ((request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Listado de Estudiantes");
            if(Estudiantes.getInstance().getStudent().isEmpty() == true){
                attributes.put("empty", 0);
            }
            else{
                ArrayList<Estudiante> students = Estudiantes.getInstance().getStudent();
                attributes.put("empty", 1);
                attributes.put("list", students);
            }
            return new ModelAndView(attributes, "listaEstudiantes");
        }), freemarker);

        get("/crearEstudiante", ((request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Crear Estudiante");
            return new ModelAndView(attributes, "crearEstudiante.ftl");
        }), freemarker);

        post("/confirmarEstudiante", ((request, response) -> {
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            int matricula = Integer.parseInt(request.queryParams("matricula"));

            Estudiante student= new Estudiante(matricula,nombre,apellido,telefono);
            Estudiantes.getInstance().regEstudiante(student);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Estudiante Registrado");
            attributes.put("student", student);

            return new ModelAndView(attributes, "infoEstudiante.ftl");
        }), freemarker);

        get("/eliminarEstudiante/:matricula", ((request, response)->{

            int matricula = Integer.parseInt(request.params("matricula"));
            Estudiante estudiante = Estudiantes.getInstance().getEstudianteMatricula(matricula);
            Estudiantes.getInstance().getStudent().remove(estudiante);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Estudiante Eliminado");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "elimEstudiante.ftl");
        }), freemarker);

        get("/editarEstudiante/:matricula", ((request, response)->{

            int matricula = Integer.parseInt(request.params("matricula"));
            Estudiante estudiante = Estudiantes.getInstance().getEstudianteMatricula(matricula);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Estudiante Eliminado");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "editarEstudiante.ftl");
        }), freemarker);

        post("/estudianteModificado/:matriculaOld", ((request, response) -> {
            int matriculaURL = Integer.parseInt(request.params("matriculaOld"));

            Estudiante newEstudiante = new Estudiante(Integer.parseInt(request.queryParams("matricula")),request.queryParams("nombre"),request.queryParams("apellido"),request.queryParams("telefono"));
            Estudiantes.getInstance().modifEstudiante(matriculaURL, newEstudiante);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Estudiante Modificado");
            attributes.put("student", newEstudiante);

            return new ModelAndView(attributes, "infoEstudiante.ftl");
        }), freemarker);
    }

    private static FreeMarkerEngine configurar(){
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        return freeMarkerEngine;
    }
}


