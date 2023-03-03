package com.softwares.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwares.factory.PedidoFactory;
import com.softwares.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.softwares.utils.Constantes.URI_ENVIAR_REQUISICAO_NOTA_FISCAL;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RequisicaoInvoiceController.class)
public class RequisicaoInvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    PedidoService requisicaoService;

    @Test
    public void deveRetornar201QuandoEnviadoRequisicaoComTodosOsDadosPreenchidos() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(PedidoFactory.pedido01());

        doNothing().when(requisicaoService).enviarRequisicaoNotaFiscal(PedidoFactory.pedido01());

        mockMvc.perform(post(URI_ENVIAR_REQUISICAO_NOTA_FISCAL)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(requisicaoService, times(1))
                .enviarRequisicaoNotaFiscal(PedidoFactory.pedido01());

    }

}
