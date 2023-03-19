# Taller Servicios Rest

### Parte 1
##### Proceso para ejecutar el proyecto:

  - Tener maven instalado.
  - Descargar las carpetas de la parte 1 del repositorio.
  - Abrir 2 terminales y en cada una ubicarse en la carpeta donde esta el pom.xml
  - Ingresar el siguiente comando en cada una de las terminales: mvn clean install exec:java -D"exec"
  - Luego se empezará a ejecutar el servidor y el cliente.
 
 
### Parte 2
##### Proceso para ejecutar el proyecto:
  - Tener maven instalado.
  - Descargar las carpetas de la parte 2 del repositorio.
  - Abrir terminales y en cada una ubicarse en la carpeta donde esta el pom.xml de cada microservicio
  - Ingresar el siguiente comando en cada una de las terminales: mvn spring-boot:run -Dspring-boot.run.arguments=--server.port="numero del puerto"
  - Luego se empezará a ejecutar el servidor y el cliente.
  - En el navegador ingresar al link http://localhost:8888/calculadora/"operación"?a=2&b=4&user=Juan. 
  - Las operaciónes son: suma, multiplicar, resta, dividir
  - Para ver los registros de cada una de las opraciones ingresar al siguiente link http://localhost:8888/calculadora/"operación"/registros


### Link del video: https://drive.google.com/file/d/1fWNa1yC8_B7yRpYKCZWo08mvNdApKFiq/view?usp=sharing
