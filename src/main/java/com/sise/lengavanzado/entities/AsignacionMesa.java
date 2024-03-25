package com.sise.lengavanzado.entities;
import com.sise.lengavanzado.shared.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "asignacion_mesas")
public class AsignacionMesa extends BaseEntity {

    @Id
    @Column(name = "id_asignacion_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacionMesa;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "turno")
    private String turno;
}
