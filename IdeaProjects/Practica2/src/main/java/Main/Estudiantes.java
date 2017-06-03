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
        student.add(estudiante);
    }
}
