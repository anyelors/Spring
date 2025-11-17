// Call the dataTables jQuery plugin
$(document).ready(function() {
    refresh();
});

function refresh() {
    actualizarInfoUsuario();
    cargarUsuarios();
    $('#usuarios').DataTable();
}

function actualizarInfoUsuario() {
    document.getElementById('txtUsuarioEmail').innerHTML = localStorage.email;
}

function getHeader() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

async function cargarUsuarios() {

    const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: getHeader()
    });
    const usuarios = await request.json();
    console.log(usuarios);

    let usuariosHTML = "";
    for (let usuario of usuarios) {
        let botonActualizar = '<a href="#" class="btn btn-success btn-circle btn-sm"><i class="fas fa-check"></i></a>';
        let botonEliminar = '<a href="#" onclick="modalEliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        usuariosHTML += '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+botonActualizar+'&nbsp;&nbsp;'+botonEliminar+'</td></tr>';
    }

    document.querySelector('#usuarios tbody').outerHTML = usuariosHTML;

}

function modalEliminarUsuario(id){
    $('#deleteUser').modal('show');    
    const botonAceptar = document.getElementById('aceptar');

    botonAceptar.addEventListener('click', function handler() {
        eliminarUsuario(id);
        botonAceptar.removeEventListener('click', handler);
    });
}

async function eliminarUsuario(id) {
    const request = await fetch('api/usuarios/'+id, {
            method: 'DELETE',
            headers: getHeader()
    });

    $('#deleteUser').modal('hide');
    location.reload();
}
