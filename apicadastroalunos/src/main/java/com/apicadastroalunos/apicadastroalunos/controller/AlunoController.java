package com.apicadastroalunos.apicadastroalunos.controller;

import com.apicadastroalunos.apicadastroalunos.model.Aluno;
import com. apicadastroalunos.apicadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca a classe como um controller REST
@RequestMapping("/alunos") // Define a rota base da API

public class AlunoController {
     @Autowired // Injeta automaticamente o repositório
    private AlunoRepository alunoRepository;

    // GET /alunos — Lista todos os alunos
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll(); // Busca todos no banco
    }

    // GET /alunos/{id} — Busca aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> ResponseEntity.ok().body(aluno)) // Se encontrado, retorna aluno
                .orElse(ResponseEntity.notFound().build()); // Se não, 404
    }

    // POST /alunos — Cadastra um novo aluno
    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno); // Salva no banco
    }

    // PUT /alunos/{id} — Atualiza dados de um aluno
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno novoAluno) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(novoAluno.getNome());
                    aluno.setEmail(novoAluno.getEmail());
                    alunoRepository.save(aluno);
                    return ResponseEntity.ok(aluno);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /alunos/{id} — Remove um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    alunoRepository.delete(aluno);
                    return ResponseEntity.noContent().<Void>build(); // Retorna 204 No Content
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

