package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.DespachoDTO;
import com.proyecto.evaluacion3.model.Despacho;
import com.proyecto.evaluacion3.repository.DespachoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DespachoServiceTest {

    @Mock
    private DespachoRepository repository;

    @Mock
    private DespachoValidaciones validaciones;

    @InjectMocks
    private DespachoService despachoService;

    @Test
    void buscarPorId_Exitoso() {
        Despacho despachoFalso = new Despacho();
        despachoFalso.setId(1);

        DespachoDTO dtoEsperado = new DespachoDTO();
        dtoEsperado.setId(1);

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(despachoFalso));
        Mockito.when(validaciones.convertirADTO(despachoFalso)).thenReturn(dtoEsperado);

        DespachoDTO resultado = despachoService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void guardar_Exitoso() {
        Despacho nuevoDespacho = new Despacho();

        Despacho despachoGuardado = new Despacho();
        despachoGuardado.setId(2);

        DespachoDTO dtoEsperado = new DespachoDTO();
        dtoEsperado.setId(2);

        Mockito.when(repository.save(Mockito.any(Despacho.class))).thenReturn(despachoGuardado);
        Mockito.when(validaciones.convertirADTO(despachoGuardado)).thenReturn(dtoEsperado);

        DespachoDTO resultado = despachoService.guardar(nuevoDespacho);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }

    @Test
    void obtenerTodos_Exitoso() {
        Despacho despacho1 = new Despacho();
        despacho1.setId(1);

        Despacho despacho2 = new Despacho();
        despacho2.setId(2);

        DespachoDTO dto1 = new DespachoDTO();
        dto1.setId(1);

        DespachoDTO dto2 = new DespachoDTO();
        dto2.setId(2);

        Mockito.when(repository.findAll()).thenReturn(java.util.List.of(despacho1, despacho2));
        Mockito.when(validaciones.convertirADTO(despacho1)).thenReturn(dto1);
        Mockito.when(validaciones.convertirADTO(despacho2)).thenReturn(dto2);

        java.util.List<DespachoDTO> resultado = despachoService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(1, resultado.get(0).getId());
        assertEquals(2, resultado.get(1).getId());
    }

    @Test
    void actualizar_Exitoso() {
        Despacho despachoViejo = new Despacho();
        despachoViejo.setId(1);

        Despacho datosNuevos = new Despacho();
        datosNuevos.setId(1);

        DespachoDTO dtoEsperado = new DespachoDTO();
        dtoEsperado.setId(1);

        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(despachoViejo));
        Mockito.when(repository.save(Mockito.any(Despacho.class))).thenReturn(datosNuevos);
        Mockito.when(validaciones.convertirADTO(datosNuevos)).thenReturn(dtoEsperado);

        DespachoDTO resultado = despachoService.actualizar(1, datosNuevos);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void eliminar_Exitoso() {
        Mockito.doNothing().when(repository).deleteById(1);
        despachoService.eliminar(1);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1);
    }
}