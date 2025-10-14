package pe.gob.sucamec.pases.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sucamec.pases.excepcion.ResourceNotFoundException;
import pe.gob.sucamec.pases.modelo.Usuario;
import pe.gob.sucamec.pases.repositorio.UsuarioRepositorio;

import java.util.List;

@Service
@Transactional
public class UsuarioServicio implements iUsuarioServicio {
    private final Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        logger.debug("Listando todos los usuarios");
        return usuarioRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        logger.debug("Buscando usuario por id: {}", idUsuario);
        return usuarioRepositorio.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + idUsuario));
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        logger.debug("Guardando usuario: {}", usuario);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario eliminarUsuario(Long idUsuario) {
        logger.debug("Eliminando usuario con id: {}", idUsuario);
        Usuario u = buscarUsuarioPorId(idUsuario); // lanzará excepción si no existe
        usuarioRepositorio.delete(u);
        return u;
    }
}
