package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.PedidoDTO;
import com.proyecto.evaluacion3.model.Pedido;
import com.proyecto.evaluacion3.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @Mock
    private PedidoValidaciones pedidoValidaciones;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void buscarPorId_Exitoso() {
        Pedido pedidoFalso = new Pedido();
        pedidoFalso.setId(1);

        PedidoDTO dtoEsperado = new PedidoDTO();
        dtoEsperado.setId(1);

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(pedidoFalso));
        Mockito.when(pedidoValidaciones.convertirADTO(pedidoFalso)).thenReturn(dtoEsperado);

        PedidoDTO resultado = pedidoService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void guardar_Exitoso() {
        Pedido nuevoPedido = new Pedido();

        Pedido pedidoGuardado = new Pedido();
        pedidoGuardado.setId(2);

        PedidoDTO dtoEsperado = new PedidoDTO();
        dtoEsperado.setId(2);

        Mockito.when(repository.save(Mockito.any(Pedido.class))).thenReturn(pedidoGuardado);
        Mockito.when(pedidoValidaciones.convertirADTO(pedidoGuardado)).thenReturn(dtoEsperado);

        PedidoDTO resultado = pedidoService.guardar(nuevoPedido);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }

    @Test
    void obtenerTodos_Exitoso() {
        Pedido pedido1 = new Pedido();
        pedido1.setId(1);

        Pedido pedido2 = new Pedido();
        pedido2.setId(2);

        PedidoDTO dto1 = new PedidoDTO();
        dto1.setId(1);

        PedidoDTO dto2 = new PedidoDTO();
        dto2.setId(2);

        Mockito.when(repository.findAll()).thenReturn(java.util.List.of(pedido1, pedido2));
        Mockito.when(pedidoValidaciones.convertirADTO(pedido1)).thenReturn(dto1);
        Mockito.when(pedidoValidaciones.convertirADTO(pedido2)).thenReturn(dto2);

        java.util.List<PedidoDTO> resultado = pedidoService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(1, resultado.get(0).getId());
        assertEquals(2, resultado.get(1).getId());
    }

    @Test
    void actualizar_Exitoso() {
        Pedido pedidoViejo = new Pedido();
        pedidoViejo.setId(1);

        Pedido datosNuevos = new Pedido();
        datosNuevos.setId(1);

        PedidoDTO dtoEsperado = new PedidoDTO();
        dtoEsperado.setId(1);

        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(pedidoViejo));
        Mockito.when(repository.save(Mockito.any(Pedido.class))).thenReturn(datosNuevos);
        Mockito.when(pedidoValidaciones.convertirADTO(datosNuevos)).thenReturn(dtoEsperado);

        PedidoDTO resultado = pedidoService.actualizar(1, datosNuevos);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void eliminar_Exitoso() {
        Mockito.doNothing().when(repository).deleteById(1);
        pedidoService.eliminar(1);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1);
    }
}