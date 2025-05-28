package com.apicadastroalunos.apicadastroalunos.repository;

// Importa a entidade Aluno do pacote model
import com.apicadastroalunos.apicadastroalunos.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Define que essa interface é um repositório JPA
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Aqui herda métodos como findAll(), findById(), save(), deleteById(), etc.
     // Nenhum método extra necessário — JpaRepository já fornece CRUD completo
} 


