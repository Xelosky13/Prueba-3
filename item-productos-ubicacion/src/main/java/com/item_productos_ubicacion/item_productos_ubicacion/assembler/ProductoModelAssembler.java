package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.ProductoDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.ProductoController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductoModelAssembler extends RepresentationModelAssemblerSupport<ProductoDTO, ProductoDTO> {

    public ProductoModelAssembler() {
        super(ProductoController.class, ProductoDTO.class);
    }

    @Override
    public ProductoDTO toModel(ProductoDTO dto) {
        dto.add(linkTo(methodOn(ProductoController.class).obtenerPorId(dto.getId())).withSelfRel());
        dto.add(linkTo(methodOn(ProductoController.class).listarTodos()).withRel("todos-los-productos"));
        return dto;
    }
}