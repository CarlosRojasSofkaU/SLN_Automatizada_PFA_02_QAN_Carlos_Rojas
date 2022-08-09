# language: es

Característica:Mirar productos
  Yo como cliente en línea
  Deseo observar productos de la empresa
  Para mirar la descripción del producto y su precio

  Esquema del escenario: Observar un producto de manera exitosa.
    Dado que el cliente esta en la pagina de inicio
    Cuando El usuario quiere mirar cierto producto "<producto>"
    Entonces El usuario observa los detalles del producto "<producto>"

    Ejemplos:
      | producto      |
      | Backpack      |
      | Fleece Jacket |
      | Onesie        |