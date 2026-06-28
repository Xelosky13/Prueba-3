package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.ItemPedidoDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.ItemPedidoController;
import com.item_productos_ubicacion.item_productos_ubicacion.model.ItemPedido;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
public class ItemPedidoModelAssembler extends RepresentationModelAssemblerSupport<ItemPedido, ItemPedidoDTO> {

    public ItemPedidoModelAssembler(){
        super(ItemPedidoController.class, ItemPedidoDTO.class);
    }

    @Override
    public ItemPedidoDTO toModel(ItemPedido entity){
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setPedido_id(entity.getPedido_id());
        dto.add(linkTo(methodOn(ItemPedidoController.class).buscarPorId(entity.getId())).withSelfRel());
        dto.add(linkTo(methodOn(ItemPedidoController.class).todosLosClientes()).withRel("todos-los-items"));
        return dto;
    }
}
