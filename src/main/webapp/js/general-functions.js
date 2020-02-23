/**
 * Funciones generales para el proyecto.
 * Omar M. Juarez.
 * 23/02/2020
 */

 /**
  * Funcion que redimenciona a los elementos contenedores.
  */
(function() {
  window.addEventListener("load", function() {
    var contenedorPadre = document.getElementById("contenedor-padre");
    var contenedorHijo = document.getElementById("contenedor-hijo");
    var arregloVentana = obtenerResolucionVentana();

    contenedorPadre.style.height = arregloVentana[1] + "px";

    modificaDimensionElemento(contenedorHijo, 70, "ancho");
  }, false);
})();
