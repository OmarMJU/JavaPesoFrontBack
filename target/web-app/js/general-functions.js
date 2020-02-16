(function() {
  window.addEventListener("load", function() {
    var contenedorPadre = document.getElementById("contenedor-padre");
    var contenedorHijo = document.getElementById("contenedor-hijo");
    var arregloVentana = obtenerResolucionVentana();

    contenedorPadre.style.height = arregloVentana[1] + "px";

    modificaDimensionElemento(contenedorHijo, 70, "ancho");
  }, false);
})();
