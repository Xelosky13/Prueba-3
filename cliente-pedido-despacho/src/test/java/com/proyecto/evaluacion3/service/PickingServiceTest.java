package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.PickingDTO;
import com.proyecto.evaluacion3.model.Picking;
import com.proyecto.evaluacion3.repository.PickingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PickingServiceTest {

    @Mock
    private PickingRepository repository;

    @Mock
    private PickingValidaciones validaciones;

    @InjectMocks
    private PickingService pickingService;

    @Test
    void buscarPorId_Exitoso() {
        Picking pickingFalso = new Picking();
        pickingFalso.setId(1);

        PickingDTO dtoEsperado = new PickingDTO();
        dtoEsperado.setId(1);

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(pickingFalso));
        Mockito.when(validaciones.convertirADTO(pickingFalso)).thenReturn(dtoEsperado);

        PickingDTO resultado = pickingService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void guardar_Exitoso() {
        Picking nuevoPicking = new Picking();
        Picking guardado = new Picking();
        guardado.setId(2);

        PickingDTO dtoEsperado = new PickingDTO();
        dtoEsperado.setId(2);

        Mockito.when(repository.save(Mockito.any(Picking.class))).thenReturn(guardado);
        Mockito.when(validaciones.convertirADTO(guardado)).thenReturn(dtoEsperado);

        PickingDTO resultado = pickingService.guardar(nuevoPicking);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }

    @Test
    void obtenerTodos_Exitoso() {
        Picking p1 = new Picking();
        p1.setId(1);
        Picking p2 = new Picking();
        p2.setId(2);

        PickingDTO dto1 = new PickingDTO();
        dto1.setId(1);
        PickingDTO dto2 = new PickingDTO();
        dto2.setId(2);

        Mockito.when(repository.findAll()).thenReturn(List.of(p1, p2));
        Mockito.when(validaciones.convertirADTO(p1)).thenReturn(dto1);
        Mockito.when(validaciones.convertirADTO(p2)).thenReturn(dto2);

        List<PickingDTO> resultado = pickingService.obtenerTodos();

        assertEquals(2, resultado.size());
        assertEquals(1, resultado.get(0).getId());
    }
}