package pe.gob.sucamec.pases.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTRO", schema = "PASES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro")
    @SequenceGenerator(name = "seq_registro", sequenceName = "PASES.SEQ_REGISTRO", allocationSize = 1)
    @Column(name = "ID", nullable = false, precision = 18)
    private Long id;

    // sistema_id -> TIPADO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SISTEMA_ID", nullable = false)
    private Tipado sistema;

    // modulo_id -> TIPADO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULO_ID", nullable = false)
    private Tipado modulo;

    @Column(name = "CAMBIO", length = 400, nullable = false)
    private String cambio;

    // programador_id -> USUARIO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGRAMADOR_ID", nullable = false)
    private Usuario programador;

    @Column(name = "FECHA_SOLICITUD", nullable = false)
    private LocalDateTime fechaSolicitud;

    // estado_id -> TIPADO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTADO_ID", nullable = false)
    private Tipado estado;

    // responsable_id -> USUARIO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPONSABLE_ID", nullable = false)
    private Usuario responsable;

    /**
     * En el DDL es NUMBER(18). No es DATE. Lo mapeo a Long (epoch millis).
     * Si en realidad es DATE cámbialo a LocalDateTime y actualizo la anotación.
     */
    @Column(name = "FECHA_PASE")
    private Long fechaPase;

    // motivo_id -> TIPADO(ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOTIVO_ID", nullable = false)
    private Tipado motivo;

    @Column(name = "DETALLE_MOTIVO", length = 300)
    private String detalleMotivo;

    /**
     * En tu DDL es NUMBER(18) (posible flag). Lo mapeo a Integer para preservar rango.
     * Si esperas solo 0/1, cambia a Boolean.
     */
    @Column(name = "ACTIVO")
    private Integer activo;
}
