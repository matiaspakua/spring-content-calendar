# Content calendar example

Este es un proyecto de ejemplo del curso: Spring Boot Tutorial for Beginners - Crash Course using Spring Boot 3 de
Dan Vega.

Se trata de un proyecto de Java con Spring 3. En mi caso particular, voy a customizar algunas cosas y agregar
(al ambiente de desarrollo herramientas y otras cositas de modo de tener un ambiente más real).

El curso de Dan es: https://youtu.be/UgX5lgv4uVM?si=EJLyeWQqWaFQOfDT

El repositorio de github: https://github.com/danvega/content-calendar


## Setup inicial (configuración) de mi workstation

- SO Linux Mint version MATE
- Java v25 (recien salida del horno)
- Spring v3.5.7
- Maven 3.8.7
- IntelliJ Community Edition v2025

## Aspectos generales

1) el CHANGELOG se realizará usando los lineamientos de: https://keepachangelog.com/en/1.1.0/
2) el README siguiente algunas de las normas de: https://www.makeareadme.com/
3) la documentación de la API: usando swagger. SpringDoc OpenAPI Starter WebMVC UI
4) Pre-commit configurado a nivel SO y a nivel proyecto:

https://github.com/bekzod-murotboyev/git-hooks.git

```bash
sudo apt-get install pre-commit
```


## Actuator

Se agrega al proyecto la dependencia `spring-boot-starter-actuator` que es una librería muy útil en el ecosistema de Spring Boot que se utiliza para monitorizar y gestionar la aplicación en entornos de producción.

Básicamente, te proporciona una serie de "endpoints" (URLs) listos para usar que te dan información sobre el estado interno de la aplicación sin que tengas que programar nada extra.

Por ejemplo:

1. /actuator/health: Te dice si la aplicación está "UP" (funcionando) o "DOWN". Es muy usado por balanceadores de carga o sistemas como Kubernetes para saber si la aplicación está funcionando correctamente.
2. /actuator/info: Muestra información general de la aplicación (versión, descripción, etc., si la configuras).
3. /actuator/metrics: Expone métricas detalladas (uso de memoria, CPU, hilos, peticiones HTTP, etc.).
4. /actuator/loggers: Permite ver y cambiar el nivel de log (DEBUG, INFO, ERROR) en tiempo real sin reiniciar la aplicación.

En resumen, es como un panel de control para ver qué está pasando "bajo el capó" de la aplicación mientras se está ejecutando.



## API Rest Testing

Para el testing de las API rest utilizaré 2 herramientas:

1. En línea de comandos (termina): HTTPIe
2. GUI Bruno. La collection está en raiz del proyecto en la carpeta /http
3. Los request de Bruno además de tener el body, tienen la carpeta de /test donde se usa javascript para el testing.

Referencia: https://docs.usebruno.com/testing/tests/introduction

