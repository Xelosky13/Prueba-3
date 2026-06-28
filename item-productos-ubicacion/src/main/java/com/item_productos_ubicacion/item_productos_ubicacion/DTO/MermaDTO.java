package com.item_productos_ubicacion.item_productos_ubicacion.DTO;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MermaDTO extends RepresentationModel<MermaDTO> {
    private Integer id;
    private LocalDate fechaReporte;
    private Integer cantidad;
    private String motivo;
    private ProductoDTO producto;
}
