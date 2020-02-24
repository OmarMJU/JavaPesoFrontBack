# Proyecto CtrlPes.

##  Piloto stack JSJTM.

Pruebas para stack con Docker
Ten la libertad de hacer feedback, cambios, mejoras y mandame tus Pull Request.

# Requisitos
Para poder correr este proyecto es necesario usar **Docker** y crear una imagen con el archivo ```Dockerfile``` haciendo uso del comando 
```
docker -t build _NombreImagen_ .
```

Poterior a ello se requiere ejecutar el contenedor de la imagen creada.

```
docker run --name _NombreContenedor_ -p 8080:8080 -d _NombreImagen_
```

### Happy Hacking!!