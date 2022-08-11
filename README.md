# Proceso de selección de analistas de calidad
# SLN_Automatizada_PFA_03_QAN_Carlos_Rojas
# Realizado por Carlos Fernando Rojas Cortés

En este proyecto se pretende realizar unas pruebas automatizadas para una tienda virtual, para evaluar conocimientos como:

* Uso de metodología BDD
* Uso de lenguaje DSL y herramientas como Gherkin para su manejo
* Uso de JUnit, cucumber y selenium para pruebas automatizadas
* Uso de gestores de log con log4j
* Uso de POM y Page Factory como patrones de diseño
* Uso de esperas explicitas o implicitas
* Buenas prácticas de programación en la contrucción del caso de negocio
* Uso de lenguaje descriptivo en terminos de negocio

Para esto se definen las siguientes secciones:
  1. [Configuración inicial](#configuración-inicial)
  2. [Requerimientos y herramientas](#requerimientos-y-herramientas)
  3. [Funcionalidades](#funcionalidades)
  4. [Evidencia de automatización](#evidencia-de-automatizacion)


## Configuración inicial

La rama donde se encuentran las pruebas automatizadas es **automation-sln-pfa-03-qan-carlos-rojas**

Para poder correr la prueba automatizada de la ruta crítica (comprar productos) se debe ubicar en la ruta del repositorio del proyecto (donde se encuentre la carpeta gradle), y ejecutar en una terminal el comando **./gradlew clean build test --tests \*ManejarCarritoDeComprasRunner\* aggregate -i**

En caso de que se quieran correr todas las pruebas automatizadas se debe correr el código **./gradlew clean build test aggregate -i**  (tener en cuenta que los escenarios de mirar redes sociales y el de mirar productos aún no están implementados)


## Requerimientos y Herramientas

| Herramienta	        | Versión														                                                                              | Descripción										                                                  |
|---------------------|----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| JavaFaker		         | 1.0.2														                                                                                | Usado para la estrategia de datos							                               |	
| JUnit		             | org.junit.jupiter:junit-jupiter-engine:5.8.2, org.junit.jupiter:junit-jupiter-api:5.8.2	           | Usado para el manejo de las pruebas						                              |			
| Patrón de  diseño   | 															                                                                                    | POM con Page Factory									                                          |
| Cucumber		          | io.cucumber:cucumber-junit:6.0.0', "io.cucumber:cucumber-core:6.6.0", 'io.cucumber:cucumber-java:6.0.0'								                             | Usado para el manejo del gherkin y de las características			           |			
| Selenium		          | 3.141.59														                                                                             | Usado para realizar las pruebas automatizadas					                     |		
| GitLab		            | 															                                                                                    | Sistema de control de versionamiento						                             |	
| IntelliJ		          | Versión 2022.1.1													                                                                      | IDE implementado para la construcción de codigo				                    |		
| JAVA JDK		          | Versión 13														                                                                           | Lenguaje de programación implementado						                            |
| Gradle		            | Versión 7.4.1													                                                                         | Gestor de dependencias implementado						                              |	
| Gherkin		           | 221.5591. 19													                                                                          | Usado para la implementación de BDD y el vínculo negocio - tech		      |		
| ChromeDriver	       | webdrivermanager (versión 104.0.5112.79 en el momento)						                                       | Navegador implementado para las pruebas						                          |
| Lombok		            | Versión 6.4.2													                                                                         | Usado para implementar métodos y constructores en tiempo de ejecución	 |
| Sistema operativo		 | Windows												                                                                                | Sistema operativo en el que se realizarán las pruebas	                 |
| Serenity		          | 'net.serenity-bdd:serenity-cucumber6:2.3.4', 'net.serenity-bdd:serenity-core:2.3.4', "net.serenity-bdd:serenity-gradle-plugin:2.0.80												 | Sistema operativo en el que se realizarán las pruebas	                 |


## Funcionalidades


1. Funcionalidad "Manejar carrito de compras"

En esta funcionalidad se probará el flujo de compra de uno o varios productos exitosa y la limpieza del carrito de compras exitosa

2. Funcionalidad "Registro"

En esta funcionalidad se evaluará el flujo de registro de una nueva cuenta en la plataforma exitoso

3. Funcionalidad "Contactanos"

En esta funcionalidad se evaluará el flujo de contactar servicio al cliente exitosamente

4. Funcionalidad "Conocer redes sociales"

En esta funcionalidad se evaluaran los flujos de conocer las redes sociales de facebook, twitter y youtube de la empresa

5. Funcionalidad "Mirar productos de la tienda"

En esta funcionalidad se evaluará el flujo de observar un producto de la aplicación correctamente


## Evidencia de la automatización


A continuación se presentaran las imagenes correspondientes a la prueba automatizada de la ruta crítica (compra de productos exitosa)

El usuario presiona el botón de inicio sesion
![paso 1](img/Screenshot_1.png)

El usuario llena el correo con el que se va a registrar
![paso 2](img/Screenshot_2.png)

El usuario llena el formulario de registro
![paso 3](img/Screenshot_3.png)

El usuario llena el formulario de registro
![paso 4](img/Screenshot_4.png)

El usuario llena el formulario de registro
![paso 5](img/Screenshot_5.png)

El usuario llena el formulario de registro
![paso 6](img/Screenshot_6.png)

El usuario presiona el botón de registro
![paso 7](img/Screenshot_7.png)

El usuario observa su nombre en pantalla
![paso 8](img/Screenshot_8.png)

El usuario navega a la sección de mujeres
![paso 9](img/Screenshot_9.png)

El usuario navega por los productos de mujeres
![paso 10](img/Screenshot_10.png)

El usuario compra una blusa
![paso 11](img/Screenshot_11.png)

El usuario compra un vestido
![paso 12](img/Screenshot_12.png)

el usuario compra una camiseta
![paso 13](img/Screenshot_13.png)

El usuario va al carrito
![paso 14](img/Screenshot_14.png)

El usuario verifica que los precios de los productos y su sumatoria sea correcta
![paso 15](img/Screenshot_15.png)

El usuario pasa a dirección de pedido
![paso 16](img/Screenshot_16.png)

El usuario pasa a envío
![paso 17](img/Screenshot_17.png)

El usuario acepta los terminos de servicio y pasa a pagos
![paso 18](img/Screenshot_18.png)

El usuario selecciona pagar con tarjeta
![paso 19](img/Screenshot_19.png)

El usuario verifica el precio total confirma el pago de los productos
![paso 20](img/Screenshot_20.png)

El usuario observa que su compra fue exitosa y verifica el precio pagado
![paso 21](img/Screenshot_21.png)


