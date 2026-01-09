# demo - Spring Boot sample project

Proyecto Spring Boot generado con Spring Initializr. Incluye un ejemplo mínimo con entidad `Persona`, repositorio y controlador REST.

Cómo ejecutar:

Windows (PowerShell):

```powershell
cd demo
./gradlew bootRun
```

La aplicación arranca en `http://localhost:8080`.

Ejemplos de uso:

- Obtener personas: `GET /personas`
- Crear persona: `POST /personas` con body JSON `{ "nombre": "Juan", "email": "juan@example.com" }`

Configurar la base de datos MySQL editando `src/main/resources/application.properties`.
