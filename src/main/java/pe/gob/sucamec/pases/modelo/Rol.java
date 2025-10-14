package pe.gob.sucamec.pases.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROL", schema = "PASES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"USUARIO_ID", "PERFIL_ID"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rol")
    @SequenceGenerator(name = "seq_rol", sequenceName = "PASES.SEQ_ROL", allocationSize = 1)
    @Column(name = "ID", nullable = false, precision = 18)
    private Long id;

    // FK -> USUARIO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    // FK -> TIPADO(ID) (perfil)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERFIL_ID", nullable = false)
    private Tipado perfil;

    /**
     * En tu DDL es NUMBER(1). Lo mapeo a Boolean.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
}
