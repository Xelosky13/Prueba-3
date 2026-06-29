package com.servicio.recepcion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.servicio.recepcion.model.OrdenRecepcion;

public interface OrdenRecepcionRepository extends JpaRepository<OrdenRecepcion, Integer> {

    public OrdenRecepcion findByfechaRecepcion(LocalDate fechaRecepcion);

    @Query("SELECT o FROM OrdenRecepcion o WHERE o.proveedor.id = :idProveedor")
    public List<OrdenRecepcion> buscarProveedorId(@Param("idProveedor") Integer idProveedor);

}
