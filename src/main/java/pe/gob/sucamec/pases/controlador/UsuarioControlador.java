package pe.gob.sucamec.pases.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sucamec.pases.modelo.Usuario;
import pe.gob.sucamec.pases.servicio.iUsuarioServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private iUsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioServicio.buscarUsuarioPorId(id);
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existente = usuarioServicio.buscarUsuarioPorId(id);
        // Actualiza campos permitidos
        existente.setUsuario(usuario.getUsuario());
        existente.setNombres(usuario.getNombres());
        existente.setApePat(usuario.getApePat());
        existente.setApeMat(usuario.getApeMat());
        existente.setActivo(usuario.getActivo());
        usuarioServicio.guardarUsuario(existente);
        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> eliminarUsuario(@PathVariable Long id) {
        usuarioServicio.eliminarUsuario(id);
        return Map.of("eliminar", Boolean.TRUE);
    }
}
