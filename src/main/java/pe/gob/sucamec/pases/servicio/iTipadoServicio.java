package pe.gob.sucamec.pases.servicio;

import pe.gob.sucamec.pases.modelo.Tipado;

import java.util.List;

public interface iTipadoServicio {
    List<Tipado> listarTipados();
    Tipado buscarTipadoPorId(Long idTipado);
    Tipado guardarTipado(Tipado tipado);
    Tipado eliminarTipado(Long idTipado);
}
