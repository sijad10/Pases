package pe.gob.sucamec.pases.servicio;

import pe.gob.sucamec.pases.modelo.Usuario;

import java.util.List;

public interface iUsuarioServicio {
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorId(Long idUsuario);
    Usuario guardarUsuario(Usuario usuario);
    Usuario eliminarUsuario(Long idUsuario);
}
