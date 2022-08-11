# language: es
Característica: Manejar carrito de compras
  Como cliente en linea
  Deseo administrar mi carrito de compras
  Para poder realizar la compra de productos de la tienda.

  Antecedentes:
    Dado que el cliente se haya registrado o logueado en la plataforma

  @RutaCritica
  Esquema del escenario: Solicitud de compra de producto exitosa.
    Cuando el cliente quiere comprar uno o varios productos "<productos>" y realiza todas las funciones de verificacion
    Entonces el cliente observara el precio de la orden de sus productos.

    Ejemplos:
      | productos                                          |
      | Blouse                                             |
      | Blouse, Faded Short Sleeve T-shirts                |
      | Blouse, Printed Dress, Faded Short Sleeve T-shirts |

  Esquema del escenario: Limpiar productos del carrito de compras.
    Dado el cliente selecciono uno o varios productos "<productos>" de la pagina
    Cuando el cliente quiere eliminar sus productos "<productos>" del carrito de compras
    Entonces el cliente observara que el carrito de compras esta vacio.

    Ejemplos:
      | productos                                          |
      | Blouse                                             |
      | Blouse, Faded Short Sleeve T-shirts                |
      | Blouse, Printed Dress, Faded Short Sleeve T-shirts |