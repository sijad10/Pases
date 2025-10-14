package pe.gob.sucamec.pases.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.sucamec.pases.modelo.Tipado;

@Repository
public interface TipadoRepositorio extends JpaRepository<Tipado, Long> {
}
