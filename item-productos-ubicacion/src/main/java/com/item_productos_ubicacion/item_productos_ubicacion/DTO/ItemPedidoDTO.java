package com.item_productos_ubicacion.item_productos_ubicacion.DTO;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ItemPedidoDTO extends RepresentationModel<ItemPedidoDTO>{
    private Integer id;
    private Integer cantidad;
    private Integer pedido_id;
    private ProductoDTO producto;
}
