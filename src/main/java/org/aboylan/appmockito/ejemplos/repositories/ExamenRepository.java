package org.aboylan.appmockito.ejemplos.repositories;

import org.aboylan.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen examen);

    List<Examen> findAll();
}
