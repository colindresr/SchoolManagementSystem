import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws Exception {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        } else {
            throw new Exception("El estudiante ya está matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) throws Exception {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        } else {
            throw new Exception("El curso ya está creado.");
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Estudiante.EstudianteYaInscritoException {
        if (!inscripciones.containsKey(idCurso)) {
            inscripciones.put(idCurso, new ArrayList<>());
        }
        ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(idCurso);
        if (estudiantesInscritos.contains(estudiante)) {
            throw new Estudiante.EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        estudiantesInscritos.add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws Estudiante.EstudianteNoInscritoEnCursoException {
        if (!inscripciones.containsKey(idCurso) || !inscripciones.get(idCurso).removeIf(e -> e.getId() == idEstudiante)) {
            throw new Estudiante.EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
    }
}