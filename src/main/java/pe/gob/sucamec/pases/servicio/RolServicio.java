package pe.gob.sucamec.pases.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sucamec.pases.excepcion.ResourceNotFoundException;
import pe.gob.sucamec.pases.modelo.Rol;
import pe.gob.sucamec.pases.repositorio.RolRepositorio;

import java.util.List;

@Service
@Transactional
public class RolServicio implements iRolServicio{

    private final Logger logger = LoggerFactory.getLogger(RolServicio.class);
    private final RolRepositorio rolRepositorio;

    public RolServicio(RolRepositorio rolRepositorio) {
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> listarRoles() {
        logger.debug("Listando roles");
        return rolRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Rol buscarRolPorId(Long idRol) {
        logger.debug("Buscando rol por id: {}", idRol);
        return rolRepositorio.findById(idRol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + idRol));
    }

    @Override
    public Rol guardarRol(Rol rol) {
        logger.debug("Guardando rol: {}", rol);
        return rolRepositorio.save(rol);
    }

    @Override
    public Rol eliminarRol(Long idRol) {
        logger.debug("Eliminando rol con id: {}", idRol);
        Rol r = buscarRolPorId(idRol);
        rolRepositorio.delete(r);
        return r;
    }

}
