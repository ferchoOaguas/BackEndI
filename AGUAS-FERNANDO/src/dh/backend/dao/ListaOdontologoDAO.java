package dh.backend.dao;

import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ListaOdontologoDAO implements IDao{
    private static final Logger logger = Logger.getLogger(ListaOdontologoDAO.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado: " + odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listado de todos los odontólogos: " + odontologos);
        return new ArrayList<>(odontologos);
    }
}
