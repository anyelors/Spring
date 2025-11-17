// Call the dataTables jQuery plugin
$(document).ready(function() {

    $('#msjModal').on('hidden.bs.modal', function () {
        window.location.href = 'login.html';
    });

});

function closeModal() {
    $('#msjModal').modal('hide');
}

async function registrarUsuario() {

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.telefono = document.getElementById('txtTelefono').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepeatPassword').value;

    if (repetirPassword != datos.password) {
        alert("Contraseñas diferentes")
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    document.getElementById('msj').innerHTML = "Usuario creado correctamente!"
    $('#msjModal').modal('show');

}
