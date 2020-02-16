/**
* ARCHIVO DE FUNCIONES GENERALES PARA EL PROYECTO.
* OMAR M. JUAREZ.
* 23/06/2019
*/

/**
* Calcula el alto y el ancho de la pantalla del
* cliente que navege en el sitio web.
*/
function obtenerResolucionPantalla() {
  var altoPantalla = window.screen.height;
  var anchoPantalla = window.screen.width;
  var arregloRes = new Array(2);

  arregloRes[0] = anchoPantalla;
  arregloRes[1] = altoPantalla;

  return arregloRes;
}

/**
* Calcula el ancho y el alto de la venta en la cual se navega
* en el sitio web.
*/
function obtenerResolucionVentana() {
  var altoVentana = null;
  var anchoVentana = null;
  var arregloRes = new Array(2);

  if(typeof window.innerWidth != undefined) {
    anchoVentana = window.innerWidth;
    altoVentana =  window.innerHeight;
  } else if(typeof document.documentElement != undefined && typeof document.documentElement.clientWidth != undefined && document.documentElement.clientWidth > 0) {
      anchoVentana = document.documentElement.clientWidth;
      altoVentana = document.documentElement.clientHeight;
  } else {
    anchoVentana = document.body.clientWidth;
    altoVentana = document.body.clientHeight;
  }

  arregloRes[0] = anchoVentana;
  arregloRes[1] = altoVentana;

  return arregloRes;
}

/*
* Redimenciona el elemanto especificado al porcentaje.
*/
function modificaDimensionElemento(elemento, porcentajeModificar, anchoAlto) {
  var decimal = porcentajeModificar/100;

  if(anchoAlto === "ancho") {
    var anchoElement = elemento.offsetWidth;
    elemento.style.width = anchoElement * decimal + "px";
  } else if(anchoAlto === "alto") {
    var altoElement = elemento.offsetHeight;
    elemento.style.height = altoElement * decimal + "px";
  } else if(anchoAlto === "ambos") {
    var anchoElement = elemento.offsetWidth;
    var altoElement = elemento.offsetHeight;

    elemento.style.width = anchoElement * decimal + "px";
    elemento.style.height = altoElement * decimal + "px";
  }
}
