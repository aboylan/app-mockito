package org.aboylan.appmockito.ejemplos.services;

import org.aboylan.appmockito.ejemplos.Datos;
import org.aboylan.appmockito.ejemplos.models.Examen;
import org.aboylan.appmockito.ejemplos.repositories.ExamenRepository;
import org.aboylan.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.aboylan.appmockito.ejemplos.repositories.PreguntaRepository;
import org.aboylan.appmockito.ejemplos.repositories.PreguntaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplSpyTest {

    @Spy
    ExamenRepositoryImpl repository;
    @Spy
    PreguntaRepositoryImpl preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @Test
    void testSpy() {
        List<String> preguntas = Arrays.asList("aritmetica");
//        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(preguntas);
        doReturn(preguntas).when(preguntaRepository).findPreguntasPorExamenId(anyLong());
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");

        assertEquals(5, examen.getId());
        assertEquals("Matematicas", examen.getNombre());
        assertEquals(1, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmetica"));

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());
    }
}