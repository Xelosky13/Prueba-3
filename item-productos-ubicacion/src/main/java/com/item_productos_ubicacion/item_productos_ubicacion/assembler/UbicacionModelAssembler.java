package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.item_productos_ubicacion.item_productos_ubicacion.DTO.UbicacionDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.UbicacionController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UbicacionModelAssembler extends RepresentationModelAssemblerSupport<UbicacionDTO, UbicacionDTO> {
    public UbicacionModelAssembler() {
        super(UbicacionController.class, UbicacionDTO.class);
    }
    @Override
    public UbicacionDTO toModel(UbicacionDTO dto) {
        dto.add(linkTo(methodOn(UbicacionController.class).buscarPorId(dto.getId())).withSelfRel());
        dto.add(linkTo(methodOn(UbicacionController.class).obtenerTodas()).withRel("todas-las-ubicaciones"));
        return dto;
    }
}