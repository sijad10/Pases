package pe.gob.sucamec.pases.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sucamec.pases.modelo.Rol;
import pe.gob.sucamec.pases.servicio.iRolServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolControlador {

    private static final Logger logger = LoggerFactory.getLogger(RolControlador.class);

    @Autowired
    private iRolServicio rolServicio;

    @GetMapping
    public List<Rol> obtenerRoles() {
        return rolServicio.listarRoles();
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable Long id) {
        return rolServicio.buscarRolPorId(id);
    }

    @PostMapping
    public Rol agregarRol(@RequestBody Rol rol) {
        return rolServicio.guardarRol(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol existente = rolServicio.buscarRolPorId(id);
        existente.setUsuario(rol.getUsuario());
        existente.setPerfil(rol.getPerfil());
        existente.setActivo(rol.getActivo());
        rolServicio.guardarRol(existente);
        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> eliminarRol(@PathVariable Long id) {
        rolServicio.eliminarRol(id);
        return Map.of("eliminar", Boolean.TRUE);
    }
}
