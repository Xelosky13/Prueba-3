package com.item_productos_ubicacion.item_productos_ubicacion.DTO;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoDTO extends RepresentationModel<ProductoDTO> {
    private Integer id;
    private String nombre;
    private String sku;
    private Integer stockActual;
    private UbicacionDTO ubicacion;
}
