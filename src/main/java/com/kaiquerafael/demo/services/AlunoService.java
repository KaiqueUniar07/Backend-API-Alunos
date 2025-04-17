package com.kaiquerafael.demo.services;

import com.kaiquerafael.demo.models.Aluno;
import com.kaiquerafael.demo.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(String id) {
        return alunoRepository.findById(id);
    }

    public void deleteById(String id) {
        alunoRepository.deleteById(id);
    }
}
