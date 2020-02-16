(function() {
  "use srtict";

  window.addEventListener("load", function() {
    var formulario = document.getElementsByClassName("needs-validation");
    var validaciones = Array.prototype.filter.call(formulario, function(form) {

      form.addEventListener("submit", function(event) {
        var formvalidate = form.id;

        if(form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        } else {
          if(formvalidate === "form-login") createRequestJsonLogin(event);
          else if(formvalidate ===  "form-singup") createRequestJsonSingup(event);
        }

        form.classList.add("was-validated");
      }, false);
    });
  }, false);
})();