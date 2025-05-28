package com.apicadastroalunos.apicadastroalunos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity //diz que a classe é uma tabela no banco.
@Table(name = "alunos") //define o nome da tabela.
@Data

public class Aluno {

    @Id //marcam a PK e que ela é auto_increment.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // marcam a PK e que ela é auto_increment.
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "nome_aluno", nullable = false) // especifica o nome real no banco e se é obrigatório.
    private String nome;

    @Column(name = "email_aluno") //especifica o nome real no banco e se é obrigatório.
    private String email;
}

