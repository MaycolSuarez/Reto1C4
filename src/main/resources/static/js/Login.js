//import * as variables from './Variables';

function validar() {
    //Capturar valores de los campos en el documento html

    if ($("#Useremail").val() == "" || $("#password").val() == "") {
        alert("Debes llenar todos los campos");
    } else {
        var datos = {
            email: $("#Useremail").val(),
            password: $("#password").val()
        }

        //Convertimos a JSON
        let datosPeticion = JSON.stringify(datos);

        //Hacemos petición Ajax
        $.ajax({
            url: "http://155.248.209.168:8080/api/user/" + datos.email + "/" + datos.password,
            type: 'GET',
            dataType: 'json',

            success: function(respuesta) {
                console.log("Usuario valido");
                console.log(respuesta);
                alert("Se ha logueado satisfactoriamente")
                    //listar();
            },

            error: function(xhr, status) {
                console.log(status, xhr);
                alert("Usuario o contraseña no validos")
            }
        });
    }

}