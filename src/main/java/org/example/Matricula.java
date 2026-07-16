package org.example;
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
        String[] historialMaterias = null;

        System.out.println("Bienvenid@ al sistema de matriculación PUCETEC");
        System.out.print("Ingrese el nombre y apellido del estudiante: ");
        nombreEstudiante = sc.nextLine();

        while (nombreEstudiante.trim().split(" ").length != 2) {
            System.out.print("Debe ingresar solo primer nombre y apellido del estudiante, ingrese nuevamente:");
            nombreEstudiante = sc.nextLine();
        }


        System.out.print("\n¿Es estudiante NUEVO o de REINGRESO? (N/R): ");
        String tipoEstudiante = sc.nextLine();

        while (!tipoEstudiante.equalsIgnoreCase("N") && !tipoEstudiante.equalsIgnoreCase("R")) {
            System.out.print("Opción inválida, debe ingresar N o R:");
            tipoEstudiante = sc.nextLine();
        }
        if (tipoEstudiante.equalsIgnoreCase("R")) {
            historialMaterias = new String[]{fundamentosProgramacion};
            System.out.println("Requisito para realizar matricula: Haber aprobado la materia seleccionada con una nota miníma de 7.0");
            System.out.println("Materia que desea tomar:" + fundamentosProgramacion);
            System.out.print("\n Ingrese la nota final obtenida en la materia de" + fundamentosProgramacion + "' (0-10): ");
            String inputNota = sc.nextLine();

            while (!inputNota.matches("\\d+(\\.\\d+)?")) {
                System.out.println("No se aceptan letras ni comas para representar números decimales..");
                System.out.print("Ingrese nuevamente la nota (0-10):");
                inputNota = sc.nextLine();
            }
            notaFinal = Double.parseDouble(inputNota);

        } else if (tipoEstudiante.equalsIgnoreCase("N")) {
            System.out.println("-> Registrando como estudiante de Primer Semestre...");
            System.out.println("Su proceso de matriculación se realizará en las instalaciones de la universidad.");
            System.exit(0);
        }

        System.out.print("¿Desea solicitar el cupo para esta materia? (Si/No): ");
        String solicitaCupo = sc.nextLine();

        if (solicitaCupo.equalsIgnoreCase("Si")) {
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
                        yield "MATRÍCULA APROBADA: Felicidades, cumple con el prerrequisito.";
                    } else {
                        yield "MATRÍCULA RECHAZADA: Reprobó la materia con " + notaFinal;
                    }
                }
                case "false" -> "MATRÍCULA RECHAZADA: No cuenta con el prerrequisito en su historial.";
                default -> "Error del sistema.";
            };

            System.out.print("\nResultado:" + resultadoMatricula);

        } else {
            System.out.println("\nProceso finalizado. No se solicitaron materias de segundo nivel.");
        }
        sc.close();
    }
}


