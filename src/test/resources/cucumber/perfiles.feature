# language: es
Característica: Servicio Perfiles (microservicio perfiles del caso caso02)
  Los escenarios validan el contrato REST del microservicio alineado a sus endpoints.

  Escenario: el listado del recurso responde 200
    Dado el servicio "Perfiles" está disponible
    Cuando consulto el listado de "perfiles"
    Entonces el listado responde con código 200

  Escenario: ciclo de vida completo del recurso
    Dado un nuevo "perfil" con nombre "hola-cucumber"
    Cuando consulto el "perfil" recién creado
    Entonces el recurso tiene nombre "hola-cucumber" y código 200
    Cuando actualizo el "perfil" con nombre "cucumber-actualizado"
    Entonces el recurso queda con nombre "cucumber-actualizado" y código 200
    Cuando elimino el "perfil"
    Entonces la eliminación responde con código 204
    Y al consultar el "perfil" eliminado responde 404
