/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departamento;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombre;
    private String jefe;
    private String descripcion;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre, String jefe, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.jefe = jefe;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getJefe() {
        return jefe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setJefe(String nuevoJefe) {
        this.jefe = nuevoJefe;
    }

    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
}

