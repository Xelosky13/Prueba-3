package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.MermaDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.MermaController;
import com.item_productos_ubicacion.item_productos_ubicacion.model.Merma;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class MermaModelAssembler extends RepresentationModelAssemblerSupport<Merma, MermaDTO> {
    
    public MermaModelAssembler() {
        super(MermaController.class, MermaDTO.class);
    }

    @Override
    public MermaDTO toModel(Merma entity) {
        MermaDTO dto = new MermaDTO();
        
        dto.setId(entity.getId());
        dto.setFechaReporte(entity.getFechaReporte());
        dto.setCantidad(entity.getCantidad());
        dto.setMotivo(entity.getMotivo());
        dto.add(linkTo(methodOn(MermaController.class).registrarMerma(null)).withRel("registrar-merma"));
        
        return dto;
    }

}
