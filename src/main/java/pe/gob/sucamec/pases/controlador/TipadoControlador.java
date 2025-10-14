package pe.gob.sucamec.pases.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sucamec.pases.modelo.Tipado;
import pe.gob.sucamec.pases.servicio.iTipadoServicio;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/tipados")
@CrossOrigin(origins = "*")
public class TipadoControlador {

    private static final Logger logger = LoggerFactory.getLogger(TipadoControlador.class);

    @Autowired
    private iTipadoServicio tipadoServicio;

    @GetMapping
    public List<Tipado> obtenerTipados() {
        return tipadoServicio.listarTipados();
    }

    @GetMapping("/{id}")
    public Tipado obtenerTipadoPorId(@PathVariable Long id) {
        return tipadoServicio.buscarTipadoPorId(id);
    }

    @PostMapping
    public Tipado agregarTipado(@RequestBody Tipado tipado) {
        return tipadoServicio.guardarTipado(tipado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipado> actualizarTipado(@PathVariable Long id, @RequestBody Tipado tipado) {
        Tipado existente = tipadoServicio.buscarTipadoPorId(id);
        existente.setTipoId(tipado.getTipoId());
        existente.setNombre(tipado.getNombre());
        existente.setCodRpog(tipado.getCodRpog());
        existente.setActivo(tipado.getActivo());
        tipadoServicio.guardarTipado(existente);
        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> eliminarTipado(@PathVariable Long id) {
        tipadoServicio.eliminarTipado(id);
        return Map.of("eliminar", Boolean.TRUE);
    }
}
