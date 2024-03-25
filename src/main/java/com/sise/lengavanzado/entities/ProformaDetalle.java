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
@Table(name = "proforma_detalles")
public class ProformaDetalle extends BaseEntity{
    @Id
    @Column(name = "id_profrorma_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProformaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_proforma")
    private Proforma proforma;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_unitario")
    private Float precioUnitario;

}
