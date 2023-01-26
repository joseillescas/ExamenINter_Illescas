package com.joseillescas_examen.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseillescas_examen.app.Model.Empleado;
import com.joseillescas_examen.app.Service.EmpleadoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
    EmpleadoService empleadoService;
    

    @GetMapping("/listar")
    public ResponseEntity< List<Empleado>> obtenerLista() {
        return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crear(@RequestBody Empleado emp){
     return new ResponseEntity<>(empleadoService.save(emp), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> eliminar(@PathVariable Integer id) {
    	  empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado emp) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	empleado.setApellido(emp.getApellido());
            	empleado.setNombre(emp.getNombre());
            	empleado.setTelefono(emp.getTelefono());
            	empleado.setDireccion(emp.getDireccion());
            	empleado.setFecha_nacimiento(emp.getFecha_nacimiento());
            	empleado.setObservacion(emp.getObservacion());
            	empleado.setDias_trabajo(emp.getDias_trabajo());
            	empleado.setSueldo(emp.getSueldo());
                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
