package pe.gob.sucamec.pases.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPADO", schema = "PASES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "COD_RPOG")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tipado {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipado")
    @SequenceGenerator(name = "seq_tipado", sequenceName = "PASES.SEQ_TIPADO", allocationSize = 1)
    @Column(name = "ID", nullable = false, precision = 18)
    private Long id;

    /**
     * En el DDL 'tipo_id' no aparece como FK. Lo mantengo como referencia numérica.
     * Si es FK a la misma tabla (jerarquía), se puede mapear a @ManyToOne Tipado parent.
     */
    @Column(name = "TIPO_ID")
    private Long tipoId;

    @Column(name = "NOMBRE", length = 200, nullable = false)
    private String nombre;

    @Column(name = "COD_RPOG", length = 20, nullable = false)
    private String codRpog;

    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
}
