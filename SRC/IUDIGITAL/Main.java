package IUDIGITAL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
    private List<Empleado> empleados;
    private List<Departamento> departamentos;
    private JTextArea displayArea;

    public Main() {
        empleados = new ArrayList<>();
        departamentos = new ArrayList<>();
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        setTitle("Gestión de Empleados y Departamentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Botones
        JButton btnEmpleado = new JButton("Gestionar Empleados");
        JButton btnDepartamento = new JButton("Gestionar Departamentos");

        btnEmpleado.addActionListener(e -> manejarEmpleados());
        btnDepartamento.addActionListener(e -> manejarDepartamentos());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEmpleado);
        buttonPanel.add(btnDepartamento);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void manejarEmpleados() {
        String[] options = {"Crear", "Modificar", "Eliminar", "Mostrar", "Asignar a Departamento", "Generar Reporte de Desempeño"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Seleccione una opción:",
                "Gestionar Empleados", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (seleccion) {
            case "Crear":
                crearEmpleado();
                break;
            case "Modificar":
                modificarEmpleado();
                break;
            case "Eliminar":
                eliminarEmpleado();
                break;
            case "Mostrar":
                mostrarEmpleados();
                break;
            case "Asignar a Departamento":
                asignarEmpleadoADepartamento();
                break;
            case "Generar Reporte de Desempeño":
                generarReporteDesempenioEmpleado();
                break;
        }
    }

    private void crearEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID:"));
        String nombre = JOptionPane.showInputDialog(this, "Nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
        String sexo = JOptionPane.showInputDialog(this, "Sexo:");
        String fechaContratacion = JOptionPane.showInputDialog(this, "Fecha de Contratación:");
        String tipo = JOptionPane.showInputDialog(this, "Tipo (Permanente/Temporal):");

        if (tipo.equalsIgnoreCase("Permanente")) {
            String beneficios = JOptionPane.showInputDialog(this, "Beneficios:");
            double salarioBase = Double.parseDouble(JOptionPane.showInputDialog(this, "Salario Base:"));
            empleados.add(new EmpleadoPermanente(id, nombre, edad, sexo, fechaContratacion, beneficios, salarioBase));
        } else {
            String fechaFinalContrato = JOptionPane.showInputDialog(this, "Fecha Final de Contrato:");
            double tasaPorHora = Double.parseDouble(JOptionPane.showInputDialog(this, "Tasa por Hora:"));
            empleados.add(new EmpleadoTemporal(id, nombre, edad, sexo, fechaContratacion, fechaFinalContrato, tasaPorHora));
        }

        displayArea.append("Empleado creado: " + nombre + "\n");
    }

    private void modificarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a modificar:"));
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre:", empleado.getNombre());
                empleado.setNombre(nuevoNombre);

                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog(this, "Nueva Edad:", empleado.getEdad()));
                empleado.setEdad(nuevaEdad);

                String nuevoSexo = JOptionPane.showInputDialog(this, "Nuevo Sexo:", empleado.getSexo());
                empleado.setSexo(nuevoSexo);

                String nuevaFechaContratacion = JOptionPane.showInputDialog(this, "Nueva Fecha de Contratación:", empleado.getFechaContratacion());
                empleado.setFechaContratacion(nuevaFechaContratacion);

                displayArea.append("Empleado modificado: " + nuevoNombre + "\n");
                return;
            }
        }
        displayArea.append("ID de empleado inválido.\n");
    }

    private void eliminarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:"));
        empleados.removeIf(empleado -> empleado.getId() == id);
        displayArea.append("Empleado con ID " + id + " eliminado.\n");
    }

    private void mostrarEmpleados() {
        displayArea.append("Lista de Empleados:\n");
        for (Empleado empleado : empleados) {
            empleado.mostrarDetalles(displayArea);
        }
    }

    private void asignarEmpleadoADepartamento() {
        if (empleados.isEmpty()) {
            displayArea.append("No hay empleados disponibles para asignar.\n");
            return;
        }
        if (departamentos.isEmpty()) {
            displayArea.append("No hay departamentos disponibles para asignar.\n");
            return;
        }

        int empId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado:"));
        int deptId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento:"));

        // Buscar el empleado
        Empleado empleadoSeleccionado = null;
        for (Empleado empleado : empleados) {
            if (empleado.getId() == empId) {
                empleadoSeleccionado = empleado;
                break;
            }
        }

        if (empleadoSeleccionado == null) {
            displayArea.append("Empleado con ID " + empId + " no encontrado.\n");
            return;
        }

        // Buscar el departamento
        Departamento departamentoSeleccionado = null;
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == deptId) {
                departamentoSeleccionado = departamento;
                break;
            }
        }

        if (departamentoSeleccionado == null) {
            displayArea.append("Departamento con ID " + deptId + " no encontrado.\n");
            return;
        }

        // Asignar el empleado al departamento
        empleadoSeleccionado.asignarDepartamento(departamentoSeleccionado);
        displayArea.append("Empleado " + empleadoSeleccionado.getNombre() + " asignado al departamento " + departamentoSeleccionado.getNombre() + ".\n");
    }

    private void generarReporteDesempenioEmpleado() {
        int empId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado:"));
        for (Empleado empleado : empleados) {
            if (empleado.getId() == empId) {
                int puntaje = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el puntaje del desempeño:"));
                String observaciones = JOptionPane.showInputDialog(this, "Ingrese observaciones:");

                ReporteDesempeio reporte = new ReporteDesempeio(new Date(), puntaje, observaciones, empleado, empleado.getDepartamento());

                displayArea.append("Reporte de Desempeño para " + empleado.getNombre() + ":\n");
                displayArea.append("Puntaje: " + reporte.getPuntaje() + "\n");
                displayArea.append("Observaciones: " + reporte.getObservaciones() + "\n");
                displayArea.append("Fecha de Generación: " + reporte.getFechaGeneracion() + "\n\n");
                return;
            }
        }
        displayArea.append("ID de empleado inválido.\n");
    }

    private void manejarDepartamentos() {
        String[] options = {"Crear", "Modificar", "Eliminar", "Mostrar", "Mostrar Empleados", "Generar Reporte de Desempeño"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Seleccione una opción:",
                "Gestionar Departamentos", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (seleccion) {
            case "Crear":
                crearDepartamento();
                break;
            case "Modificar":
                modificarDepartamento();
                break;
            case "Eliminar":
                eliminarDepartamento();
                break;
            case "Mostrar":
                mostrarDepartamentos();
                break;
            case "Mostrar Empleados":
                mostrarEmpleadosPorDepartamento();
                break;
            case "Generar Reporte de Desempeño":
                generarReporteDesempenioDepartamento();
                break;
        }
    }

    private void crearDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID:"));
        String nombre = JOptionPane.showInputDialog(this, "Nombre:");
        String jefe = JOptionPane.showInputDialog(this, "Jefe:");
        String descripcion = JOptionPane.showInputDialog(this, "Descripción:");

        departamentos.add(new Departamento(id, nombre, jefe, descripcion));
        displayArea.append("Departamento creado: " + nombre + "\n");
    }

    private void modificarDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento a modificar:"));
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre:", departamento.getNombre());
                departamento.setNombre(nuevoNombre);

                String nuevoJefe = JOptionPane.showInputDialog(this, "Nuevo Jefe:", departamento.getJefe());
                departamento.setJefe(nuevoJefe);

                String nuevaDescripcion = JOptionPane.showInputDialog(this, "Nueva Descripción:", departamento.getDescripcion());
                departamento.setDescripcion(nuevaDescripcion);

                displayArea.append("Departamento modificado: " + nuevoNombre + "\n");
                return;
            }
        }
        displayArea.append("ID de departamento inválido.\n");
    }

    private void eliminarDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento a eliminar:"));
        departamentos.removeIf(departamento -> departamento.getId() == id);
        displayArea.append("Departamento con ID " + id + " eliminado.\n");
    }

    private void mostrarDepartamentos() {
        displayArea.append("Lista de Departamentos:\n");
        for (Departamento departamento : departamentos) {
            displayArea.append("ID: " + departamento.getId() + ", Nombre: " + departamento.getNombre() + "\n");
        }
    }

    private void mostrarEmpleadosPorDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento:"));
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                displayArea.append("Empleados en el departamento " + departamento.getNombre() + ":\n");
                for (Empleado empleado : departamento.getEmpleados()) {
                    displayArea.append("- " + empleado.getNombre() + "\n");
                }
                return;
            }
        }
        displayArea.append("ID de departamento inválido.\n");
    }

    private void generarReporteDesempenioDepartamento() {
        int deptId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento:"));
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == deptId) {
                int puntaje = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el puntaje del desempeño:"));
                String observaciones = JOptionPane.showInputDialog(this, "Ingrese observaciones:");

                ReporteDesempeio reporte = new ReporteDesempeio(new Date(), puntaje, observaciones, null, departamento);

                displayArea.append("Reporte de Desempeño para el departamento " + departamento.getNombre() + ":\n");
                displayArea.append("Puntaje: " + reporte.getPuntaje() + "\n");
                displayArea.append("Observaciones: " + reporte.getObservaciones() + "\n");
                displayArea.append("Fecha de Generación: " + reporte.getFechaGeneracion() + "\n\n");
                return;
            }
        }
        displayArea.append("ID de departamento inválido.\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}