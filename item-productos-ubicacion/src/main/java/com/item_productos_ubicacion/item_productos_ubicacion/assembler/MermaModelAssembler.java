package com.item_productos_ubicacion.item_productos_ubicacion.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.item_productos_ubicacion.item_productos_ubicacion.DTO.MermaDTO;
import com.item_productos_ubicacion.item_productos_ubicacion.controller.MermaController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class MermaModelAssembler extends RepresentationModelAssemblerSupport<MermaDTO, MermaDTO> {
    public MermaModelAssembler() {
        super(MermaController.class, MermaDTO.class);
    }
    @Override
    public MermaDTO toModel(MermaDTO dto) {
        dto.add(linkTo(methodOn(MermaController.class).registrarMerma(null)).withSelfRel());
        return dto;
    }
}
