package com.proyecto.evaluacion3.service;

import com.proyecto.evaluacion3.DTO.OperarioDTO;
import com.proyecto.evaluacion3.model.Operario;
import com.proyecto.evaluacion3.repository.OperarioRepository;
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
public class OperarioServiceTest {

    @Mock
    private OperarioRepository repository;

    @InjectMocks
    private OperarioService operarioService;

    @Test
    void buscarPorId_Exitoso() {
        Operario operario = new Operario();
        operario.setId(1);
        operario.setNombre("Juan");
        operario.setTurno("Mañana");

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(operario));

        OperarioDTO resultado = operarioService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void guardar_Exitoso() {
        Operario operario = new Operario();
        operario.setNombre("Ana");
        operario.setTurno("Noche");

        Operario guardado = new Operario();
        guardado.setId(2);
        guardado.setNombre("Ana");
        guardado.setTurno("Noche");

        Mockito.when(repository.save(Mockito.any(Operario.class))).thenReturn(guardado);

        OperarioDTO resultado = operarioService.guardar(operario);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }

    @Test
    void obtenerTodos_Exitoso() {
        Operario o1 = new Operario();
        o1.setId(1);
        o1.setNombre("Juan");

        Operario o2 = new Operario();
        o2.setId(2);
        o2.setNombre("Ana");

        Mockito.when(repository.findAll()).thenReturn(List.of(o1, o2));

        List<OperarioDTO> resultado = operarioService.obtenerTodos();

        assertEquals(2, resultado.size());
    }
}