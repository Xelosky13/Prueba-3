package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.ClienteDTO;
import com.proyecto.evaluacion3.model.Cliente;
import com.proyecto.evaluacion3.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void buscarPorId_Exitoso() {
        Cliente clienteFalso = new Cliente();
        clienteFalso.setId(1);
        clienteFalso.setNombre("Juan Perez");
        clienteFalso.setRut("11222333-4");

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(clienteFalso));

        ClienteDTO resultado = clienteService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombre());
        assertEquals(1, resultado.getId());
    }

    @Test
    void guardar_Exitoso() {
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setNombre("Maria Lopez");
        clienteNuevo.setRut("9876543-2");

        Cliente clienteGuardado = new Cliente();
        clienteGuardado.setId(2);
        clienteGuardado.setNombre("Maria Lopez");
        clienteGuardado.setRut("9876543-2");

        Mockito.when(repository.save(Mockito.any(Cliente.class))).thenReturn(clienteGuardado);

        ClienteDTO resultado = clienteService.guardar(clienteNuevo);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
        assertEquals("Maria Lopez", resultado.getNombre());
    }

    @Test
    void obtenerTodos_Exitoso() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Juan Perez");
        cliente1.setRut("11222333-4");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Maria Lopez");
        cliente2.setRut("9876543-2");

        Mockito.when(repository.findAll()).thenReturn(java.util.List.of(cliente1, cliente2));

        java.util.List<ClienteDTO> resultado = clienteService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Juan Perez", resultado.get(0).getNombre());
        assertEquals("Maria Lopez", resultado.get(1).getNombre());
    }
}