package pe.gob.sucamec.pases.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.sucamec.pases.modelo.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {
}
