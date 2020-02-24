# Proyecto CtrlPes.

##  Piloto stack JSJTM.

Pruebas para stack con Docker
Ten la libertad de hacer feedback, cambios, mejoras y mandame tus Pull Request.

# Requisitos
Para poder correr este proyecto es necesario usar **Docker** y crear una imagen con el archivo ```Dockerfile``` haciendo uso del comando 
```
docker -t build javaapp .
```
Poterior a ello se requiere ejecutar el contenedor de la imagen creada.
```
docker run --name Java_App_Container -p 8080:8080 -d javaapp
```
Despues es necesario abrir un navegador y colocar ```localhost:8080```.

Esperamos que disfrutes desrrollar y corregir los hallazgos e inicidencias de este proyecto.
### Happy Hacking!!