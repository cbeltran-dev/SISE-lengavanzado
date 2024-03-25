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
@Table(name = "proformas")
public class Proforma extends BaseEntity {
    @Id
    @Column(name = "id_proforma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProforma;

    @ManyToOne
    @JoinColumn(name = "id_asignacion_mesa")
    private AsignacionMesa asignacionMesa;

    @Column(name = "codigo_proforma")
    private String codigoProforma;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "precio_total")
    private Float precioTotal;

    @Column(name = "observaciones")
    private String observaciones;

}
