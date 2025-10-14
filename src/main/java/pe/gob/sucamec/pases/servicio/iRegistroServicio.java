package pe.gob.sucamec.pases.servicio;

import pe.gob.sucamec.pases.modelo.Registro;

import java.util.List;

public interface iRegistroServicio {
    List<Registro> listarRegistros();
    Registro buscarRegistroPorId(Long idRegistro);
    Registro guardarRegistro(Registro registro);
    Registro eliminarRegistro(Long idRegistro);
}
