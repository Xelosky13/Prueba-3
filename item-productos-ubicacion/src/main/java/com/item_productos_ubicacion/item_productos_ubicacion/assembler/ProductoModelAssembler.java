package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.ProductoDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.ProductoController;
import com.item_productos_ubicacion.item_productos_ubicacion.model.Producto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductoModelAssembler extends RepresentationModelAssemblerSupport<Producto, ProductoDTO> {

    public ProductoModelAssembler() {
        super(ProductoController.class, ProductoDTO.class);
    }

    @Override
    public ProductoDTO toModel(Producto entity) {
        ProductoDTO dto = new ProductoDTO();
        
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSku(entity.getSku());
        dto.setStockActual(entity.getStock_actual());
        
        dto.add(linkTo(methodOn(ProductoController.class).obtenerPorId(entity.getId())).withSelfRel());
        
        dto.add(linkTo(methodOn(ProductoController.class).listarTodos()).withRel("todos-los-productos"));
        
        return dto;
    }
}