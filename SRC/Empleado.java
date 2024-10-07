import javax.swing.JTextArea;

public abstract class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private String fechaContratacion;
    private Departamento departamento;

    public Empleado(int id, String nombre, int edad, String sexo, String fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaContratacion = fechaContratacion;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
    }

    public abstract void mostrarDetalles(JTextArea displayArea);

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }

    public void setSexo(String nuevoSexo) {
        this.sexo = nuevoSexo;
    }

    public void setFechaContratacion(String nuevaFechaContratacion) {
        this.fechaContratacion = nuevaFechaContratacion;
    }
}
