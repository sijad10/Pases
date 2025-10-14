package pe.gob.sucamec.pases.servicio;

import pe.gob.sucamec.pases.modelo.Rol;

import java.util.List;

public interface iRolServicio {
    List<Rol> listarRoles();
    Rol buscarRolPorId(Long idRol);
    Rol guardarRol(Rol rol);
    Rol eliminarRol(Long idRol);
}
