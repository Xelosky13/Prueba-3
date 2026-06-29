package com.servicio.recepcion.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.servicio.recepcion.DTO.ProveedorDTO;
import com.servicio.recepcion.model.Proveedor;
import com.servicio.recepcion.service.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/proveedor")
public class ProveedorController {

    private ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @PostMapping()
    @Operation(summary = "Registrar Proveedor", description = "Permite crear un nuevo proveedor")
    public ResponseEntity<ProveedorDTO> guardar(@RequestBody ProveedorDTO dto) {
        try {
            ProveedorDTO response = service.guardarProveedor(dto);
            if (response == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Proveedor", description = "Permite obtener un  proveedor por su ID")
    public ResponseEntity<ProveedorDTO> buscarPorId(@PathVariable Integer id) {
        try {
            ProveedorDTO dto = service.buscarPorId(id);
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "Buscar Proveedor por nombre", description = "obtener un proveedor por su nombre")
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProveedorDTO>> buscarPornombre(@PathVariable String nombre) {
        try {
            List<ProveedorDTO> dto = service.buscarPorNombre(nombre);
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "buscar por orden", description = "obtiene un proveedor por un orden_id")
    @GetMapping("/orden/{id}")
    public ProveedorDTO buscarPorOrdenes(@PathVariable Integer id) {
        return service.buscarPorOrdenes(id);

    }

    @Operation(summary = "Listar Proveedores", description = "Obtiene una lista de proveedor")
    @GetMapping()
    public ResponseEntity<List<ProveedorDTO>> proveedores() {
        try {
            return ResponseEntity.ok(service.proveedores());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(summary = "Eliminar Proveedor", description = "Permite eliminar un proveedor por su identificador")
    @DeleteMapping("/{id}")
    public void eliminarProveedor(Integer id) {
        try {
            service.eliminarProveedor(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Operation(summary = "Actualizar Proveedor", description = "Permite actualizar un proveedor por su ID")
    @PutMapping("/{id}")
    public void actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor pro) {
        try {
            service.actualizarProveedor(id, pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
