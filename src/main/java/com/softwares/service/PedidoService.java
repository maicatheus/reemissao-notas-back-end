package com.softwares.service;

import com.softwares.dto.PedidoDto;
import com.softwares.model.Cliente;
import com.softwares.model.Pedido;
import com.softwares.repository.ClienteRepositori;
import com.softwares.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepositori clienteRepositori;

    public void enviarRequisicaoNotaFiscal(PedidoDto pedido01) {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(pedido01,pedido,"cliente","id");
        BeanUtils.copyProperties(pedido01.getCliente(),cliente);
        pedido.setCliente(cliente);
        clienteRepositori.save(cliente);
        Optional<Pedido> pedidoOptional= pedidoRepository.findById(pedido.getId());
        if(!pedidoOptional.isPresent()){
            pedidoRepository.save(pedido);
        }
        else {

        }
    }
}
