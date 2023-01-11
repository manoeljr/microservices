package io.github.microservices.msavaliadorcredito.domain.model;


import lombok.Data;

@Data
public class DadosAvaliacao {
    private String cpf;
    private Long renda;
}
