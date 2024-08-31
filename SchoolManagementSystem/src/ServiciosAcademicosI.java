public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws Exception;
    void agregarCurso(Curso curso) throws Exception;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Estudiante.EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws Estudiante.EstudianteNoInscritoEnCursoException;
}
