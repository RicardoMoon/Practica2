package Main;

import java.util.ArrayList;

/**
 * Created by Adolfo on 3/6/2017.
 */
public class Estudiantes {
    private static Estudiantes ourInstance = new Estudiantes();
    public static Estudiantes getInstance() {
        return ourInstance;
    }
    private ArrayList<Estudiante> student;

    private Estudiantes() {
        student = new ArrayList<Estudiante>();
    }

    public void regEstudiante(Estudiante estudiante){
        getStudent().add(estudiante);
    }

    public ArrayList<Estudiante> getStudent() {
        return student;
    }

    public Estudiante getEstudianteMatricula(int matricula) {
        Estudiante estudiante = null;
        for (Estudiante aux: student) {
            if(aux.getMatricula() == matricula){
                estudiante = aux;
            }
        }

        return estudiante;
    }

    public void modifEstudiante(int matricula, Estudiante estudiante) {
        int i = 0;

        for (Estudiante aux: student) {
            if(aux.getMatricula() == matricula){
                aux.setApellido(estudiante.getApellido());
                aux.setMatricula(estudiante.getMatricula());
                aux.setNombre(estudiante.getNombre());
                aux.setTelefono(estudiante.getTelefono());
            }
        }
    }
}
