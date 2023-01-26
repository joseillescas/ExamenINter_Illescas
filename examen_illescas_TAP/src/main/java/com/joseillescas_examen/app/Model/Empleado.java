package com.joseillescas_examen.app.Model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "empleado")

public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;

	@Column
    (name = "apellido", length = 45, nullable = false)
    private String apellido;
	
    @Column
    (name = "nombre", length = 45, nullable = false)
    private String nombre;


    @Column(name = "telefono", length = 15, nullable = false, unique = true)
    private String telefono;

    @Column(name = "direccion", length = 45, nullable = false)
    private String direccion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date Fecha_nacimiento;
    
    @Column
    (name = "observacion", length = 45, nullable = false)
    private String observacion;
    
    @Column
    (name = "dias_trabajo", length = 5, nullable = false)
    private Integer dias_trabajo;
    
    @Column
    
    (name = "sueldo", nullable = false)
    private  double sueldo;
    
    
}
