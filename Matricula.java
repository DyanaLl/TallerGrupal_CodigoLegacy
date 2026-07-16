import java.util.Scanner;

public class Matricula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
        ===========================================
        |   SISTEMA DE MATRÍCULA - PUCE TEC       |
        |      Carrera de Desarrollo de Software  |
        ===========================================
        """);

        String nombreEstudiante = "";
        String fundamentosProgramacion = "Fundamentos de Programación";
        double notaFinal = 0.0;

        System.out.print("Ingrese el nombre del estudiante: ");
        nombreEstudiante = sc.nextLine();

        System.out.print("¿Es estudiante de reingreso o arrastre? (S/N): ");
        String tipoEstudiante = sc.nextLine();

        String[] historialMaterias = null;

        if (tipoEstudiante.equalsIgnoreCase("S")) {
            historialMaterias = new String[]{ fundamentosProgramacion };
            System.out.print("Ingrese la nota final obtenida en '" + fundamentosProgramacion + "' (0-10): ");
            String inputNota = sc.nextLine();
            notaFinal = Double.parseDouble(inputNota);
        } else {
            System.out.println("-> Registrando como estudiante de Primer Semestre...");
        }

        System.out.println("\n--- MATERIA A SOLICITAR ---");
        System.out.println("Materia destino: [ Estructuras de Datos ] (Requisito: Haber aprobado Fundamentos con >= 7.0)");
        System.out.print("¿Desea solicitar el cupo para esta materia? (S/N): ");
        String solicitaCupo = sc.nextLine();

        if (solicitaCupo.equalsIgnoreCase("S")) {
            boolean cumplePrerrequisito = false;

            if (historialMaterias != null) {
                for (int i = 0; i < historialMaterias.length; i++) {
                    if (historialMaterias[i].equals(fundamentosProgramacion)) {
                        cumplePrerrequisito = true;
                    }
                }
            }

            String resultadoMatricula = switch (String.valueOf(cumplePrerrequisito)) {
                case "true" -> {
                    if (notaFinal >= 7.0) {
                        yield "MATRÍCULA APROBADA: Cumple con el prerrequisito.";
                    } else {
                        yield "MATRÍCULA RECHAZADA: Reprobó el prerrequisito con " + notaFinal;
                    }
                }
                case "false" -> "MATRÍCULA RECHAZADA: No cuenta con el prerrequisito en su historial.";
                default -> "Error del sistema.";
            };

            System.out.println("\n[RESULTADO]: " + resultadoMatricula);

        } else {
            System.out.println("\nProceso finalizado. No se solicitaron materias de segundo nivel.");
        }

        sc.close();
    }
}
