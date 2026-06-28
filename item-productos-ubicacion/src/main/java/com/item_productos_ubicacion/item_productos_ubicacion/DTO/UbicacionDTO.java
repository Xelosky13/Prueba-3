package com.item_productos_ubicacion.item_productos_ubicacion.DTO;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UbicacionDTO extends RepresentationModel<UbicacionDTO> {
    private Integer id;
    private Integer pasillo;
    private Integer estante;
    private String descripcion;
    private List<ProductoDTO> productos;
}
