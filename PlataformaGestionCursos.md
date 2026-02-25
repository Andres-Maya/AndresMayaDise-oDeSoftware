### Plataforma Digital de Gestión de Cursos Universitarios

## ACTIVIDAD 1 — Identificación de Objetos
### 1️. ¿Qué objetos existen en el sistema?
- Estudiante
- Curso
- Docente
- Inscripción
- Pago
- Calificación
- Usuario
- Administrador

### 2. Objetos principales
Son los que representan el núcleo del sistema:

| Objeto | Descripción |
|--------|-------------|
| Estudiante | Persona que se registra y se inscribe en cursos |
| Curso	Unidad | académica que puede ser gestionada |
| Inscripción	| Relación entre estudiante y curso |
| Pago | Transacción económica por matrícula |
| Calificación | Nota obtenida en un curso |

### 3️. Objetos de apoyo

| Objeto | Descripción |
|--------|-------------|
| Usuario | Clase base para autenticación |
| Docente | Profesor asignado a un curso |
| Administrador | Gestiona cursos |
| Plataforma | Control general del sistema |

## ACTIVIDAD 2 — Diseño de Clases
 
<img width="681" height="1071" alt="Diagrama de clases" src="https://github.com/user-attachments/assets/96b1fd20-1c83-4daf-a206-03b13724440a" />

## ACTIVIDAD 3 — Aplicación de POO
### Encapsulamiento
Se aplicó haciendo los atributos privados y permitiendo acceso mediante métodos getters y setters.
Ejemplo:
- nota en la clase Calificacion no puede modificarse directamente.
- Se usa modificarNota() para validar que esté entre 0 y 5.
Esto protege la integridad de los datos.

### Herencia
La clase Usuario es la clase padre.
Hereda a:
- Estudiante
- Docente
- Administrador
Esto evita repetir atributos como nombre, correo y contraseña.

### Abstracción
El sistema abstrae el concepto real de:
- Matrícula
- Pago
- Curso universitario
El usuario no ve cómo se procesa internamente un pago, solo usa procesarPago().

### Polimorfismo
Ejemplo:
El método iniciarSesion() puede comportarse distinto según:
- Estudiante → Redirige a panel académico
- Docente → Redirige a panel de cursos
- Administrador → Redirige a gestión completa
Mismo método, diferente comportamiento.

## ACTIVIDAD 4 — Relaciones entre Clases

**Se encuentra en el diagrama de arriba**

## ACTIVIDAD 5 — Análisis de Diseño

### 1️. ¿Qué clase es más importante?
Inscripcion, porque conecta estudiantes con cursos.
Sin ella, el sistema no tiene sentido funcional.

### 2️. ¿Cuál cambiaría más si el sistema crece?
Pago, porque podrían agregarse:
- Nuevos métodos de pago
- Descuentos
- Becas
- Pasarelas externas
- Facturación electrónica
  
### 3️. ¿Qué parte podría reutilizarse en otra app?
La clase Usuario y el sistema de autenticación.
Podría reutilizarse en:
- Plataforma de eventos
- Sistema hospitalario
- App empresarial

## RETO OPCIONAL — Mejora del Diseño

### Posibles errores
- Pago está muy acoplado a Estudiante.
- Curso maneja lista de inscritos directamente.
- Falta una clase ServicioPago o PasarelaPago.

### Refactorización Propuesta
1.	Crear clase abstracta MetodoPago.
2.	Crear subclases:
   - PagoTarjeta
   - PagoTransferencia
   - PagoEfectivo
3. Aplicar patrón Strategy para el pago.

### Justificación
- Reduce acoplamiento.
- Facilita agregar nuevos métodos.
- Mejora escalabilidad.
- Cumple principio SOLID (Open/Closed).

### Conclusión General
El diseño propuesto aplica correctamente:
- Encapsulamiento
- Herencia
- Abstracción
- Polimorfismo
Además, mantiene coherencia estructural y posibilidad de crecimiento
