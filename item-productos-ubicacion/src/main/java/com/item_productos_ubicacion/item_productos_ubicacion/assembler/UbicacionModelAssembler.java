package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.UbicacionDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.UbicacionController;
import com.item_productos_ubicacion.item_productos_ubicacion.model.Ubicacion;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UbicacionModelAssembler extends RepresentationModelAssemblerSupport<Ubicacion, UbicacionDTO> {

    public UbicacionModelAssembler() {
        super(UbicacionController.class, UbicacionDTO.class);
    }

    @Override
    public UbicacionDTO toModel(Ubicacion entity) {
        UbicacionDTO dto = new UbicacionDTO();
        
        dto.setId(entity.getId());
        dto.setPasillo(entity.getPasillo());
        dto.setEstante(entity.getEstante());
        dto.setDescripcion(entity.getDescripcion());
        
        dto.add(linkTo(methodOn(UbicacionController.class).buscarPorId(entity.getId())).withSelfRel());
        
        dto.add(linkTo(methodOn(UbicacionController.class).obtenerTodas()).withRel("todas-las-ubicaciones"));
        
        return dto;
    }
}