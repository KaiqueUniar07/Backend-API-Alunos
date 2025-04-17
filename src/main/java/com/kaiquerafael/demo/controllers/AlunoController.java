package com.kaiquerafael.demo.controllers;

import com.kaiquerafael.demo.constant.Constant;
import com.kaiquerafael.demo.models.Aluno;
import com.kaiquerafael.demo.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(Constant.API_ALUNO)
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {
        Aluno alunoSalvo = alunoService.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PutMapping(Constant.API_ALUNO)
    public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.save(aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping(Constant.API_ALUNO + "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(Constant.API_ALUNO)
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping(Constant.API_ALUNO + "/{id}")
    public ResponseEntity<Optional<Aluno>> buscarPorId(@PathVariable("id") String id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }
}