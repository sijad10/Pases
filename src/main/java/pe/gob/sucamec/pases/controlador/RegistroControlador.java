package pe.gob.sucamec.pases.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sucamec.pases.modelo.Registro;
import pe.gob.sucamec.pases.servicio.iRegistroServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroControlador {

    private static final Logger logger = LoggerFactory.getLogger(RegistroControlador.class);

    @Autowired
    private iRegistroServicio registroServicio;

    @GetMapping
    public List<Registro> obtenerRegistros() {
        return registroServicio.listarRegistros();
    }

    @GetMapping("/{id}")
    public Registro obtenerRegistroPorId(@PathVariable Long id) {
        return registroServicio.buscarRegistroPorId(id);
    }

    @PostMapping
    public Registro agregarRegistro(@RequestBody Registro registro) {
        return registroServicio.guardarRegistro(registro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> actualizarRegistro(@PathVariable Long id, @RequestBody Registro registro) {
        Registro existente = registroServicio.buscarRegistroPorId(id);

        // Actualiza campos (ajusta según reglas de negocio)
        existente.setSistema(registro.getSistema());
        existente.setModulo(registro.getModulo());
        existente.setCambio(registro.getCambio());
        existente.setProgramador(registro.getProgramador());
        existente.setFechaSolicitud(registro.getFechaSolicitud());
        existente.setEstado(registro.getEstado());
        existente.setResponsable(registro.getResponsable());
        existente.setFechaPase(registro.getFechaPase());
        existente.setMotivo(registro.getMotivo());
        existente.setDetalleMotivo(registro.getDetalleMotivo());
        existente.setActivo(registro.getActivo());

        registroServicio.guardarRegistro(existente);
        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> eliminarRegistro(@PathVariable Long id) {
        registroServicio.eliminarRegistro(id);
        return Map.of("eliminar", Boolean.TRUE);
    }
}
