package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.ItemPedidoDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.ItemPedidoController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ItemPedidoModelAssembler extends RepresentationModelAssemblerSupport<ItemPedidoDTO, ItemPedidoDTO> {

    public ItemPedidoModelAssembler(){
        super(ItemPedidoController.class, ItemPedidoDTO.class);
    }

    @Override
    public ItemPedidoDTO toModel(ItemPedidoDTO dto){

        dto.add(linkTo(methodOn(ItemPedidoController.class).buscarPorId(dto.getId())).withSelfRel());
        dto.add(linkTo(methodOn(ItemPedidoController.class).todosLosClientes()).withRel("todos-los-items"));
        return dto;
    }
}