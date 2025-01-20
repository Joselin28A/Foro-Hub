# ForoHub - Backend

Este repositorio contiene el backend de la aplicación **ForoHub**, una plataforma de discusión en línea desarrollada con Spring Boot. A continuación, se detallan las configuraciones y las instrucciones para ejecutar el proyecto.

## Configuración del Proyecto

### Archivo de Configuración (`application.properties`)

El archivo `application.properties` contiene las configuraciones necesarias para el funcionamiento de la aplicación. A continuación, se describen las principales propiedades:

- **Nombre de la Aplicación:**
  ```properties
  spring.application.name=forohub
  ```

- **Configuración de la Base de Datos:**
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/forohub?createDatabaseIfNotExist=true
  spring.datasource.username= {DB: USER} (indicar usuario de la base de datos)
  spring.datasource.password= {DB:PASSWORD} (indicar contraseña de la base de datos)
  ```

- **Configuración de JPA y Hibernate:**
  ```properties
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.hibernate.ddl-auto=update
  ```

- **Configuración de Errores:**
  ```properties
  server.error.include-stacktrace=never
  ```

- **Configuración de Logging:**
  ```properties
  logging.level.org.springframework=DEBUG
  logging.level.org.hibernate=DEBUG
  logging.level.com.zaxxer.hikari=DEBUG
  ```

- **Configuración de Seguridad (JWT):**
  ```properties
  api.security.secret=${JWT_SECRET:123123} (Se recomienda cambiar el número secreto)
  ```

### Requisitos Previos

- **Java JDK 11 o superior**
- **MySQL Server** (o cualquier base de datos compatible con JDBC)
- **Maven** (para la gestión de dependencias)

### Instalación y Ejecución

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/forohub-backend.git
   cd forohub-backend
   ```

2. **Configurar la Base de Datos:**
   - Asegúrate de que MySQL esté instalado y en ejecución.
   - Crea una base de datos llamada `forohub` o asegúrate de que la aplicación pueda crearla automáticamente con la opción `createDatabaseIfNotExist=true`.

3. **Configurar las Variables de Entorno:**
   - Si deseas utilizar un secreto JWT diferente al predeterminado (`123123`), puedes configurar la variable de entorno `JWT_SECRET` antes de ejecutar la aplicación:
     ```bash
     export JWT_SECRET=tu_secreto_jwt
     ```

4. **Compilar y Ejecutar la Aplicación:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Acceder a la Aplicación:**
   - La aplicación estará disponible en `http://localhost:8080`.


### Dependencias Principales

- **Spring Boot**: Framework principal para la construcción de la aplicación.
- **Spring Data JPA**: Para la persistencia de datos.
- **Spring Security**: Para la autenticación y autorización.
- **HikariCP**: Para la gestión de conexiones a la base de datos.
- **MySQL Connector**: Conector JDBC para MySQL.
- **JWT**: Para la generación y validación de tokens JWT.
- **Lombok**: Para reducir el boilerplate del código (getters, setters, etc.).
- **Flyway**: Para la gestión de migraciones de la base de datos.
- **Springdoc OpenAPI**: Para la documentación interactiva de la API.

### Pasos para Acceder a la Documentación con Springdoc

1. **Configuración Automática:** Springdoc se configura automáticamente si agregas la dependencia a tu `pom.xml`.

   ```xml
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-ui</artifactId>
       <version>1.7.0</version>
   </dependency>
   ```

2. **Acceso a la Documentación:**
   - Una vez que la aplicación esté en ejecución, accede a la documentación interactiva en:
     ```
     http://localhost:8080/swagger-ui.html
     ```


