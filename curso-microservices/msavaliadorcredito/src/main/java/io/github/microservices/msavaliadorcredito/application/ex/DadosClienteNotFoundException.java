package io.github.microservices.msavaliadorcredito.application.ex;

public class DadosClienteNotFoundException extends Exception{
    public DadosClienteNotFoundException() {
        super("Dados do cliente não encontrado para o CPF informado.");
    }
}
