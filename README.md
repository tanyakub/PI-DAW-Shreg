# SHREG - Sistema de Gestión de Solicitudes para Huéspedes

## Descripción

SHREG es una aplicación web desarrollada para facilitar la gestión de solicitudes realizadas por los huéspedes de un hotel.

Los clientes pueden acceder mediante un código QR disponible en su habitación y realizar solicitudes de diferentes servicios. El personal de recepción puede consultar y gestionar dichas solicitudes desde un panel de administración.

## Tecnologías utilizadas

* Java 21
* Spring Boot
* HTML
* CSS
* MySQL
* Docker
* Docker Compose
* GitHub
* AWS EC2
* Nginx
* Let's Encrypt

## Requisitos

* Docker
* Docker Compose

## Ejecución del proyecto

Clonar el repositorio:

git clone URL_DEL_REPOSITORIO

Acceder al directorio del proyecto:

cd shreg

Iniciar los contenedores:

docker compose up -d

## Acceso a la aplicación

Una vez iniciados los contenedores, la aplicación estará disponible en:

https://shreg.yatat.es


## Estructura del proyecto

* `src/` → código fuente de la aplicación.
* `Dockerfile` → construcción de la imagen Docker.
* `docker-compose.yml` → despliegue conjunto de aplicación y base de datos.
* `pom.xml` → dependencias y configuración Maven.
* `.gitignore` → archivos excluidos del repositorio.

## Observaciones

El directorio `target/` no se encuentra incluido en el repositorio debido a que es generado automáticamente por Maven durante el proceso de compilación.

Esta carpeta contiene los archivos compilados de la aplicación, incluyendo el fichero `.jar` utilizado para el despliegue. Al tratarse de archivos generados, se encuentra incluida en el archivo `.gitignore` para evitar almacenar contenido redundante en el repositorio y reducir su tamaño.

Para generar nuevamente el contenido de esta carpeta basta con ejecutar:

mvn package

o utilizando Maven Wrapper:

./mvnw package

Tras la compilación se creará automáticamente el directorio `target/` con los archivos necesarios para la ejecución de la aplicación.

## Autor

Tetyana Yakubovych Semash

Proyecto desarrollado para el ciclo formativo de Desarrollo de Aplicaciones Web (DAW).

# PI-DAW-Shreg
Proyecto Intermodular - Aplicación Shreg 
