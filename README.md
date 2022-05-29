# Tasky

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/9a79748fff724d02ba69da88b2af47a1)](https://www.codacy.com/gh/wjfatuan/tasky-backend/dashboard?utm_source=github.com&utm_medium=referral&utm_content=wjfatuan/tasky-backend&utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/9a79748fff724d02ba69da88b2af47a1)](https://www.codacy.com/gh/wjfatuan/tasky-backend/dashboard?utm_source=github.com&utm_medium=referral&utm_content=wjfatuan/tasky-backend&utm_campaign=Badge_Coverage)

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

Backend (API REST) del proyecto Tasky del curso de Construcción de software. Esta aplicación está construida con Spring Boot y pernmita la interacción con las funcionalidades principales del API de Tasky: creación de tareas, registro de usuarios, oraganización de tareas y consulta de datos.

- [Requisitos](#requisitos)
- [Como contribuir a este proyecto](#como-contribuir-a-este-repositorio)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Compilar y ejecutar la aplicación](#compilar-y-ejecutar-su-aplicación)
- [Verificar la calidad del código](#verificar-la-calidad-del-código)

## Requisitos

Debe tener instaladas las siguientes herramientas:

- [Visual Studio Code](https://code.visualstudio.com/) (u otro editor de su preferencia)
- Java Development Kit 11
- Gradle
- [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)

## Como contribuir a este repositorio

Una vez tenga asignada una tarea del proyecto en Trello, puede contribuir a este repositorio siguiendo estos pasos:

1. Cree un [fork](https://docs.github.com/en/get-started/quickstart/fork-a-repo) de este repositorio en Github, esto dejará una copia en su cuenta de Github.

2. Clone su fork localmente.

   - Vaya a Github y navegue al fork de este repositorio.
   - Copie el link HTTPS a su fork.
   - Abra una terminal.
   - Cambiese al directorio de trabajo donde quiere dejar la copia del repositorio.
   - Escriba `git clone` y pegue la URL copiada anteriormente, por ejemplo:

     ```git
     git clone https://github.com/YOUR-USERNAME/tasky-backend
     ```

   - Presione enter, esto creara la copia local del repositorio

3. Haga los cambios requeridos en la tarea y subalos usando el ciclo normal de Git (`git add`, `git commit`, y `git push`)

   - En cada commit asegurese de poner un comentario adecuado para el cambio, incluyendo el número de su tarea. Por ejemplo:

     ```git
     git commit -m "Tarea U03: Se modifica la entidad XXXX agregando el campo YYYY"
     ```

   - Revise el ejemplo `Dummy` si tiene dudas sobre como implementar el API.

4. Haga una solicitud de cambios (también conocido como Pull Resuqet o PR) al repositorio principal. En este punto los cambios que hizo deben estar funcionando localmente.

   - Vaya a Github y navegue hasta el fork creado anteriormente.
   - Debería ver allí sus cambios.
   - De clic en **Contribuir** y luego en **Abrir solicitud de cambios**.
   - Allí verá las diferencias enre el repositorio destino y sus cambios.
   - Asegurese qde que no haya conflictos, de haber conflictos solucionelos y suba las correcciones.
   - Finalmente de clic en **Crear solicitud de cambios**.

5. Notifique la solicitud de cambios por el chat del grupo y pida que alguién los revise. Recuerde que la revisión hace parte de su calificación, así que ayude a sus compañeros revisando también sus solicitudes de cambios y aprobando cuando este satisfecho con el código.

> **Nota**: Asegurese, antes de iniciar su trabajo, de actualizar su copia local con el repositorio remoto. De esta manera puede aevitar posibles conflictos de código con sus compañeros. Recuerde que la comunicación es clave, use el chat del grupo para validar posibles conflictos o cambios en el código. Es posible que alguién haya creado o deba crear clases que usted necesita.

## Estructura del proyecto

La siguiente tabla muestra la estructura de carpetas/paquetes del proyecto. **Asegurese de poner su código en la carpeta correcta**. Si duranta euna revisión de código encuentra que sus compañero cometio un error pongalo como comentario en su revisión de código.

| Carpeta                                                | Descripción                                                               |
| ------------------------------------------------------ | ------------------------------------------------------------------------- |
| `src/main`                                             | Código fuente de la aplicación                                            |
| `src/test`                                             | Código fuente de las pruebas                                              |
| `src/main/java/co/edu/uan/software/tasky`              | Paquete principal de la aplicación                                        |
| `src/main/java/co/edu/uan/software/tasky/entities`     | Pauqete de entidades: Ponga acá las clases de entidad del proyecto        |
| `src/main/java/co/edu/uan/software/tasky/controllers`  | Paquete de controladores: Ponga acá los controladores del proyecto        |
| `src/main/java/co/edu/uan/software/tasky/repositories` | Paquete de repositorios: Ponga acá las clases de repositorio del proyecto |

## Compilar y ejecutar su aplicación

Para probar de forma local su aplicación siga los siguientes pasos:

1. Asegurese de que su código no contiene errores.

2. Modifique su archivo .env con los siguientes datos:

   ```bash
   SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
   SPRING_DATASOURCE_USERNAME=username
   SPRING_DATASOURCE_PASSWORD=password
   SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
   LIQUIBASE_ENABLED=false
   ```

3. Desde la terminal ejecute el siguiente comando para verificar que las pruebas funcionan:

   ```bash
   ./gradlew build
   ```

4. Desde la terminal ejecute el siguiente comando para inciar el servidor de forma local:

   - Con Heroku:

   ```bash
   heroku local
   ```

   - Con Spring Boot (asegurese de poner las variables de ambiente del archivo `.env` en su sistema):

   ```bash
   ./gradlew bootRun
   ```

5. Ahora puede consumir el API usando su herramienta favorita. Se recomienda usar `curl` o **[Postman](https://www.postman.com/)**.

   - Por ejemplo, para consultar los dummy usando el API dummy de ejemplo, puede usar:

   ```bash
   curl -X GET http://localhost:5000/dummies
   ```

   - para crear una nueva tarea puede usar:

   ```bash
   curl --location --request POST 'http://localhost:5000/task' \
     --header 'Content-Type: application/json' \
     --data-raw '{
        "descripcion": "Lorem ipsum dolor",
        "userId": null,
        "taskListId": null,
        "usuario": {
           "uid": "8f474bf6-4d1b-42da-bf21-65bd76e04e60"
        }
     }'
   ```

   - o también puede usar:

   ```bash
   curl --location --request POST \
     'http://localhost:5000/usuarios/8f474bf6-42da-bf21-65bd76e04e60/tasks'\
     --header 'Content-Type: application/json' \
     --data-raw '{
        "descripcion": "User task",
        "userId": null,
        "taskListId": null
     }'
   ```

## Verificar la calidad del código

Puede verificar distintos atributos de calidad del código fuente del proyecto:

- Google Java Code Style: Puede verificar el cumplimiento de estos estándares:

  1. Ejecute el siguiente comando para generar el reporte de checkstyle:

     ```bash
     ./gradlew check
     ```

  2. Abra el reporte desde la carpeta `build/reports/checkstyle`.

- Cobertura de pruebas:

  1. Ejecute el siguiente comando para generar el reporte de pruebas:

     ```bash
     ./gradlew test
     ```

  2. Abra los reportes de pruebas desde la carpeta `build/reports/tests` y `build/reports/jacoco`.
