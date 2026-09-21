# QA Automation Challenge - Serenity BDD & Screenplay

Proyecto de automatización de pruebas Web y API desarrollado utilizando **Java, Serenity BDD, Screenplay, Selenium WebDriver, Cucumber y Serenity REST**.

El proyecto automatiza escenarios sobre la página oficial de Selenium y servicios API de ReqRes.

---

## Tecnologías utilizadas

- Java 17
- Maven
- Serenity BDD 5.3.8
- Serenity Screenplay
- Serenity Screenplay WebDriver
- Serenity Screenplay REST
- Selenium WebDriver
- Cucumber 7.34.2
- JUnit 6
- Chrome / ChromeDriver
- ReqRes API

---

## Casos automatizados

El proyecto contiene **6 escenarios automatizados**.

### Pruebas Web - Selenium

#### 1. Validar página principal de Selenium

Verifica que la página principal de Selenium se encuentre disponible y que el título esperado sea mostrado.

#### 2. Navegar a Documentation

Verifica la navegación desde la página principal de Selenium hacia la sección **Documentation**.

#### 3. Validar el flujo de búsqueda

- Abre el buscador de Selenium.
- Busca el término `webdriver`.
- Selecciona el primer resultado.
- Valida que el título de la página corresponda a **WebDriver**.

### Pruebas API - ReqRes

#### 4. Listar usuarios

- Consulta la API de usuarios.
- Valida el código de respuesta `200`.
- Verifica que la respuesta contenga usuarios.

#### 5. Crear usuario

- Realiza una petición para crear un usuario.
- Valida el código de respuesta `201`.
- Valida el nombre del usuario.
- Valida el trabajo del usuario.

#### 6. Actualizar usuario

- Realiza una petición para actualizar un usuario.
- Valida el código de respuesta `200`.
- Valida el nombre actualizado.
- Valida el trabajo actualizado.

---

## Estructura del proyecto

```text
src
└── test
    ├── java
    │   └── starter
    │       ├── navigation
    │       ├── questions
    │       ├── stepdefinitions
    │       ├── tasks
    │       ├── ui
    │       └── CucumberTestSuite.java
    │
    └── resources
        ├── features
        │   ├── reqres.feature
        │   └── web.feature
        │
        ├── junit-platform.properties
        └── serenity.conf

pom.xml
serenity.properties
.gitignore
README.md

### Configuración de ReqRes

Antes de ejecutar las pruebas, configurar la variable de entorno:

```powershell
$env:REQRES_API_KEY="TU_API_KEY"