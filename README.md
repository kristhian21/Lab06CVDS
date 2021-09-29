## Lab05 CVDS    

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP

- **Abra una terminal Linux o consola de comandos Windows.**
**Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:**
**Host: www.escuelaing.edu.co**
**Puerto: 80**
**Teniendo en cuenta los parámetros del comando telnet: telnet HOST PORT**

- **Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.**
**Asegúrese de presionar ENTER dos veces después de ingresar el comando.**

- **Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.**

<img src="img/responseTelnet.png" alt="telnet" width = "400px">

- **¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?**

<img src="img/mensajes2.png" alt="mensajes" width = "400px">
<img src="img/mensajes1.png" alt="mensajes" width = "400px">

- **Realice una nueva conexión con telnet, esta vez a:**
  Host: www.httpbin.org
  Puerto: 80
  Versión HTTP: 1.1
  Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

  <img src="img/httpbin1.png" alt="httpbin" width = "400px">
  <img src="img/httpbin.png" alt="httpbin" width = "400px">

- **Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con la opción -c para contar el número de caracteres:** <br> wc -c <br>
  **Pegue el contenido del portapapeles con CTRL-SHIFT-V y presione CTRL-D (fin de archivo de Linux). Si no termina el comando wc presione CTRL-D de nuevo. No presione mas de dos veces CTRL-D indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de caracteres que tiene el contenido HTML que respondió el servidor.**

  <img src="img/conteo1.png" alt="conteo">
  <img src="img/conteo2.png" alt="conteo">
  <img src="img/conteo3.png" alt="conteo">

  

- **Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?**

  **GET** se encarga de llevar los datos de forma "visible" (cualquiera puede verlos) al cliente por medio de la URL.

  **POST** trata con datos "ocultos" (el cliente no puede verlos) enviados por un formulario.

  **HEAD** solicita una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.

  **PUT** reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.

  **DELETE** borra un recurso en específico.

  **CONNECT** establece un túnel hacia el servidor identificado por el recurso.

  **OPTIONS** para describir las opciones de comunicación para el recurso de destino.

  **TRACE** realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.

  **PATCH** utilizado para aplicar modificaciones parciales a un recurso.

- **En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:** <br> curl www.httpbin.org <br>
  <img src="img/curl1.png" alt="curl">
  <img src="img/curl2.png" alt="curl">
- **Utilice ahora el parámetro -v y con el parámetro -i:** <br> curl -v www.httpbin.org <br>
  <img src="img/curl-v.png" alt="curl">
- **curl -i** www.httpbin.org <br>
  <img src="img/curl-i.png" alt="curl">


- **¿Cuáles son las diferencias con los diferentes parámetros?** <br> El parametro -i sirve para incluir el encabezado del protocolo en el outout
<br> El parametro -v sirve para que curl se vuelva más "explicativo" y adicione informacion de pruebas y señale estas con el prefijo "*"

### PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

- **Revise la clase SampleServlet incluida a continuacion, e identifique qué hace** <br> Sirve como un controlador que por el momento solo tiene un método GET

- **Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins).** <br> Está configurado para funcionar por el puerto 8080

- **mvn package**  
<img src="img/mvnPackage.png" alt="mvnPackage">
- **mvn tomcat7:run**
<img src="img/tomcatRun.png" alt="mvnPackage">

- **Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.**
<img src="img/helloServlet.png" alt="helloS">

- **Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).**
<img src="img/hellomajo.png" alt="Get">

- **En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.**
<img src="img/json1.png" alt="helloS">
<img src="img/json4.png" alt="helloS">

- **Una vez hecho esto, verifique el funcionamiento de la aplicación, recompile y ejecute la aplicación.**
**Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades**

<img src="img/idNumber.png" alt="idNumb">

<img src="img/xd.png" alt="stringReq">

<img src="img/noArg.png" alt="noArg">

<img src="img/negativo.png" alt="negativeArg">

- **Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el browser se valide que el valor ingresado es un valor numérico.**

  <img src="img/esoTilin.png" alt="esoTilin">

  <img src="img/wowTilin.png" alt="wowTilin">

<img src="img/vayaTilin.png" alt="vayaTilin">

- **Qué diferencia observa al usar *POST* y *GET*?**  
Al utilizar el método **GET** el input debe tener el mismo nombre del parametro que recibe mientras que el **POST**  no recibe parametros y no devuelve nada al formulario. 

- **¿Qué se está viendo implementación de los métodos de la clase Service?**
El metodo **getTodo** hace un llamado a la URL para que devuelva una lista con los elementos en formato .json, **todoToHTMLRow** se encarga de construir la organización de cada fila de la tabla para que en **todosToHTMLTable** una todas las filas y devuelva la de forma completa y permita ir agregando filas en cada actualización.

- **Abra la aplicación en un explorador. Realice algunas pruebas de aceptación con la aplicación.<br>**
**Al hacer click en submit**
<img src="img/pruebaA.png" alt="aceptacion">
**Al hacer click en reset**
<img src="img/pruebaR.png" alt="aceptacion">

- **Abra la aplicación en dos computadores diferentes. Si no dispone de uno, hágalo en dos navegadores diferentes (por ejemplo Chrome y Firefox; incluso se puede en un único navegador usando una ventana normal y una ventana de incógnito / privada). Haga cinco intentos en uno, y luego un intento en el otro. ¿Qué valor tiene cada uno?**<br>
<br>
*Al abrir la aplicacion en Google Chrome*
<img src="img/chrome.png">
*Al abrir la aplicacion en Edge*
<img src="img/edge.png">
*Al abrir la aplicacion en Incognito*
<img src="img/incognito.png">
Al abrir la aplicacion en diferentes navegadores se guardan los datos anteriormente ingresados en los otros navegadores

- **Aborte el proceso de Tomcat-runner haciendo Ctrl+C en la consola, y modifique el código del backing-bean de manera que use la anotación @SessionScoped en lugar de @ApplicationScoped. Reinicie la aplicación y repita el ejercicio anterior.
Dado la anterior, ¿Cuál es la diferencia entre los backing-beans de sesión y los de aplicación?**
<br>
La diferencia es que ya no se guardan los datos ingresados en otros navegadores

- **Ubique el código HTML generado por el servidor**
<img src="img/html.png">
- **Busque el elemento oculto, que contiene el número generado aleatoriamente**
<img src="img/html.png">
- En la sección de estilos, deshabilite el estilo que oculta el elemento para que sea visible.
- Observe el cambio en la página, cada vez que se realiza un cambio en el estilo.
- Revise qué otros estilos se pueden agregar a los diferentes elementos y qué efecto tienen en la visualización de la página.
- Actualice la página. Los cambios de estilos realizados desaparecen, pues se realizaron únicamente en la visualización, la respuesta del servidor sigue siendo la misma, ya que el contenido de los archivos allí almacenados no se ha modificado.
- Revise qué otros cambios se pueden realizar y qué otra información se puede obtener de las herramientas de desarrollador.
