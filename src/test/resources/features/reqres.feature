Feature: API de ReqRes

  Scenario: Listar usuarios de ReqRes
    Given David consulta la API de usuarios
    Then David debe recibir codigo 200
    And David debe recibir usuarios

  Scenario: Crear usuario en ReqRes
    Given David crea un usuario con nombre "David" y trabajo "QA Automation"
    Then David debe recibir codigo 201
    And David debe validar que el nombre sea "David"
    And David debe validar que el trabajo sea "QA Automation"

  Scenario: Actualizar usuario en ReqRes
    Given David actualiza el usuario con nombre "David Actualizado" y trabajo "Senior QA Automation"
    Then David debe recibir codigo 200
    And David debe validar que el nombre sea "David Actualizado"
    And David debe validar que el trabajo sea "Senior QA Automation"

