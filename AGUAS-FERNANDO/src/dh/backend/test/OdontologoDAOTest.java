package dh.backend.test;

import dh.backend.dao.IDao;
import dh.backend.dao.ListaOdontologoDAO;
import dh.backend.model.Odontologo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OdontologoDAOTest {
    private IDao odontologoH2DAO;
    private IDao odontologoListDAO;

    @Before
    public void setUp() {
        odontologoH2DAO = new ListaOdontologoDAO();
        odontologoListDAO = new ListaOdontologoDAO();
    }

    @Test
    public void testGuardarYListarOdontologosH2() {
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Ana", "Gomez");

        odontologoH2DAO.guardar(odontologo1);
        odontologoH2DAO.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoH2DAO.listarTodos();

        assertEquals(2, odontologos.size());
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Ana", odontologos.get(1).getNombre());
    }

    @Test
    public void testGuardarYListarOdontologosList() {
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Ana", "Gomez");

        odontologoListDAO.guardar(odontologo1);
        odontologoListDAO.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoListDAO.listarTodos();

        assertEquals(2, odontologos.size());
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Ana", odontologos.get(1).getNombre());
    }
}
