package com.joseillescas_examen.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.joseillescas_examen.app.Model.Empleado;
import com.joseillescas_examen.app.Repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements EmpleadoService{

	@Autowired
    EmpleadoRepository empleadoRepository;
    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoRepository;
    }
}
