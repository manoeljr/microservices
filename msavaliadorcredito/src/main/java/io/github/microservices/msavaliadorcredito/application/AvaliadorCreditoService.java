package io.github.microservices.msavaliadorcredito.application;


import feign.FeignException;
import io.github.microservices.msavaliadorcredito.application.ex.DadosClienteNotFoundException;
import io.github.microservices.msavaliadorcredito.application.ex.ErroComunicacaoMicroservicesException;
import io.github.microservices.msavaliadorcredito.domain.model.CartaoCliente;
import io.github.microservices.msavaliadorcredito.domain.model.DadosCliente;
import io.github.microservices.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.microservices.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.microservices.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException{
        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceClient.getCartoesByCliente(cpf);

            return SituacaoCliente
                    .builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(cartoesResponse.getBody())
                    .build();
        }catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}