package com.kaiquerafael.demo.repositories;

import com.kaiquerafael.demo.models.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
