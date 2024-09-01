import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            GestorAcademico gestor = new GestorAcademico();

            // Crear estudiantes
            Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", LocalDate.of(2000, 1, 1), "matriculado");
            Estudiante estudiante2 = new Estudiante(2, "Maria", "Lopez", LocalDate.of(2001, 2, 2), "matriculado");

            // Crear cursos
            Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 4, "v1");
            Curso curso2 = new Curso(2, "Programación", "Curso de introducción a la programación", 3, "v1");

            // Matricular estudiantes
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Agregar cursos
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());

            // Desinscribir estudiante de un curso
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());

            System.out.println("Todos los procesos se ejecutaron correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
