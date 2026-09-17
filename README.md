# API REST de Usuarios

API REST creada con Java, Spring Boot, Spring Web, Spring Data JPA y H2 en memoria. El proyecto implementa una arquitectura en capas para listar usuarios y consultar un usuario por su identificador.

## Tecnologias

- Java 21
- Spring Boot 3.5.6
- Spring Web
- Spring Data JPA
- H2 Database
- Maven Wrapper

## Estructura del proyecto

```text
src/main/java/com/ejemplo/usuarios/
├── UsuariosApplication.java
├── controller/
│   └── UsuarioController.java
├── service/
│   └── UsuarioService.java
├── repository/
│   └── UsuarioRepository.java
└── model/
    └── Usuario.java
```

## Modelo Usuario

La entidad `Usuario` contiene:

| Campo | Tipo | Restricciones |
|---|---|---|
| id | Long | Clave primaria, autoincremental |
| nombre | String | Obligatorio |
| email | String | Obligatorio y unico |
| edad | Integer | Obligatorio |

## Como ejecutar

1. Clona el repositorio y entra en su carpeta:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd demo
   ```

2. Ejecuta las pruebas:

   ```bash
   .\mvnw.cmd test
   ```

   En Linux o macOS:

   ```bash
   ./mvnw test
   ```

3. Inicia la aplicacion:

   ```bash
   .\mvnw.cmd spring-boot:run
   ```

4. La API quedara disponible en `http://localhost:8080`.

## Endpoints

### Listar usuarios

```http
GET http://localhost:8080/api/usuarios
```

Respuesta inicial:

```json
[
  {
    "id": 1,
    "nombre": "Ana Perez",
    "email": "ana@mail.com",
    "edad": 25
  },
  {
    "id": 2,
    "nombre": "Luis Gomez",
    "email": "luis@mail.com",
    "edad": 30
  },
  {
    "id": 3,
    "nombre": "Maria Ruiz",
    "email": "maria@mail.com",
    "edad": 28
  }
]
```

Puedes probarlo con `curl`:

```bash
curl http://localhost:8080/api/usuarios
```

### Consultar un usuario

```http
GET http://localhost:8080/api/usuarios/1
```

Este endpoint es el reto extra y devuelve el usuario con el identificador indicado.

Tambien se incluyen operaciones adicionales para crear, actualizar y eliminar usuarios:

- `POST /api/usuarios`
- `PUT /api/usuarios/{id}`
- `DELETE /api/usuarios/{id}`

## Base de datos H2

La aplicacion usa una base de datos H2 en memoria llamada `usuariosdb`. La consola esta disponible en:

```text
http://localhost:8080/h2-console
```

Datos de conexion para la consola:

```text
JDBC URL: jdbc:h2:mem:usuariosdb
User Name: sa
Password: (vacio)
```

Los tres usuarios iniciales se insertan desde `src/main/resources/data.sql` cada vez que inicia la aplicacion.

## Arquitectura por capas

1. `UsuarioController` recibe las peticiones HTTP y define las rutas REST.
2. `UsuarioService` contiene la logica de acceso a usuarios.
3. `UsuarioRepository` usa Spring Data JPA para consultar la base de datos.
4. `Usuario` representa la tabla `usuario` y sus restricciones.

## Evidencia de funcionamiento

La prueba `listaTresUsuariosIniciales` levanta el contexto completo, consulta `GET /api/usuarios` y verifica que la respuesta sea HTTP 200 y contenga los tres usuarios cargados desde `data.sql`.

Para generar una captura de funcionamiento:

1. Ejecuta la aplicacion con `mvn spring-boot:run`.
2. Abre `http://localhost:8080/api/usuarios` en el navegador o en Postman.
3. Guarda una captura donde se vea la respuesta JSON.

## Publicar en GitHub

Desde la carpeta del proyecto:

```bash
git init
git add .
git commit -m "Crear API REST de usuarios"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/usuarios-api.git
git push -u origin main
```

Despues de crear el repositorio publico, sustituye `<URL_DEL_REPOSITORIO>` por su URL real en este README.
