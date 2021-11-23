function agregar() {

    if ($("#username").val() == "" || $("#useremail").val() == "" || $("#password").val() == "" || $("#passwordrepeat").val() == "") {
        alert("Debes llenar todos los campos")
    } else if ($("#password").val() != $("#passwordrepeat").val()) {
        alert("Las contraseñas deben coincidir")
    } else {
        //Capturar valores de los campos en el documento html
        var datos = {
            name: $("#username").val(),
            email: $("#useremail").val(),
            password: $("#password").val()
        }

        //Convertimos a JSON
        let datosPeticion = JSON.stringify(datos);

        //Hacemos petición Ajax
        $.ajax({
            url: "http://155.248.209.168:8080/api/user/new",
            data: datosPeticion,
            type: 'POST',
            contentType: "application/JSON",

            success: function(respuesta) {
                console.log("Insertado");
                console.log(respuesta);
                alert("cuenta creada");
                //listar();
            },

            error: function(xhr, status) {
                console.log(status, xhr);
                alert("El correo ya existe");
            }
        });
    }


}