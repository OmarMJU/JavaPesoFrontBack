// FUNCIONES QUE ACTIVAN LOS MODALES PARA EL INICIO DE SESIÓN Y EL REGISTRO DE UN
// NUEVO USUARIO.
// OMAR MAURICIO JUÁREZ URBINA.
// 27/07/2019

// MODAL PARA EL REGISTRO.
var modal = document.getElementById("modalLogin");
var botonLogin = document.getElementById("registro");
var botonCerrar = document.getElementById("cancelarModal");
var form = modal.getElementsByTagName("form")[0];

botonLogin.onclick = function() {
  modal.style.display = "block";
  form.classList.add("needs-validation");
}

botonCerrar.onclick = function() {
  modal.style.display = "none";
  form.classList.remove("needs-validation");
}

// MODAL PARA EL INICIO DE SESIÓN.
var modalSesion = document.getElementById("modalSesion");
var botonSesion = document.getElementById("iniciaSesion");
var botonCanelaSesion = document.getElementById("cancelarModalLogin");
var formSesion = modalSesion.getElementsByTagName("form")[0];

botonSesion.onclick = function() {
  modalSesion.style.display = "block";
  formSesion.classList.add("needs-validation");
}

botonCanelaSesion.onclick = function() {
  modalSesion.style.display = "none";
  formSesion.classList.remove("needs-validation");
}
