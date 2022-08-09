# language: es
Característica: Administrar carrito de compras
  Como cliente en linea
  Deseo administrar mi carrito de compras
  Para poder realizar la compra de productos de la tienda.

  Antecedentes:
    Dado que el cliente se haya registrado o logueado en la plataforma

  Esquema del escenario: Solicitud de compra de producto exitosa.
    Cuando el cliente quiere comprar uno o varios productos "<productos>" y realiza todas las funciones de verificación
    Entonces el cliente observará un mensaje de solicitud de compra exitosa y un precio de orden de sus productos.

    Ejemplos:
      | productos              |
      | Blouse                 |
      | Blouse, Blouse         |
      | Blouse, Blouse, Blouse |

  Escenario: Limpiar productos del carrito de compras.
    Dado el cliente seleccionó uno o varios productos "<products>" de la página
    Cuando el cliente quiere eliminar sus productos "<products>" del carrito de compras
    Entonces el cliente observará que el carrito de compras esta vacio.