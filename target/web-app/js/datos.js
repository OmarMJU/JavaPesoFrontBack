function createRequestJsonLogin(e) {
    e.preventDefault();
    var usuarioL = document.getElementById("user");
    var passwordL = document.getElementById("passwordUser");
    var datosUsuarioL = "{\'usuarioID\': \'" + usuarioL.value + "\', \'passwordID\': \'" + passwordL.value + "\'}";

    sendDatasController(datosUsuarioL, "Login_Controller");
}

function createRequestJsonSingup(e) {
    e.preventDefault();
    var nombreReg = document.getElementById("validationTooltip01");
    var apellidoReg = document.getElementById("validationTooltip02");
    var emailReg = document.getElementById("validationTooltip03");
    var passwordReg = document.getElementById("validationTooltip04");
    var datosUsuarioR = "{\'nombreR\': \'" + nombreReg.value + "\', \'apellidoR\': \'" + apellidoReg.value + "\', \'emailR\': \'" + emailReg.value + "\', \'passwordR\': \'" + passwordReg.value + "\'}";

    sendDatasController(datosUsuarioR, "Singup_Controller");
}

function sendDatasController(datasUser, acctionForm) {
    var mnsg;
    var envioObjet = new XMLHttpRequest();

    envioObjet.open("POST", acctionForm, true);
    envioObjet.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    envioObjet.onreadystatechange = function() {
        if(envioObjet.status == 200 && envioObjet.readyState == 4) {
            mnsg = envioObjet.responseText;
            alert(mnsg);
        } else if(envioObjet.status != 200 && envioObjet.readyState == 4) {
            mnsg = envioObjet.responseText;
            alert(mnsg);
        }
    };

    envioObjet.send("datasUser=" + datasUser);
}