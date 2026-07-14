# 🚀 Taller Autónomo - Operación Código Legacy

**Integrantes:**
*Diana Llivipuma
*Sumak Jami

---

## Fase 1: Ingeniería Inversa y Documentación

### 1. ¿Qué problema resuelve esta aplicación?
Es un módulo de validación del proceso de matrícula de la carrera de Desarrollo de Software.

Su objetivo principal es determinar si un estudiante es apto o no para matricularse en la materia **Estructuras de Datos**, verificando que cumpla con los requisitos. Esto es obligatorio, ya que debe haber cursado y aprobado la materia de **Fundamentos de Programación** con una nota mínima de **7.0**.

### 2. Descripción del Flujo de Datos
El sistema opera mediante los siguientes pasos secuenciales:

1. **Ingreso de Datos Iniciales:**
   - Solicitar en nombre del estudiante ('usr')
   - Preguntar si el estudiante es de reingreso o arrastre ('S/N')
2. **Evaluación de Historial:**
   - **Si el estudiante es de reingreso ("S"):** El programa registra en su historial ('h_materias') la materia *Fundamentos de Programación* y solicita la nota final obtenida ('n1'), convirtiéndora a un valor numérico ('double').
   - **Si el estudiante es nuevo ("N"):** Se muestra un mensaje indicando que se registra como estudiante de Primer Semestre y no se asigna ninguna materia a su historial (`h_materias` permanece como `null`).
3. **Solicitud de Materia Destino:**
   - Muestra la materia a solicitar (*Estructuras de Datos*) y consulta si desea solicitar el cupo (`S/N`).
4. **Verificación de Prerrequisitos:**
   - Si el estudiante confirma ("S"), el sistema recorre su historial para buscar si ya cursó *Fundamentos de Programación*.
   - Mediante una estructura condicional ('swith'), valida la situación:
     - **Si cursó la materia:** Revisa la nota ('n1'). Si es igual o mayor a **7.0**, la matrícula es **Aprobada**. Si es menor, es rechazada por reprobar el prerrequisito.
     - **Si no cursó la materia:** La matrícula es rechazada por no contar con el prerrequisito en su historia.
5. **Salida:** Imprime en la consola el resultado final del proceso de matrícula.







 
