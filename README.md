# Proyecto de Cliente y Servidor con API de Spotify

¡Hola! Soy Víctor Medina, y este es mi proyecto de cliente y servidor en Java que interactúa con la API de Spotify. Este proyecto ha sido desarrollado como parte de [nombre del curso, trabajo, interés personal, etc.].

## Descripción

Este proyecto incluye un cliente que se conecta a la API de Spotify para realizar diversas operaciones y un servidor que maneja las solicitudes del cliente. El proyecto está estructurado de la siguiente manera:

- `src/main/java/es/ulpgc/client`: Contiene la lógica principal del cliente, incluidas las clases para la interoperabilidad con Spotify, utilidades y serialización.
- `src/main/java/es/ulpgc/client/server`: Contiene la lógica del servidor.

## Estructura del Proyecto
src/
├── main/
│ ├── java/
│ │ └── es/
│ │ └── ulpgc/
│ │ └── client/
│ │ ├── cqrs/
│ │ ├── interoperability/
│ │ ├── serialization/
│ │ ├── server/
│ │ ├── util/
│ │ └── Main.java
│ └── resources/
└── test/


## Requisitos

- Java 11 o superior

## Configuración

1. Clona el repositorio en tu máquina local:
    ```sh
    git clone https://github.com/tu-usuario/tu-repositorio.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd tu-repositorio
    ```
3. Compila el proyecto usando Maven o Gradle (según tu configuración):
    ```sh
    mvn clean install
    ```
4. Configura las credenciales de la API de Spotify en el archivo de configuración correspondiente:
    ```properties
    # Archivo de configuración (por ejemplo, src/main/resources/application.properties)
    spotify.clientId=TU_CLIENT_ID
    spotify.clientSecret=TU_CLIENT_SECRET
    ```

## Uso

Para ejecutar el cliente y el servidor, usa el siguiente comando:
  sh
java -cp target/tu-proyecto.jar es.ulpgc.client.Main


## Contribución

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realiza tus cambios y commitea (git commit -am 'Añadir nueva funcionalidad').
Sube tus cambios (git push origin feature/nueva-funcionalidad).
Abre un Pull Request.
Licencia

Este proyecto está licenciado bajo la Licencia MIT - mira el archivo LICENSE para más detalles.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme a través de victormedina2157@gmail.com o abrir un issue en GitHub.

¡Gracias por visitar mi proyecto!

