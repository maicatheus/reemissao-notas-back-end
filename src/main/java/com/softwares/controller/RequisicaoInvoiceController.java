package com.softwares.controller;

import com.softwares.dto.PedidoDto;
import com.softwares.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RequisicaoInvoiceController {

    @Autowired
    PedidoService  pedidoService;

    @PostMapping(value = "/requisicao-nota-fiscal")
    public ResponseEntity<Void> enviarRequisicaoDeNotaFiscal(@RequestBody PedidoDto pedidoDto){
        pedidoService.enviarRequisicaoNotaFiscal(pedidoDto);
        return ResponseEntity.noContent().build();
    }
}
