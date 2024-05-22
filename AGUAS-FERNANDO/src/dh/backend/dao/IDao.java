package dh.backend.dao;

import dh.backend.model.Odontologo;

import java.util.List;

public interface IDao{
    void guardar (Odontologo odontologo);
    List<Odontologo> listarTodos();
}
