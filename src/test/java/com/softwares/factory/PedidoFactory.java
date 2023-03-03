package com.softwares.factory;

import com.softwares.dto.PedidoDto;

public class PedidoFactory {

    public static PedidoDto pedido01() {
        return PedidoDto.builder()
                .numeroPedido(12345)
                .cliente(ClienteFactory.cliente01())
                .build();
    }
}
