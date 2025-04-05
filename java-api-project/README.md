# README.md

# Proyecto API de Clientes

Este proyecto es una API desarrollada en Java utilizando Spring Boot. Su objetivo es gestionar la información de los clientes, permitiendo realizar consultas sobre sus datos.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **src/main/java/com/example/ApiApplication.java**: Punto de entrada de la aplicación. Contiene el método `main` que inicia la aplicación Spring Boot.
  
- **src/main/java/com/example/controller/ClientController.java**: Controlador que maneja las solicitudes HTTP relacionadas con los clientes. Incluye métodos para consultar datos de clientes específicos.
  
- **src/main/java/com/example/model/Client.java**: Modelo de datos que representa a un cliente. Contiene propiedades como `id`, `nombre` y `correo electrónico`, junto con sus métodos getter y setter.
  
- **src/main/java/com/example/service/ClientService.java**: Servicio que contiene la lógica de negocio para manejar los datos de los clientes. Incluye métodos para buscar clientes por su ID.
  
- **src/main/resources/application.properties**: Archivo de configuración de la aplicación. Define propiedades como el puerto del servidor y la configuración de la base de datos.
  
- **src/main/resources/templates/client.html**: Plantilla HTML utilizada para mostrar la información del cliente en el navegador.

## Requisitos

- Java 11 o superior
- Maven

## Instalación

1. Clona el repositorio:
   ```
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Navega al directorio del proyecto:
   ```
   cd java-api-project
   ```

3. Compila el proyecto:
   ```
   mvn clean install
   ```

4. Ejecuta la aplicación:
   ```
   mvn spring-boot:run
   ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes realizar solicitudes HTTP a los endpoints definidos en el `ClientController` para consultar la información de los clientes.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.