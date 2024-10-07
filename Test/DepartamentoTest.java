import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {

    @org.junit.jupiter.api.Test
    void getId() {
        Departamento departamento = new Departamento(1, "Departamento 1", "Jefe 1", "Descripcion 1");
        assertEquals(1, departamento.getId());
    }

    @org.junit.jupiter.api.Test
    void getNombre() {
        Departamento departamento = new Departamento(1, "Departamento 1", "Jefe 1", "Descripcion 1");
        assertEquals("Departamento 1", departamento.getNombre());
    }

    @org.junit.jupiter.api.Test
    void getJefe() {
        Departamento departamento = new Departamento(1, "Departamento 1", "Jefe 1", "Descripcion 1");
        assertEquals("Jefe 1", departamento.getJefe());
    }

    @org.junit.jupiter.api.Test
    void getDescripcion() {
        Departamento departamento = new Departamento(1, "Departamento 1", "Jefe 1", "Descripcion 1");
        assertEquals("Descripcion 1", departamento.getDescripcion());
    }

}
