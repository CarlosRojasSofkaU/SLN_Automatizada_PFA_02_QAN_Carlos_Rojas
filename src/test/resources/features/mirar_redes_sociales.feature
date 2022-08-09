# language: es

Característica:Conocer redes sociales
  Yo como cliente en línea
  Deseo conocer las redes sociales de la empresa
  Para observar que han compartido

  Esquema del escenario: Conocer una red social exitosamente
    Dado que el cliente esta en la página de inicio
    Cuando El usuario clickea en la red social "<redSocial>" de la empresa
    Entonces Se muestra la página de la red social "<redSocial>"

    Ejemplos:
      | redSocial |
      | Facebook  |
      | Twitter   |
      | Linkedin  |