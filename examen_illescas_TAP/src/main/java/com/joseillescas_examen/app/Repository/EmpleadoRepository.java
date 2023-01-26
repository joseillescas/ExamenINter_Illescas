package com.joseillescas_examen.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joseillescas_examen.app.Model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	@Query(value = "Select * from empleado emp where emp.id_empleado = :id_empleado", nativeQuery = true)
    public Empleado buscarCliente(Integer id);
}
