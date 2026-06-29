package com.servicio.recepcion.controller;

import java.util.List;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.servicio.recepcion.DTO.DetalleRecepcionDTO;
import com.servicio.recepcion.service.DetalleRecepcionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Detalle Recepción", description = "Operaciones relacionadas con los detalles de recepción")
@RequestMapping("/api/v1/detallerecepcion")
public class DetalleRecepcionController {

    private DetalleRecepcionService service;

    public DetalleRecepcionController(DetalleRecepcionService service) {
        this.service = service;
    }

    @Operation(summary = "Registrar detalle de recepción", description = "Permite crear un nuevo detalle de recepción")
    @PostMapping
    public ResponseEntity<DetalleRecepcionDTO> guardar(@RequestBody DetalleRecepcionDTO dto) {

        try {
            DetalleRecepcionDTO response = service.guardarDetalleRecepcion(dto);

            if (response == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "Buscar detalle por ID", description = "Obtiene un detalle de recepción según su identificador")
    @GetMapping("/{id}")
    public ResponseEntity<DetalleRecepcionDTO> buscarPorId(@PathVariable Integer id) {
        try {
            DetalleRecepcionDTO dto = service.buscarPorId(id);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "Buscar detalle por un estado", description = "Obtiene un detalle de recepción según estado")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<DetalleRecepcionDTO>> buscarPorestado(@PathVariable String estado) {
        try {

            List<DetalleRecepcionDTO> dto = service.buscarPorEstado(estado);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "Eliminar detalle por ID", description = "Borrar un detalle de recepción según su identificador")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDetalle(@PathVariable Integer id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Detalle eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el detalle");
        }
    }

    @Operation(summary = "Actualizar detalle por ID", description = "Se actualiza un detalle de recepción según su identificador")
    @PutMapping("/{id}")
    public void actualizarDetalle(@PathVariable Integer id, @RequestBody DetalleRecepcionDTO detalle) {
        service.actualizarDetalleRecepcion(id, detalle);
    }

    @Operation(summary = "Buscar detalle por un Producto_id", description = "Obtiene un detalle de recepción según el ID de un producto")
    @GetMapping("/producto/{id}")
    public ResponseEntity<DetalleRecepcionDTO> buscarPorIdProductoExternoDTO(@PathVariable Integer id) {
        try {
            DetalleRecepcionDTO dto = service.buscarPorProductoId(id);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

}
