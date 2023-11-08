package org.aboylan.appmockito.ejemplos.services;

import org.aboylan.appmockito.ejemplos.models.Examen;

public interface ExamenService {
    Examen findExamenPorNombre(String nombre);
}
