package com.sise.lengavanzado.entities;
import com.sise.lengavanzado.shared.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "mesas")
public class Mesa extends BaseEntity {
    @Id
    @Column(name = "id_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "capacidad")
    private Integer capacidad;
}
