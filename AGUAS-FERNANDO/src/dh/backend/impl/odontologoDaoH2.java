package dh.backend.impl;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;

public class odontologoDaoH2 implements IDao {

    private static final Logger logger = Logger.getLogger(odontologoDaoH2.class);

    private static final String JDBC_URL = "jdbc:h2:~/odontologia;INIT=RUNSCRIPT FROM 'src/main/resources/schema.sql'";

    @Override
    public void guardar(Odontologo odontologo) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)")) {

            ps.setInt(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.executeUpdate();

            logger.info("Odontólogo guardado: " + odontologo);
        } catch (Exception e) {
            logger.error("Error al guardar el odontólogo", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM odontologo");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getInt("matricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
                odontologos.add(odontologo);
            }

            logger.info("Listado de todos los odontólogos: " + odontologos);
        } catch (Exception e) {
            logger.error("Error al listar los odontólogos", e);
        }
        return odontologos;
    }
}
