package pe.gob.sucamec.pases.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO", schema = "PASES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USUARIO")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "PASES.SEQ_USUARIO", allocationSize = 1)
    @Column(name = "ID", nullable = false, precision = 18)
    private Long id;

    @Column(name = "USUARIO", length = 20, nullable = false)
    private String usuario;

    @Column(name = "NOMBRES", length = 20, nullable = false)
    private String nombres;

    @Column(name = "APE_PAT", length = 20, nullable = false)
    private String apePat;

    @Column(name = "APE_MAT", length = 20, nullable = false)
    private String apeMat;

    /**
     * En el DDL es NUMBER(1). Lo mapeo a Boolean para mayor claridad.
     * Valores DB esperados: 1 = true, 0 = false. Hibernate realizará la conversión.
     * Si prefieres Integer cambia el tipo.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
}
