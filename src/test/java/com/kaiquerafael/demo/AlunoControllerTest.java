package com.kaiquerafael.demo;

import com.kaiquerafael.demo.controllers.AlunoController;
import com.kaiquerafael.demo.models.Aluno;
import com.kaiquerafael.demo.services.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

public class AlunoControllerTest {

    private AlunoService alunoService;
    private AlunoController alunoController;

    @BeforeEach
    public void setup() {
        alunoService = mock(AlunoService.class);
        alunoController = new AlunoController();
        try {
            var field = AlunoController.class.getDeclaredField("alunoService");
            field.setAccessible(true);
            field.set(alunoController, alunoService);
        } catch (Exception e) {
            fail("Erro ao configurar o mock: " + e.getMessage());
        }
    }

    @Test
    public void testCadastrar() {
        Aluno aluno = new Aluno();
        when(alunoService.save(aluno)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoController.cadastrar(aluno);

        assertEquals(CREATED, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }

    @Test
    public void testAtualizar() {
        Aluno aluno = new Aluno();
        when(alunoService.save(aluno)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoController.atualizar(aluno);

        assertEquals(OK, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }

    @Test
    public void testDeletar() {
        String id = "123";

        ResponseEntity<Void> response = alunoController.deletar(id);

        verify(alunoService, times(1)).deleteById(id);
        assertEquals(NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testListarTodos() {
        List<Aluno> lista = Arrays.asList(new Aluno(), new Aluno());
        when(alunoService.findAll()).thenReturn(lista);

        ResponseEntity<List<Aluno>> response = alunoController.listarTodos();

        assertEquals(OK, response.getStatusCode());
        assertEquals(lista, response.getBody());
    }

    @Test
    public void testBuscarPorId() {
        String id = "456";
        Optional<Aluno> alunoOptional = Optional.of(new Aluno());
        when(alunoService.findById(id)).thenReturn(alunoOptional);

        ResponseEntity<Optional<Aluno>> response = alunoController.buscarPorId(id);

        assertEquals(OK, response.getStatusCode());
        assertEquals(alunoOptional, response.getBody());
    }
}

