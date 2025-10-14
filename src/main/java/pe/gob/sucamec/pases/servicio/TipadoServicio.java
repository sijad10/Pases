package pe.gob.sucamec.pases.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sucamec.pases.excepcion.ResourceNotFoundException;
import pe.gob.sucamec.pases.repositorio.TipadoRepositorio;
import pe.gob.sucamec.pases.modelo.Tipado;

import java.util.List;

@Service
@Transactional
public class TipadoServicio implements iTipadoServicio{
    private final Logger logger = LoggerFactory.getLogger(TipadoServicio.class);
    private final TipadoRepositorio tipadoRepositorio;

    public TipadoServicio(TipadoRepositorio tipadoRepositorio) {
        this.tipadoRepositorio = tipadoRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tipado> listarTipados() {
        logger.debug("Listando tipados");
        return tipadoRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tipado buscarTipadoPorId(Long idTipado) {
        logger.debug("Buscando tipado por id: {}", idTipado);
        return tipadoRepositorio.findById(idTipado)
                .orElseThrow(() -> new ResourceNotFoundException("Tipado no encontrado con id: " + idTipado));
    }

    @Override
    public Tipado guardarTipado(Tipado tipado) {
        logger.debug("Guardando tipado: {}", tipado);
        return tipadoRepositorio.save(tipado);
    }

    @Override
    public Tipado eliminarTipado(Long idTipado) {
        logger.debug("Eliminando tipado con id: {}", idTipado);
        Tipado t = buscarTipadoPorId(idTipado);
        tipadoRepositorio.delete(t);
        return t;
    }
}
