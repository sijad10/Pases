package pe.gob.sucamec.pases.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sucamec.pases.excepcion.ResourceNotFoundException;
import pe.gob.sucamec.pases.modelo.Registro;
import pe.gob.sucamec.pases.repositorio.RegistroRepositorio;

import java.util.List;

@Service
@Transactional
public class RegistroServicio implements iRegistroServicio{

    private final Logger logger = LoggerFactory.getLogger(RegistroServicio.class);
    private final RegistroRepositorio registroRepositorio;

    public RegistroServicio(RegistroRepositorio registroRepositorio) {
        this.registroRepositorio = registroRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registro> listarRegistros() {
        logger.debug("Listando registros");
        return registroRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Registro buscarRegistroPorId(Long idRegistro) {
        logger.debug("Buscando registro por id: {}", idRegistro);
        return registroRepositorio.findById(idRegistro)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no encontrado con id: " + idRegistro));
    }

    @Override
    public Registro guardarRegistro(Registro registro) {
        logger.debug("Guardando registro: {}", registro);
        return registroRepositorio.save(registro);
    }

    @Override
    public Registro eliminarRegistro(Long idRegistro) {
        logger.debug("Eliminando registro con id: {}", idRegistro);
        Registro r = buscarRegistroPorId(idRegistro);
        registroRepositorio.delete(r);
        return r;
    }
}
